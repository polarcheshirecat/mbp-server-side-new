package ru.spb.devpractices.masterbest.serverside.services.model;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import ru.spb.devpractices.masterbest.serverside.exceptions.OrderNotFoundException;import ru.spb.devpractices.masterbest.serverside.model.User;import ru.spb.devpractices.masterbest.serverside.model.order.Order;import ru.spb.devpractices.masterbest.serverside.repo.OrdersRepo;@Servicepublic class OrderService {    @Autowired    private OrdersRepo ordersRepo;    public Order getOrder (String ikea_number) {        return ordersRepo.findById(ikea_number).orElseThrow(OrderNotFoundException::new);    }    public Order saveOrder(Order order) {        return ordersRepo.save(order);    }}