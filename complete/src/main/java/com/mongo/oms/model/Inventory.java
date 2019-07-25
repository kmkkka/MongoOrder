package com.mongo.oms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="inventory")
public class Inventory {

    @Id
    String productId;

    String productDescription;

    int quantity;

    String skuId;

    String category;

    String color;

    String supplierId;
}
