package ru.spb.devpractices.masterbest.serverside.controllers;import lombok.extern.slf4j.Slf4j;import org.springframework.http.HttpStatus;import org.springframework.http.ResponseEntity;import org.springframework.web.bind.annotation.*;import ru.spb.devpractices.masterbest.serverside.dto.OrderDTO;import ru.spb.devpractices.masterbest.serverside.dto.OrderStatusDTO;import ru.spb.devpractices.masterbest.serverside.exceptions.OrderNotFoundException;import ru.spb.devpractices.masterbest.serverside.exceptions.UserNotFoundException;import ru.spb.devpractices.masterbest.serverside.mappers.OrderMapper;import ru.spb.devpractices.masterbest.serverside.model.User;import ru.spb.devpractices.masterbest.serverside.model.order.Order;import ru.spb.devpractices.masterbest.serverside.model.order.OrderStatus;import ru.spb.devpractices.masterbest.serverside.services.model.OrdersService;import ru.spb.devpractices.masterbest.serverside.services.model.UserService;import java.util.ArrayList;import java.util.List;import java.util.Map;@Slf4j@RestController@RequestMapping("/orderservice")public class OrdersController {    private final OrdersService ordersService;    private final UserService userService;    private final OrderInfoMapper orderInfoMapper;    private final OrderMapper orderMapper;    public OrdersController(OrdersService ordersService,                            UserService userService,                            OrderInfoMapper orderInfoMapper,                            OrderMapper orderMapper) {        this.ordersService = ordersService;        this.userService = userService;        this.orderInfoMapper = orderInfoMapper;        this.orderMapper = orderMapper;    }   @CrossOrigin   @RequestMapping (value = "/getAllNewOrders", params = {"userId"})    public ResponseEntity<?> getAllNewOrders (@RequestParam(value = "userId") String userId){        if (!checkIfUserExists(userId)){            return ResponseEntity.notFound().build();        }        List<OrderInfoDTO> dtoList = new ArrayList<>();        Map<Order, OrderStatus> ordersMap = ordersService.getAllOrdersByUserId(Long.valueOf(userId), false);        for (Order order: ordersMap.keySet()){            OrderInfoDTO orderInfoDTO = orderInfoMapper.toDto(order);            orderInfoDTO.setOrderStatus(ordersMap.get(order).getDescription());            dtoList.add(orderInfoDTO);        }        return new ResponseEntity<>(dtoList, HttpStatus.OK);    }    @CrossOrigin    @RequestMapping (value = "/getOrder", params = {"orderId"})    public ResponseEntity<?> getOrder (@RequestParam(value = "orderId") String orderId) {        Order order = null;        try {            order = ordersService.getOrder(orderId);        } catch (OrderNotFoundException ex){            log.error("Заказ с номером " + orderId +                    " не найден в БД приложения", ex);            return ResponseEntity.notFound().build();        }        OrderDTO orderDTO = orderMapper.orderToOrderDto(order);        return new ResponseEntity<>(orderDTO, HttpStatus.OK);    }    @CrossOrigin    @RequestMapping(value = "/setOrderStatus",            method = RequestMethod.POST)    public ResponseEntity<?> setOrderStatus(@RequestBody OrderStatusDTO dto){        return ordersService.setOrderStatus(dto);    }    private boolean checkIfUserExists (String userId) {        User user = null;        try {            user = userService.getUserById(Long.valueOf(userId));        } catch (UserNotFoundException ex ){            log.error("Пользователь " + userId +                    " не найден в БД приложения", ex);            return false;        }        return true;    }}