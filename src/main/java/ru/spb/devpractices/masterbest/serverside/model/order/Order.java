package ru.spb.devpractices.masterbest.serverside.model.order;import lombok.Data;import lombok.ToString;import ru.spb.devpractices.masterbest.serverside.model.User;import javax.persistence.*;import java.io.Serializable;import java.sql.Timestamp;import java.util.Set;@ToString@Entity@Data@Table(name = "orders")public class Order implements Serializable {    @Id    @Column(name ="ikea_number")    private String ikea_number;    @Column(name ="mb_number")    private String mb_number;    @Column(name ="date_start")    private Timestamp date_start;    @Column(name ="date_end")    private Timestamp date_end;    @Column(name ="customer_name")    private String customer_name;    @Column(name ="customer_address")    private String customer_address;    @Column(name ="customer_phone")    private String customer_phone;    @Column(name ="false_visit")    private Boolean false_visit;    @Column(name ="comment")    private String comment;    @OneToOne(fetch = FetchType.LAZY)    private OrderType order_type;//    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)//    private Set<OrderStatusHistory> orderStatusHistory;    @ManyToMany (fetch = FetchType.LAZY)    @JoinTable(            name = "orders_users",            joinColumns = @JoinColumn(name = "order_id"),            inverseJoinColumns = @JoinColumn(name = "user_id"))    private Set<User> users;//    @OneToMany (fetch = FetchType.LAZY)//    @JoinTable (name = "order_cart")//    private Set<OrderItem> orderItems;//    @OneToMany (fetch = FetchType.LAZY)//    @JoinTable (name = "order_docs")//    private Set<Document> orderDocs;//    @OneToMany(mappedBy = "order")//    private Set<OrderItem> orderItems;//    //TODO    //Order status должен быть в разрезе сборщика    //Всякие там суммы    //Documents    //Project?}