package com.springredisexample.controller;


import com.springredisexample.repos.CustomerAccountRepo;
import com.springredisexample.model.CustomerAccount;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/rest/user")
public class MainController {

    private CustomerAccountRepo customerAccountRepo;

    public MainController(CustomerAccountRepo userRepository) {
        this.customerAccountRepo = userRepository;
    }

    @GetMapping("/add/{id}/{name}")
    public CustomerAccount add(@PathVariable("id") final String id,
                               @PathVariable("name") final String name) {
        customerAccountRepo.save(new CustomerAccount(id, name));
        return customerAccountRepo.findById(id);
    }

    @GetMapping("/update/{id}/{name}")
    public CustomerAccount update(@PathVariable("id") final String id,
                                  @PathVariable("name") final String name) {
        customerAccountRepo.update(new CustomerAccount(id, name));
        return customerAccountRepo.findById(id);
    }

    @GetMapping("/delete/{id}")
    public Map<String, CustomerAccount> delete(@PathVariable("id") final String id) {
        customerAccountRepo.delete(id);
        return all();
    }

    @GetMapping("/all")
    public Map<String, CustomerAccount> all() {
        return customerAccountRepo.findAll();
    }
}
