package com.mongo.oms;

import com.mongo.oms.service.AccountService;
import com.mongo.oms.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private AccountService accountService;

    @Override
    public void run(String...args) throws Exception {
        accountService.addAccounts();
        inventoryService.addInventory();

    }
}
