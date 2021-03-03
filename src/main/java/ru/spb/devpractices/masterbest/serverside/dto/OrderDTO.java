package ru.spb.devpractices.masterbest.serverside.dto;

import lombok.Data;
import ru.spb.devpractices.masterbest.serverside.model.User;
import ru.spb.devpractices.masterbest.serverside.model.order.OrderType;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Data
public class OrderDTO implements Serializable {

    private String ikeaNumber;
    private String mbNumber;
    private String dateStart;
    private String dateEnd;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private String comment;
    private String orderType;
    private String orderStatus;
    List<OrderItemDTO> orderItems;
}
