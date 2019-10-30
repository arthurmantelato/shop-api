package com.wee.test.shop.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RestControllerUtil {

    public static <T> ResponseEntity<T>  buildNotFoundResponse() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public static <T> ResponseEntity<T> buildOkWithContentResponse(T content) {
        return new ResponseEntity<>(content, HttpStatus.OK);
    }

    public static ResponseEntity<Void> buildOkWithoutContentResponse() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
