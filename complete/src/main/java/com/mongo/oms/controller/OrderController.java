package com.mongo.oms.controller;

import com.mongo.oms.model.Order;
import com.mongo.oms.model.Request.OrderRequest;
import com.mongo.oms.model.Request.ServiceRequest;
import com.mongo.oms.model.Response.ServiceResponse;
import com.mongo.oms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ServiceResponse<Order> addOrder(@RequestBody ServiceRequest<OrderRequest> serviceRequest)  {

        return orderService.addOrder(serviceRequest);
    }

}
