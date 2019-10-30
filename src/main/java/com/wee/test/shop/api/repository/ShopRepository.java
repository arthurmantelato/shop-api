package com.wee.test.shop.api.repository;

import com.wee.test.shop.api.model.dto.ItemsPerShopCountDto;
import com.wee.test.shop.api.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, String> {

    @Query("SELECT " +
            "   new com.wee.test.shop.api.model.dto.ItemsPerShopCountDto(s.name, COUNT(i.id)) " +
            "FROM Item i " +
            "LEFT JOIN Shop s ON i.shop.id = s.id " +
            "GROUP BY s.name")
    List<ItemsPerShopCountDto> listItemsPerShopCount();
}
