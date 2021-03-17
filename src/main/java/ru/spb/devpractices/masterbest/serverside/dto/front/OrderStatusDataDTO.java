package ru.spb.devpractices.masterbest.serverside.dto.front;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderStatusDataDTO implements Serializable {
    private String status;
    private boolean archive;
}
