package com.example.demo.controller;

import com.example.demo.domain.Order;
import com.example.demo.service.MailService;
import com.example.demo.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/order")

public class orderController {
    @Autowired
    MailService mailService;
    @Autowired
    OrderService orderService;
    @PostMapping("/saveOrder")
    public String saveOrder(@RequestBody String order) {
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            Order order1 = objectMapper.readValue(order, Order.class);
            mailService.sendEmail(order1.getEmail(),orderService.getOrderMailSubject(order1),orderService.getOrderMailBody(order1));
            return "donee";
        }catch (Exception e){
            return "Oops Something went wrong";
        }
    }

}
