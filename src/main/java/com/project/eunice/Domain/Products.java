package com.project.eunice.Domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sh_product")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_seq")
    @SequenceGenerator(name = "product_id_seq", sequenceName = "product_id_seq", initialValue = 109, allocationSize = 1)
    private Long id;
    private String productName;
    private String description;
    private Integer price;
    private String category;
    private String imageUrl;
    private Integer year;
}
