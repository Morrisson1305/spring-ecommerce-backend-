package com.project.eunice.mapper;

import com.project.eunice.Domain.Orders;
import com.project.eunice.Repo.DbContracts.IOrderService;
import com.project.eunice.dto.orders.OrderRequest;
import com.project.eunice.dto.orders.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final ModelMapper modelMapper;
    private final IOrderService orderService;

    private Orders convertToEntity(OrderRequest orderRequest) {
        return modelMapper.map(orderRequest, Orders.class);
    }

    private OrderResponse convertToResponseDto(Orders order) {
        return modelMapper.map(order, OrderResponse.class);
    }

    private List<OrderResponse> convertListToResponseDto(List<Orders> orders) {
        return orders.stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    public List<OrderResponse> findAllOrders() {
        return convertListToResponseDto(orderService.findAll());
    }

    public List<OrderResponse> findOrderByEmail(String email) {
        return convertListToResponseDto(orderService.findOrderByEmail(email));
    }

    public List<OrderResponse> deleteOrder(Long orderId) {
        return convertListToResponseDto(orderService.deleteOrder(orderId));
    }

    public OrderResponse postOrder(OrderRequest orderRequest) {
        return convertToResponseDto(orderService.postOrder(convertToEntity(orderRequest), orderRequest.getProductId()));
    }
}
