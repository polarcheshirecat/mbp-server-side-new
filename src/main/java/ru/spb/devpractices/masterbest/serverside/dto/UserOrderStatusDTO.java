package ru.spb.devpractices.masterbest.serverside.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserOrderStatusDTO implements Serializable {
    private String userID;
    private String orderNumber;
    private String status;
    private String comment;

}
