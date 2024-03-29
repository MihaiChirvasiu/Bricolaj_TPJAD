package com.controller;

import com.model.Cart;
import com.model.Mail;
import com.model.Product;
import com.repository.ProductRepository;
import com.util.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ClientController {
    @Autowired
    private ProductRepository productRepository;

   /* @Autowired
    private MailService mailService;*/
    public ClientController(){
        productRepository = new ProductRepository();
    }

    @RequestMapping(value = "/client/load", method = RequestMethod.GET)
    public ResponseEntity<?> loadProducts(){
        List<Product> productList = productRepository.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }

   /* @RequestMapping(value = "/client/sendMail", method = RequestMethod.POST)
    public ResponseEntity<?> sendMail(@RequestBody Mail mail){
        try {
            mailService.sendMail(mail.getTo(), "Confirmation", mail.toString());
        } catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).body("Check your email for the confirmation");
    }*/
}
