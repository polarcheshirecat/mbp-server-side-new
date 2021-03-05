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
    @Column(name = "guid")
    private String guid;

    @Id
    @Column(name = "userId")
    private Long userId;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "comment")
    private String comment;




}
