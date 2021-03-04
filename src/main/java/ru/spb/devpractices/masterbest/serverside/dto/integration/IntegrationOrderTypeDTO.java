package ru.spb.devpractices.masterbest.serverside.dto.integration;

import lombok.Data;

import java.io.Serializable;

@Data
public class IntegrationOrderTypeDTO implements Serializable {

    private String id;
    private String name;
}
