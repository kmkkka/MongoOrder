package com.mongo.oms.model.Request;

import com.mongo.oms.model.Product;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {

    String userId;
    String emailId;
    String phone;
    List<Product> products;
    String addressId;
}
