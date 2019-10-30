package com.wee.test.shop.api.model.dto;

public class ItemsPerShopCountDto {

    private String shopName;
    private Long itemsCount;

    public ItemsPerShopCountDto(String shopName, Long itemsCount) {
        this.shopName = shopName;
        this.itemsCount = itemsCount;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Long getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(Long itemsCount) {
        this.itemsCount = itemsCount;
    }
}
