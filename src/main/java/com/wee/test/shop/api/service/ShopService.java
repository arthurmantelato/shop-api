package com.wee.test.shop.api.service;

import com.wee.test.shop.api.model.Shop;
import com.wee.test.shop.api.model.dto.ItemsPerShopCountDto;
import com.wee.test.shop.api.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    @Autowired
    private ShopRepository repository;

    public List<ItemsPerShopCountDto> reportItemsPerShop() {
        return repository.listItemsPerShopCount();
    }

    public Optional<Shop> findById(String id) {
        return repository.findById(id);
    }

    @Transactional
    public void delete(Shop shop) {
        repository.delete(shop);
    }

    @Transactional
    public Shop save(Shop shop) {
        return repository.save(shop);
    }

    public List<Shop> findAll() {
        return new ArrayList<>(repository.findAll());
    }


}
