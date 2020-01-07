package com.springredisexample.repos;

import com.springredisexample.model.CustomerAccount;

import java.util.Map;

public interface CustomerAccountRepo {

    void save(CustomerAccount customerAccount);
    Map<String, CustomerAccount> findAll();
    CustomerAccount findById(String id);
    void update(CustomerAccount user);
    void delete(String id);
}
