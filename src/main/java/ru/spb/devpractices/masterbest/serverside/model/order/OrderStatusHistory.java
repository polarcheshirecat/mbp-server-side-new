package ru.spb.devpractices.masterbest.serverside.model.order;import lombok.Data;import org.hibernate.annotations.CreationTimestamp;import ru.spb.devpractices.masterbest.serverside.model.User;import javax.persistence.*;import java.time.LocalDateTime;@Entity@Data@Table(name = "order_status_history" )public class OrderStatusHistory {    @Id    @GeneratedValue(strategy = GenerationType.AUTO)    private Long id;    @ManyToOne    @JoinColumn(name = "user_id")    private User user;    @ManyToOne    @JoinColumn(name = "order_id")    private Order order;    @CreationTimestamp    @Column(name="timestamp", nullable = false, updatable = false, insertable = false)    private LocalDateTime timestamp;    @Enumerated(EnumType.STRING)    @Column(name ="order_status")    private OrderStatus orderStatus;    @Column(name ="comment")    private String comment;}