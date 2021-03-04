package ru.spb.devpractices.masterbest.serverside.dto.front;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class OrderItemDTO implements Serializable {

    private String article;
    private String name;
    private String unit;
    private String count;
    private String price;
    private String sum;
    private Boolean isFrame;
    private Boolean isAppliance;

}
