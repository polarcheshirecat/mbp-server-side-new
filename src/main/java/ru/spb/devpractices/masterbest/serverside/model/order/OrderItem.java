package ru.spb.devpractices.masterbest.serverside.model.order;import lombok.Data;import javax.persistence.*;import java.io.Serializable;import java.math.BigDecimal;@Entity@Data@Table(name = "order_items")public class OrderItem implements Serializable {    @Id    @GeneratedValue(strategy = GenerationType.AUTO)    @Column (name = "id")    private Long id;    @Column(name = "article")    private String article;    @Column (name = "name")    private String name;    @Column(name = "count")    private Integer count;    @Column(name = "price")    private BigDecimal price;    @Column(name = "sum")    private BigDecimal sum;    @Column (name = "frame")    private Boolean frame = false;}