package com.project.eunice.service;

import com.project.eunice.Domain.Item;
import com.project.eunice.Domain.Orders;
import com.project.eunice.Domain.Products;
import com.project.eunice.Repo.DbContracts.IOrderService;
import com.project.eunice.Repo.DbContracts.OrderItemRepo;
import com.project.eunice.Repo.DbContracts.OrderRepo;
import com.project.eunice.Repo.DbContracts.ProductRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderServiceImp implements IOrderService {

    private final OrderRepo orderRepo;
    private final OrderItemRepo orderItemRepo;
    private final ProductRepo productRepo;
    @Override
    public List<Orders> findAll() {
        return orderRepo.findAllByOrderByIdAsc();
    }

    @Override
    public List<Orders> findOrderByEmail(String email) {
        return orderRepo.findOrderByEmail(email);
    }

    @Override
    @Transactional
    public Orders postOrder(Orders validOrder, Map<Long, Long> productId) {
        Orders order = new Orders();
        List<Item> orderItemList = new ArrayList<>();

        for (Map.Entry<Long, Long> entry : productId.entrySet()) {
            Products product = productRepo.findById(entry.getKey()).get();
            Item orderItem = new Item();
            orderItem.setProduct(product);
            orderItem.setAmount((product.getPrice() * entry.getValue()));
            orderItem.setQuantity(entry.getValue());
            orderItemList.add(orderItem);
            orderItemRepo.save(orderItem);
        }
        order.getOrderItems().addAll(orderItemList);
        order.setTotalPrice(validOrder.getTotalPrice());
        order.setFirstName(validOrder.getFirstName());
        order.setLastName(validOrder.getLastName());
        order.setCity(validOrder.getCity());
        order.setAddress(validOrder.getAddress());
        order.setPostIndex(validOrder.getPostIndex());
        order.setEmail(validOrder.getEmail());
        order.setPhoneNumber(validOrder.getPhoneNumber());
        return orderRepo.save(order);

    }

    @Override
    @Transactional
    public List<Orders> deleteOrder(Long orderId) {
        Orders order = orderRepo.findById(orderId).get();
        order.getOrderItems().forEach(orderItem -> orderItemRepo.deleteById(orderItem.getId()));
        orderRepo.delete(order);
        return orderRepo.findAllByOrderByIdAsc();
    }
}
