package ru.spb.devpractices.masterbest.serverside.mappers;

import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Service;
import ru.spb.devpractices.masterbest.serverside.dto.front.OrderStatusDTO;
import ru.spb.devpractices.masterbest.serverside.model.order.Order;
import ru.spb.devpractices.masterbest.serverside.model.order.OrderStatus;
import ru.spb.devpractices.masterbest.serverside.model.order.OrderUserStatus;
import ru.spb.devpractices.masterbest.serverside.services.model.OrdersService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderUserStatusMapper {

    public List<OrderUserStatus> toEntitiesList (OrderStatusDTO dto, List<Order> orders){
        List<OrderUserStatus> ret = new ArrayList<>();
        orders.stream().forEach(order -> {
            OrderUserStatus orderUserStatus = new OrderUserStatus();
            orderUserStatus.setNumberIkea(order.getNumberIkea());
            orderUserStatus.setComment(dto.getComment());
            orderUserStatus.setGuid(dto.getGuid());
            orderUserStatus.setUserId(Long.valueOf(dto.getUserId()));
            orderUserStatus.setStatus(OrderStatus.getStatusByDescription(dto.getStatus()));
            ret.add(orderUserStatus);
        });
        return ret;
    }

}
