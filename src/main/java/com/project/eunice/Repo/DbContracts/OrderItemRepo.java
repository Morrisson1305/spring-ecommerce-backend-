package com.project.eunice.Repo.DbContracts;

import com.project.eunice.Domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<Item, Long> {
}
