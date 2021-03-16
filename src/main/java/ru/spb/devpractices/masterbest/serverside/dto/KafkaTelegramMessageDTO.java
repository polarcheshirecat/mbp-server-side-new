package ru.spb.devpractices.masterbest.serverside.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class KafkaTelegramMessageDTO implements Serializable {
    private String telegramId;
    private String message;
}
