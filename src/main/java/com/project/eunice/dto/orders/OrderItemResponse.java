package com.project.eunice.dto.orders;

import com.project.eunice.dto.product.ProductResponse;
import lombok.Data;

@Data
public class OrderItemResponse {

    private Long id;
    private Long amount;
    private Long quantity;
    private ProductResponse product;
}
