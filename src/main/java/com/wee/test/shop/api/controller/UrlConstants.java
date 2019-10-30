package com.wee.test.shop.api.controller;

public interface UrlConstants {

    interface ShopEndpoints {
        String FIND_ALL = "/shops";
        String FIND_BY_ID = "/shops/{id}";
        String CREATE = "/shops";
        String UPDATE_BY_ID = "/shops/{id}";
        String DELETE_BY_ID = "/shops/{id}";
        String REPORT = "/shops/report";
    }
}
