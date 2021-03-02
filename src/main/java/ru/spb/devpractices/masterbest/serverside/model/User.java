package ru.spb.devpractices.masterbest.serverside.model;import lombok.Data;import lombok.ToString;import ru.spb.devpractices.masterbest.serverside.model.order.OrderStatus;import javax.persistence.*;import java.io.Serializable;@ToString@Entity@Table(name ="users")@Datapublic class User implements Serializable {    @Id    @Column(name ="id")    private Long id;    @Column(name ="name")    private String name;    @Column(name="current_status")    @Enumerated(EnumType.STRING)    private UserStatus currentStatus = UserStatus.FREE;    @Column(name="future_status")    @Enumerated(EnumType.STRING)    private UserStatus futureStatus;    @Column(name="username")    private String username;    @Column(name="password")    private String password;    @Column(name = "active")    private Boolean active = true;    @Column(name="role")    @Enumerated(EnumType.STRING)    private UserRole role = UserRole.USER;}