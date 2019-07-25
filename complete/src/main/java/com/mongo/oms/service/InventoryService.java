package com.mongo.oms.service;

import com.mongo.oms.model.Inventory;
import com.mongo.oms.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    public void addInventory() {

        List<Inventory> iList=new ArrayList<>();

        iList.add(getInventoryObject("product1", "fashion", 10));
        iList.add(getInventoryObject("product2", "fashion", 20));
        iList.add(getInventoryObject("product3", "kitchen", 5));
        iList.add(getInventoryObject("product4", "kitchen", 20));

        inventoryRepository.deleteAll();
        inventoryRepository.saveAll(iList);
    }


    public Inventory getInventoryObject(String pId, String category, int q){

        Inventory inventory=new Inventory();

        inventory.setCategory(category);
        inventory.setProductDescription("product description");
        inventory.setProductId(pId);
        inventory.setQuantity(q);
        inventory.setSkuId("sku1");

        return inventory;
    }

}
