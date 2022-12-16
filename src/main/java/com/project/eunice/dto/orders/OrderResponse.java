package com.project.eunice.dto.orders;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderResponse {

    private Long id;
    private Double totalPrice;
    private LocalDate date;
    private String firstName;
    private String lastName;
    private String city;
    private String address;
    private String email;
    private String telephone;
    private Integer postIndex;
    private List<OrderItemResponse> orderItems;
}
