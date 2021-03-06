package com.xyy.order.controller;

import com.xyy.order.service.OrderService;
import com.xyy.order.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: zyf
 * @create: 2021-12-27 17:43
 **/
@RestController
@RequestMapping("/order")
public class Order {
    @Autowired
    private StockService stockService;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private OrderService orderService;


    @GetMapping("/one")
    public String order() {
        System.out.println("开始生成订单");
        restTemplate.getForObject("http://127.0.0.1:9001/stock/one",String.class);
        return "ok";
    }

    @GetMapping("/two")
    public String orderTwo() {
        return orderService.makeOrder();
    }

}
