package ru.spb.devpractices.masterbest.serverside.services;import lombok.extern.slf4j.Slf4j;import org.springframework.http.HttpStatus;import org.springframework.http.ResponseEntity;import org.springframework.stereotype.Service;import ru.spb.devpractices.masterbest.serverside.dto.IntegrationPushOrderDTO;import ru.spb.devpractices.masterbest.serverside.exceptions.OrderNotFoundException;import ru.spb.devpractices.masterbest.serverside.exceptions.UserNotFoundException;import ru.spb.devpractices.masterbest.serverside.mappers.IntegrationPushOrderMapper;import ru.spb.devpractices.masterbest.serverside.model.User;import ru.spb.devpractices.masterbest.serverside.model.order.Order;import ru.spb.devpractices.masterbest.serverside.model.order.OrderStatus;import ru.spb.devpractices.masterbest.serverside.services.model.OrderHistoryService;import ru.spb.devpractices.masterbest.serverside.services.model.OrdersService;import ru.spb.devpractices.masterbest.serverside.services.model.UserService;@Slf4j@Servicepublic class IntegrationPushOrderService {    private final UserService userService;    private final OrdersService ordersService;    private final IntegrationPushOrderMapper mapper;    private final OrderHistoryService historyService;    public IntegrationPushOrderService(UserService userService, OrdersService ordersService,                                       IntegrationPushOrderMapper mapper,                                       OrderHistoryService historyService) {        this.userService = userService;        this.ordersService = ordersService;        this.mapper = mapper;        this.historyService = historyService;    }    public ResponseEntity<?> proceedPush (IntegrationPushOrderDTO pushDTO){        String logHeader = "proceedPush № " + pushDTO.getOrderNumber() + " ";        ResponseEntity<?> result = null;        //check if push is cancelled push        if (pushDTO.getCancel()){            log.info(logHeader + "Отмена назначения заказа ");            //TODO удалить этот заказ у этого пользователя и отправить пользовтелю пуш            return new ResponseEntity<>(pushDTO, HttpStatus.OK);        }        //check if user exists        User userFromDB = null;        try {            log.info(logHeader + "Проверяю существует ли в базе пользователь  " + pushDTO.getUserID());            userFromDB = userService.getUserById(Long.valueOf(pushDTO.getUserID()));            log.info(logHeader + "Найдем пользователь " + userFromDB.toString());        } catch (UserNotFoundException ex ){            pushDTO.setMessage(ex.getMessage());            result = new ResponseEntity<>(pushDTO, HttpStatus.NOT_FOUND);            log.info(logHeader + "Пользователь не найден. Отправлен request -> " + result.getBody().toString());            return result;        }        //check if order exist        //TODO пользователь открыл заказ, я дергаю 1С чтобы получить полный заказ        Order order = null;        try {            order = ordersService.getOrder(pushDTO.getOrderNumber());        } catch (OrderNotFoundException ex){            order = mapper.toEntity(pushDTO, userFromDB);        }        ordersService.saveOrder(order);        //TODO пуш пользователю        //TODO Логирование        //create history item        historyService.saveHistoryItem(userFromDB, order, OrderStatus.New);        //forming answer        pushDTO.setMessage(HttpStatus.OK.getReasonPhrase());        result = new ResponseEntity<>(pushDTO, HttpStatus.OK);        return result;    }}