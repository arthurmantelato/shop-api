package com.wee.test.shop.api.repository;

import com.wee.test.shop.api.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, String> {
}
