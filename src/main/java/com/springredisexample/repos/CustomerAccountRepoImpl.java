package com.springredisexample.repos;

import com.springredisexample.model.CustomerAccount;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class CustomerAccountRepoImpl implements CustomerAccountRepo {

    private RedisTemplate<String, CustomerAccount> redisTemplate;

    private HashOperations hashOperations;


    public CustomerAccountRepoImpl(RedisTemplate<String, CustomerAccount> redisTemplate) {
        this.redisTemplate = redisTemplate;

        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(CustomerAccount customerAccount) {
        hashOperations.put("CUSTOMER_ACCOUNT", customerAccount.getId(), customerAccount);
    }

    @Override
    public Map<String, CustomerAccount> findAll() {
        return hashOperations.entries("CUSTOMER_ACCOUNT");
    }

    @Override
    public CustomerAccount findById(String id) {
        return (CustomerAccount)hashOperations.get("CUSTOMER_ACCOUNT", id);
    }

    @Override
    public void update(CustomerAccount customerAccount) {
        save(customerAccount);
    }

    @Override
    public void delete(String id) {

        hashOperations.delete("CUSTOMER_ACCOUNT", id);
    }
}
