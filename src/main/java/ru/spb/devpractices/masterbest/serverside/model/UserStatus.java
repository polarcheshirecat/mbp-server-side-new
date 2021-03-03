package ru.spb.devpractices.masterbest.serverside.model;import ru.spb.devpractices.masterbest.serverside.model.order.OrderStatus;import java.util.Arrays;public enum UserStatus {    Free("Свободен"),    InWork ("Приступил"),    Suspended("Доделка"),    Weekend("Выходной")    ;    private String description;    UserStatus(String description) {        this.description = description;    }    public String getDescription() {        return description;    }    public static UserStatus getStatusByDescription (String description){        return Arrays.stream(values()).filter(status -> {            return status.getDescription().equalsIgnoreCase(description);        }).findFirst().get();    }}