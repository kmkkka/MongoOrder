package com.mongo.oms.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Data
@Document(collection="account")
public class Account {

    @Id
    public String id;

    public String firstName;
    public String lastName;
    public String emailId;
    public int phone;
    public String created;
    public String createdBy;

    public Account() {}

    public Account(String firstName, String lastName, String e, int p) {
        this.firstName = firstName;
        this.lastName = lastName;
        emailId = e;
        phone = p;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}

