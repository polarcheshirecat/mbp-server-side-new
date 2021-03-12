package ru.spb.devpractices.masterbest.serverside.dto.front;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderStatusDTO implements Serializable {

    private String userId;
    private String numberIkea;
    private String numberMB;
    private String status;
    private String comment;

}
