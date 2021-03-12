package ru.spb.devpractices.masterbest.serverside.dto.front;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
public class OrderDTO implements Serializable {

    private Set<String> rootNumbers;
    private String dateStart;
    private String dateEnd;
    public String status;
    private String distance;
    private String customerAddress;
    private String customerName;
    private String customerPhone;
    private String commentFromOperator;
    private String commentFromUser;
    private List<ServiceItemDTO> services;
    private List<OrderItemDTO> frames;
    private List<OrderItemDTO> appliances;
    private List<OrderItemDTO> otherItems;






//
//    private String ikeaNumber;
//    private String numberMB;
//    private String dateStart;
//    private String dateEnd;
//    private String customerName;
//    private String customerAddress;
//    private String customerPhone;
//    private String comment;
//    private String orderType;
//    private String orderStatus;
//    List<OrderItemDTO> orderItems;
}
