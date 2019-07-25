package com.mongo.oms.service;

import com.mongo.oms.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.query.Criteria.*;

@Service
public class CounterService {

    @Autowired
    private MongoOperations mongo;


    public Inventory updateQuantity(String productId, int quantity) {

        Inventory inventory = mongo.findAndModify(
                Query.query(where("_id").is(productId)),
                new Update().inc("quantity", quantity),
                FindAndModifyOptions.options().returnNew(true),
                Inventory.class);
        return inventory;
    }

}
