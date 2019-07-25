package com.mongo.oms.model.Response;

import lombok.Data;

@Data
public class OrderResponse {

    String orderId;
    String orderStatus;
    String created;
    String createdBy;
    String updated;
    String updatedBy;
}
