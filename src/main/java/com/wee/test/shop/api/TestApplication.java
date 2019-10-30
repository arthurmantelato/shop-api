package com.wee.test.shop.api;

import com.wee.test.shop.api.model.Item;
import com.wee.test.shop.api.model.Shop;
import com.wee.test.shop.api.repository.ItemRepository;
import com.wee.test.shop.api.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TestApplication {

	@Autowired
	private ShopRepository shopRepository;

	@Autowired
	private ItemRepository itemRepository;

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@PostConstruct
	public void init() {
		var shopA = new Shop();
		shopA.setName("shop a");
		shopA = shopRepository.save(shopA); //get id

		var itemA1 = new Item();
		itemA1.setName("item a1");
		itemA1.setShop(shopA);
		itemRepository.save(itemA1);

		var itemA2 = new Item();
		itemA2.setName("item a2");
		itemA2.setShop(shopA);
		itemRepository.save(itemA2);

		var shopB = new Shop();
		shopB.setName("shop b");
		shopB = shopRepository.save(shopB); //get id

		var itemB1 = new Item();
		itemB1.setName("item b1");
		itemB1.setShop(shopB);
		itemRepository.save(itemB1);

		var itemB2 = new Item();
		itemB2.setName("item b2");
		itemB2.setShop(shopB);
		itemRepository.save(itemB2);

	}
}
