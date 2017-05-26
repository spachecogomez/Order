/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.aes.pica.controllers;

import co.edu.javeriana.aes.pica.entities.CustomerEntity;
import co.edu.javeriana.aes.pica.repositories.CustomerRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sebastianpacheco
 */
@RestController
public class CustomerController {

    private Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(value = "/customers", method = RequestMethod.GET, produces = "application/json")
    public List<CustomerEntity> getPagedCustomer(@RequestParam int start, @RequestParam int pageSize) {
        log.debug(String.format("Received start %d and pageSize %s", start, pageSize));
        return customerRepository.findAll(new PageRequest(start, pageSize)).getContent();
    }
    
    @RequestMapping(value = "/customers/{customerId}", 
            method = RequestMethod.GET, produces = "application/json")
    public CustomerEntity getCustomerEntity(@PathVariable int customerId){
        log.debug(String.format("Getting customer by id %d",customerId));
        return customerRepository.findOne(customerId);
    }

}
