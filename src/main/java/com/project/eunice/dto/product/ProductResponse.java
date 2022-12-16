package com.project.eunice.dto.product;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductResponse {
    private Long id;
    private String productName;
    private String description;
    private Integer year;
    private String category;
    private String imageUrl;
    private Integer price;
    private MultipartFile file;
}
