package ru.spb.devpractices.masterbest.serverside.dto.front;import lombok.Data;import java.io.Serializable;@Datapublic class UserAuthDTO implements Serializable {    private String username;    private String password;}