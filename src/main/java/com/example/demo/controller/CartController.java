package com.example.demo.controller;

import com.example.demo.domain.Cart;
import com.example.demo.service.CartService;
import com.example.demo.service.MailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/cart")
@Controller
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    MailService mailService;
    @PostMapping("/sharecart")
    public String shareCart(@RequestBody String cart){
        ObjectMapper objectMapper=new ObjectMapper();
        try {
           Cart cart1 = objectMapper.readValue(cart, Cart.class);
            mailService.sendEmail(cart1.getEmail(),cartService.getSubject(cart1),cartService.getBody(cart1));
            return "doneee";


        }catch (Exception e){
            return "Ooops Something Went Wrong";
        }

    }


}
