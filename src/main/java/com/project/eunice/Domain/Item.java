package com.project.eunice.Domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sh_order_item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_item_seq")
    @SequenceGenerator(name = "order_item_seq", sequenceName = "order_item_seq", initialValue = 12, allocationSize = 1)
    private Long id;
    private Long amount;
    private Long quantity;

    @OneToOne
    private Products product;
}
