package ru.spb.devpractices.masterbest.serverside.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.spb.devpractices.masterbest.serverside.dto.front.OrderDTO;
import ru.spb.devpractices.masterbest.serverside.dto.front.OrderItemDTO;
import ru.spb.devpractices.masterbest.serverside.dto.front.OrderStatusDataDTO;
import ru.spb.devpractices.masterbest.serverside.dto.front.ServiceItemDTO;
import ru.spb.devpractices.masterbest.serverside.model.order.Order;
import ru.spb.devpractices.masterbest.serverside.model.order.OrderStatus;
import ru.spb.devpractices.masterbest.serverside.model.order.OrderType;
import ru.spb.devpractices.masterbest.serverside.model.order.OrderUserStatus;
import ru.spb.devpractices.masterbest.serverside.services.model.OrderUserStatusService;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    @Autowired
    private OrderItemDTOMapper itemMapper;
    @Autowired
    private OrderUserStatusService statusService;

    private final static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-YYYY hh:mm");

    public OrderDTO toDTO(List<Order> orders){
        if (orders == null || orders.isEmpty()) return null;

        OrderDTO dto = new OrderDTO();
        Set<String> rootNumbers = new HashSet<>();
        orders.stream().forEach(order -> {
            String rootNumber = order.getNumberIkea().substring(0, order.getNumberIkea().indexOf("_"));
            rootNumbers.add(rootNumber);
        });
        String rootNumbersList = rootNumbers.stream().sorted().collect(Collectors.joining(", "));
        dto.setRootNumbers(rootNumbersList);

        Order firstDateStartOrder = orders.stream()
                .sorted(((o1, o2) -> o1.getDateStart().compareTo(o2.getDateStart())))
                .findFirst().get();
        dto.setDateStart(firstDateStartOrder.getDateStart().format(dateTimeFormatter));
        dto.setGuid(firstDateStartOrder.getGuid());
        //status берем по гуиду из таблицы order_user_status
        Long userId = firstDateStartOrder.getUsers().stream().findFirst().get().getId();
        OrderUserStatus status = statusService.getOrderStatusByUserIdAndNumberIkea(userId, firstDateStartOrder.getNumberIkea());

        OrderStatusDataDTO statusDataDTO = new OrderStatusDataDTO();
        statusDataDTO.setStatus(status.getStatus().getDescription());
        statusDataDTO.setArchive(status.getStatus().isHistoryStatus());
        dto.setStatusData(statusDataDTO);

        dto.setDistance(firstDateStartOrder.getRange().toString());
        dto.setCustomerAddress(firstDateStartOrder.getAddress());
        dto.setCustomerName(firstDateStartOrder.getClient());
        dto.setCustomerPhone(firstDateStartOrder.getPhone());
        dto.setCommentFromOperator(firstDateStartOrder.getCommentFromOperator());

        Set<OrderType> orderTypes = orders.stream().map(order -> order.getOrderType())
                .collect(Collectors.toSet());
        List<ServiceItemDTO> serviceItems = orderTypes.stream()
                .map(orderType -> new ServiceItemDTO(orderType.getName()
                        .substring(0, orderType.getName().indexOf("("))))
                .collect(Collectors.toList());
        //TODO когда 1С будет передавать стоимость услуги, добавить сюда парсинг в ДТО
        dto.setServices(serviceItems);

        List<OrderItemDTO> frames = new ArrayList<>();
        List<OrderItemDTO> appliances = new ArrayList<>();
        List<OrderItemDTO> otherItems = new ArrayList<>();
        //собираем номенклатурный состав заказа по след логике:
        //если в имени услуги есть слово "техники", то эти позиции - техника
        //иначе фильтруем по isFrame
        orders.stream().forEach(order -> {
            OrderType orderType = order.getOrderType();
            if (orderType.getName().contains("техники")){
                List<OrderItemDTO> appliancesItems = order.getOrderItems()
                        .stream()
                        .map(orderItem -> itemMapper.toDTO(orderItem))
                        .collect(Collectors.toList());
                appliances.addAll(appliancesItems);
            } else {
                order.getOrderItems().forEach(orderItem -> {
                    if (orderItem.getFrame()) {
                        frames.add(itemMapper.toDTO(orderItem));
                    } else {
                        otherItems.add(itemMapper.toDTO(orderItem));
                    }
                });
            }

        });

        dto.setFrames(frames);
        dto.setAppliances(appliances);
        dto.setOtherItems(otherItems);

        return dto;
    }

}
