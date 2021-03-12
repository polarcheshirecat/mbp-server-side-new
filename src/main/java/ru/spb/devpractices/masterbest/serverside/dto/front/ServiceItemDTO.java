package ru.spb.devpractices.masterbest.serverside.dto.front;

import lombok.Data;

import java.io.Serializable;

@Data
public class ServiceItemDTO implements Serializable {

    public ServiceItemDTO (String name){
        this.setName(name);
    }

    private String name;
    private String price;

}
