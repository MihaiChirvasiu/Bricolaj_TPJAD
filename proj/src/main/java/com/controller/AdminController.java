package com.controller;

import com.model.Product;
import com.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/admin/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateQuantity(@RequestParam String name, @RequestParam int newQuantity){
        try{
            productRepository.updateQuantity(name, newQuantity);
            return new ResponseEntity<>("Quantity Updated Successfully", HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/admin/delete", method = RequestMethod.PUT)
    public ResponseEntity<?> deleteProduct(@RequestParam String name){
        try{
            productRepository.delete(name);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Deleted Product", HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/load", method = RequestMethod.GET)
    public ResponseEntity<?> loadProducts(){
        List<Product> productList = productRepository.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }
}
