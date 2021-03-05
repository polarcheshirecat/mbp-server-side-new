package ru.spb.devpractices.masterbest.serverside.model.order;import lombok.Data;import lombok.ToString;import ru.spb.devpractices.masterbest.serverside.model.User;import javax.persistence.*;import java.io.Serializable;import java.math.BigDecimal;import java.sql.Timestamp;import java.time.LocalDateTime;import java.util.List;import java.util.Set;@ToString@Entity@Data@Table(name = "orders")public class Order implements Serializable {    @Id    @Column(name ="numberIkea")    private String numberIkea;    @Column(name = "guid")    private String guid;    @Column(name ="numberMB")    private String numberMB;    @Column(name ="dateStart")    private LocalDateTime dateStart;    @Column(name ="dateEnd")    private LocalDateTime dateEnd;    @OneToOne(fetch = FetchType.EAGER)    private OrderType orderType;    @Column(name ="client")    private String client;    @Column(name ="address")    private String address;    @Column(name ="phone")    private String phone;    @Column (name = "range")    private BigDecimal range;    @Column(name ="commentFromOperator")    private String commentFromOperator;    @Column(name ="commentFromUser")    private String commentFromUser;    @ManyToMany (fetch = FetchType.LAZY)    @JoinTable(            name = "orders_users",            joinColumns = @JoinColumn(name = "numberIkea"),            inverseJoinColumns = @JoinColumn(name = "userId"))    private Set<User> users;    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)    @JoinTable (name = "order_cart",            joinColumns = @JoinColumn(name = "numberIkea"),            inverseJoinColumns = @JoinColumn(name = "item_id"))    private Set<OrderItem> orderItems;//    @OneToMany (fetch = FetchType.LAZY)//    @JoinTable (name = "order_docs")//    private Set<Document> orderDocs;    //TODO    //Documents    //Project?}