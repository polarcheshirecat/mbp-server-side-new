package ru.spb.devpractices.masterbest.serverside.services.model;

import org.springframework.stereotype.Service;
import ru.spb.devpractices.masterbest.serverside.model.order.OrderStatus;
import ru.spb.devpractices.masterbest.serverside.model.order.OrderUserStatus;
import ru.spb.devpractices.masterbest.serverside.repo.OrderUserStatusRepo;

@Service
public class OrderUserStatusService {

    private final OrderUserStatusRepo statusRepo;

    public OrderUserStatusService(OrderUserStatusRepo statusRepo) {
        this.statusRepo = statusRepo;
    }

    public void save (OrderUserStatus orderUserStatus){
        statusRepo.save(orderUserStatus);
    }

    public OrderStatus getOrderStatusByUserIdAndNumberIkea (Long userId, String numberIkea){
       return statusRepo.findOrderUserStatusByUserIdAndNumberIkea(userId, numberIkea);
    }
}
