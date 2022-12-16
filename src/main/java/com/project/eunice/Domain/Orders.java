package com.project.eunice.Domain;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "sh_orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_seq")
    @SequenceGenerator(name = "orders_seq", sequenceName = "orders_seq", initialValue = 6, allocationSize = 1)
    private Long id;
    private String address;
    private String city;
    private Timestamp orderDate;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Integer postIndex;
    private Integer totalPrice;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Item> orderItems;

    public Orders() {
        this.orderDate = Timestamp.valueOf(LocalDateTime.now());
        this.orderItems = new ArrayList<>();
    }
}
