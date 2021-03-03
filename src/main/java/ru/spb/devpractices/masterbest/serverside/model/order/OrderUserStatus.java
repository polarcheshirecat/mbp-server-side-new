package ru.spb.devpractices.masterbest.serverside.model.order;

import lombok.Data;
import ru.spb.devpractices.masterbest.serverside.repo.OrderUserStatusId;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table (name = "order_user_status")
@IdClass(OrderUserStatusId.class)
public class OrderUserStatus implements Serializable {

    @Id
    @Column(name = "order_id")
    private String orderId;

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "mb_number")
    private String mbNumber;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "comment")
    private String comment;




}
