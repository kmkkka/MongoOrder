package com.mongo.oms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    String orderId;
    String userId;
    List<Product> products;
    double price;
    double tax;
    double discount;
    String promotionCode;

    String orderStatus;
    String created;
    String createdBy;
    String updated;
    String updatedBy;
}
