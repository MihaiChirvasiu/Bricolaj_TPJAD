package com.controller;

import com.model.Cart;
import com.model.Product;
import com.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    private Cart cart;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    public ClientController(){
        this.cart = new Cart();
    }

    @RequestMapping(value = "/client/load", method = RequestMethod.GET)
    public ResponseEntity<?> loadProducts(){
        List<Product> productList = productRepository.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }
}
