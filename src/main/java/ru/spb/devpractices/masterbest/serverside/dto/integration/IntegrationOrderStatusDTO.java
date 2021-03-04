package ru.spb.devpractices.masterbest.serverside.dto.integration;import com.fasterxml.jackson.annotation.JsonProperty;import lombok.AllArgsConstructor;import lombok.Data;import lombok.EqualsAndHashCode;import lombok.NoArgsConstructor;import ru.spb.devpractices.masterbest.serverside.model.User;import ru.spb.devpractices.masterbest.serverside.model.order.Order;import ru.spb.devpractices.masterbest.serverside.model.order.OrderStatus;import java.io.Serializable;@Data@EqualsAndHashCode@AllArgsConstructor@NoArgsConstructorpublic class IntegrationOrderStatusDTO implements Serializable {    private String userId;    private String status;    private String guid;    private String comment;}