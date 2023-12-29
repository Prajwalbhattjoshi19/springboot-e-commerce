package com.example.demo.service;

import com.example.demo.domain.Cart;
import com.example.demo.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    JavaMailSender javaMailSender;
    public String getSubject(Cart cart){
        StringBuilder subject =new StringBuilder();
        subject.append("Please take a look at cart shared by "+cart.getName());
        return subject.toString();
    }
    public String getBody(Cart cart){
        StringBuilder body =new StringBuilder();
        body.append("Cart Total = "+cart.getCartTotal());
        body.append("\n cart quantity = "+cart.getCartQty());
        body.append("\n Products are = ");
        for(Product product:cart.getProducts()){
            body.append(product.toString()+"\n");
        }
        return body.toString();
    }

}
