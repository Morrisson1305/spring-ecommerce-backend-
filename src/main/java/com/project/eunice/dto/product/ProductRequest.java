package com.project.eunice.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class ProductRequest {

    private Long id;
    private String imageUrl;

    @NotBlank(message = "Fill in the input field")
    @Length(max = 255)
    private String productName;


    @Length(max = 512)
    private String description;

    @NotNull(message = "Fill in the input field")
    private Integer year;

    @NotNull(message = "Fill in the input field")
    private Integer price;


    @NotBlank(message = "Fill in the input field")
    @Length(max = 255)
    private String category;
}
