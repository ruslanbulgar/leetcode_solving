package com.rbcode.leatcode.menu_order.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static com.rbcode.leatcode.menu_order.model.OrderStatus.PENDING;
import static jakarta.persistence.GenerationType.AUTO;

@Setter
@Getter
@Builder(toBuilder = true)
@Entity
@Table(name = "ORDERS")
@ToString
@EqualsAndHashCode
public class Order {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Integer id;

    @OneToOne
    private Client client;

    @Column(columnDefinition = "varchar(50) DEFAULT 'PENDING'")
    private OrderStatus orderStatus;
    @ManyToMany
    private List<Item> items;
}
