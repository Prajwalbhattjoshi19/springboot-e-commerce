package com.example.demo.controller;

import com.example.demo.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/products")
public class ProductController {
    @GetMapping("/getProducts")
    public String getProducts(){
        Product product=new Product("uiop",34.89);
        return product.toString();
    }

}
