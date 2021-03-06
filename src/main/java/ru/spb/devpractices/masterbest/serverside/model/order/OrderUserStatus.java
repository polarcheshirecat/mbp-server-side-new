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
    @Column(name = "number_ikea")
    private String numberIkea;

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "guid")
    private String guid;


    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "comment")
    private String comment;




}
