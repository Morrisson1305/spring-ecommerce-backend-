package com.project.eunice.Repo.DbContracts;

import com.project.eunice.Domain.Orders;

import java.util.List;
import java.util.Map;

public interface IOrderService {
    List<Orders> findAll();
    List<Orders> findOrderByEmail(String email);
    Orders postOrder(Orders validOrder, Map<Long, Long> productId);
    List<Orders> deleteOrder(Long orderId);
}
