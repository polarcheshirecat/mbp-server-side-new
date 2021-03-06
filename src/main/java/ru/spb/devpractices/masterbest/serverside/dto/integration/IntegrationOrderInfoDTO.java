package ru.spb.devpractices.masterbest.serverside.dto.integration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class IntegrationOrderInfoDTO implements Serializable {
    private String numberMB;
    private String ikeaNumber;
}