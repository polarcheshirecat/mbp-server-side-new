package ru.spb.devpractices.masterbest.serverside.dto.front;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderDTO implements Serializable {

    private String ikeaNumber;
    private String numberMB;
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
