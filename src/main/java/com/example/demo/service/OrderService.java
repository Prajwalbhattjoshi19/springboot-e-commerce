package com.example.demo.service;

import com.example.demo.domain.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public String getOrderMailBody(Order order){
        StringBuilder mailBody= new StringBuilder();
        mailBody.append("Dear "+order.getName());
        mailBody.append(" your order of cart total "+order.getCartTotal()+" and cart quantity of "+order.getCartQty());
        mailBody.append(" will be deliverd to "+order.getAddress());
        return mailBody.toString();
    }
    public String getOrderMailSubject(Order order){
        StringBuilder mailSubject =new StringBuilder();
        mailSubject.append("Order Confirmed of $"+order.getCartTotal());
        return mailSubject.toString();
    }


}
