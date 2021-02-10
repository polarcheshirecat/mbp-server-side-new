package ru.spb.devpractices.masterbest.serverside.controllers;import org.springframework.http.HttpStatus;import org.springframework.http.MediaType;import org.springframework.http.ResponseEntity;import org.springframework.web.bind.annotation.*;import ru.spb.devpractices.masterbest.serverside.dto.OrderDTO;import ru.spb.devpractices.masterbest.serverside.mappers.OrderMapper;import ru.spb.devpractices.masterbest.serverside.model.User;import ru.spb.devpractices.masterbest.serverside.model.order.Order;import ru.spb.devpractices.masterbest.serverside.services.model.OrderService;import ru.spb.devpractices.masterbest.serverside.services.model.UserService;import java.sql.Timestamp;import java.text.SimpleDateFormat;import java.util.ArrayList;import java.util.Date;import java.util.List;import java.util.stream.Collectors;@RestController@RequestMapping("orders")public class OrdersController {    private final OrderService orderService;    private final UserService userService;    private final OrderMapper mapper;    public OrdersController(OrderService orderService, UserService userService, OrderMapper mapper) {        this.orderService = orderService;        this.userService = userService;        this.mapper = mapper;    }    @GetMapping("{id}")    public OrderDTO getOrder (@PathVariable String id) {        Order order = orderService.getOrder(id);        return mapper.toDto(order);    }    @GetMapping ("/all")    public List<OrderDTO> getOrdersByUserID () {        List<OrderDTO> list = new ArrayList<>();        OrderDTO orderDTO = new OrderDTO();        orderDTO.setIkea_number("1");        orderDTO.setDate_start(dateParser("2011-10-02 09:00"));        orderDTO.setCustomer_address("Бутлерова");        orderDTO.setComment("10 каркасов");        list.add(orderDTO);        orderDTO = new OrderDTO();        orderDTO.setIkea_number("2");        orderDTO.setDate_start(dateParser("2021-02-10 09:00"));        orderDTO.setCustomer_address("Казанская");        orderDTO.setComment("5 каркасов");        list.add(orderDTO);        return list;    }    private Timestamp dateParser (String data){        Timestamp timestamp = null;        try {            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");            Date parsedDate = dateFormat.parse(data);            timestamp = new java.sql.Timestamp(parsedDate.getTime());        } catch(Exception e) {        }        return timestamp;    }}