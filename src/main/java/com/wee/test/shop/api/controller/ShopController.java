package com.wee.test.shop.api.controller;

import com.wee.test.shop.api.model.dto.ItemsPerShopCountDto;
import com.wee.test.shop.api.service.ShopService;
import com.wee.test.shop.api.model.Shop;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Shop CRUD controller")
@RestController
public class ShopController {

        @Autowired
    private ShopService service;

    @ApiOperation("List all shops")
    @GetMapping(path = UrlConstants.ShopEndpoints.FIND_ALL)
    public ResponseEntity<List<Shop>> findAll() {
        return RestControllerUtil.buildOkWithContentResponse(service.findAll());
    }

    @ApiOperation("Return shop if it exists")
    @GetMapping(path = UrlConstants.ShopEndpoints.FIND_BY_ID)
    public ResponseEntity<Shop> findById(@PathVariable( "id") String id) {
        var found = service.findById(id);
        if(!found.isPresent()) {
            return RestControllerUtil.buildNotFoundResponse();
        }
        return RestControllerUtil.buildOkWithContentResponse(found.get());
    }


    @ApiOperation("Create a new shop")
    @PostMapping(path = UrlConstants.ShopEndpoints.CREATE)
    public ResponseEntity<Shop> createShop(@RequestBody Shop shop) {
        return RestControllerUtil.buildOkWithContentResponse(service.save(shop));
    }

    @ApiOperation("Update a shop if it exists")
    @PutMapping(path = UrlConstants.ShopEndpoints.UPDATE_BY_ID)
    public ResponseEntity<Shop> updateShop(@PathVariable("id") String id, @RequestBody Shop shop) {
        var persisted = service.findById(id);

        if(!persisted.isPresent()) {
            return RestControllerUtil.buildNotFoundResponse();
        }

        return RestControllerUtil.buildOkWithContentResponse(service.save(shop));
    }

    @ApiOperation("Delete a shop if it exists")
    @DeleteMapping(path = UrlConstants.ShopEndpoints.DELETE_BY_ID)
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {

        var found = service.findById(id);
        if(!found.isPresent()) {
            return RestControllerUtil.buildNotFoundResponse();
        }

        service.delete(found.get());

        return RestControllerUtil.buildNotFoundResponse();
    }

    @GetMapping(path = UrlConstants.ShopEndpoints.REPORT)
    public List<ItemsPerShopCountDto> getReportItemsPerShop() {
        return service.reportItemsPerShop();
    }
}
