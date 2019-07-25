package com.mongo.oms.service;

import com.mongo.oms.model.Inventory;
import com.mongo.oms.model.Order;
import com.mongo.oms.model.Product;
import com.mongo.oms.model.Request.OrderRequest;
import com.mongo.oms.model.Request.ServiceRequest;
import com.mongo.oms.model.Response.ServiceResponse;
import com.mongo.oms.repository.AccountRepository;
import com.mongo.oms.repository.InventoryRepository;
import com.mongo.oms.utils.ApplicationConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    AccountRepository customerRepository;

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    CounterService counterService;

    @Transactional
    public ServiceResponse<Order> addOrder(ServiceRequest<OrderRequest> serviceRequest){

        ServiceResponse<Order> sr = new ServiceResponse<>();

        try {
            OrderRequest orderRequest = serviceRequest.getPayload();

            System.out.println("adding order");

            Order order = new Order();
            order.setOrderId(UUID.randomUUID().toString());
            order.setProducts(orderRequest.getProducts());
            order.setCreated(LocalDateTime.now().format(ApplicationConstants.formatter));
            order.setCreatedBy("USER");
            order.setUpdated(LocalDateTime.now().format(ApplicationConstants.formatter));
            order.setUpdatedBy("USER");
            order.setUserId(orderRequest.getUserId());

            //Assuming that we show the products which exists in the inventory.
            for (Product p : order.getProducts()) {
            /*
                We are using the counter service. If multiple people try to update the same
                product instead of reading, decreasing and updating doc, we are just updating in one call
             */
                Inventory inventory = counterService.updateQuantity(p.getProductId(), 0 - p.getQuantity());

                //roll back is needed when inventory is less than the quantity. transactions are supported in mongodb verson 4
                if (inventory.getQuantity() < 0) {
                    throw new Exception("Inventory Unavailable");
                }
                //System.out.println(inventory);
            }

            sr.setPayload(order);
            sr.setStatus(HttpStatus.OK);

        }catch(Exception e){
            List<String> errors=new ArrayList<>();
            errors.add(e.getMessage());
            sr.setError(errors);
            sr.setStatus(HttpStatus.NOT_ACCEPTABLE);
        }

        return sr;
    }


}
