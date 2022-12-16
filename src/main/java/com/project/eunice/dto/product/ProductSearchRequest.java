package com.project.eunice.dto.product;

import lombok.Data;

import java.util.List;

@Data
public class ProductSearchRequest {

    private List<String> categories;
    private List<Integer> prices;
    private boolean sortByPrice;
    private String category;
}
