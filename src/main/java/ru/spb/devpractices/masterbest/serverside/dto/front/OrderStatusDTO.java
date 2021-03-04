package ru.spb.devpractices.masterbest.serverside.dto.front;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderStatusDTO implements Serializable {

    private String userID;
    private String ikeaNumber;
    private String mbNumber;
    private String status;
    private String comment;

}
