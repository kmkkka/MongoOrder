package com.mongo.oms.repository;

import java.util.List;

import com.mongo.oms.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {
    public Account findByFirstName(String firstName);
    public List<Account> findByLastName(String lastName);

}
