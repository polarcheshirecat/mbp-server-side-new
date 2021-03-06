package ru.spb.devpractices.masterbest.serverside.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    private static final String message = "Запрашиваемый пользователь не найден в базе данных мобильного приложения";

    @Override
    public String getMessage() {
        return message;
    }

}
