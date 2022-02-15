package com.eugenep.product.controller;

import com.eugenep.product.exception.InventoryDataNotFoundException;
import com.eugenep.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
@Slf4j
public class ProductController {

    private final ProductService productService;

    @GetMapping("/sku/{sku}")
    private ResponseEntity getAvailableProductsBySku(@PathVariable String sku) {
        try {
            return productService.getAvailableProducts(sku);
        } catch (InventoryDataNotFoundException | HttpClientErrorException.NotFound e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
