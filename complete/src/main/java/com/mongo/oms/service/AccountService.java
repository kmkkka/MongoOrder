package com.mongo.oms.service;

import com.mongo.oms.model.Account;
import com.mongo.oms.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public void addAccounts() {

        List<Account> aList = new ArrayList<>();

        aList.add(getAccountObject("user1", "user1@gmail.com", 1123832491));
        aList.add(getAccountObject("user2", "user2@gmail.com", 1123832492));
        aList.add(getAccountObject("user3", "user3@gmail.com", 1123832493));
        aList.add(getAccountObject("user4", "user4@gmail.com", 1123832494));

        accountRepository.deleteAll();
        accountRepository.saveAll(aList);
    }


    public Account getAccountObject(String uId, String emailId, int p) {

        Account account = new Account();

        account.setId(uId);
        account.setEmailId(emailId);
        account.setPhone(p);
        account.setFirstName(uId+"fName");
        account.setLastName(uId+"lName");

        return account;
    }

}