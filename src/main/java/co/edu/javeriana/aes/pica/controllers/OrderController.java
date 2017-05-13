/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.aes.pica.controllers;

import co.edu.javeriana.aes.pica.entities.OrderEntity;
import co.edu.javeriana.aes.pica.model.CustomerDetail;
import co.edu.javeriana.aes.pica.model.Order;
import co.edu.javeriana.aes.pica.model.OrderDetail;
import co.edu.javeriana.aes.pica.model.OrderStatus;
import co.edu.javeriana.aes.pica.model.OrderWrapper;
import co.edu.javeriana.aes.pica.repositories.OrderRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sebastianpacheco
 */
@RestController
public class OrderController {

    private Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    DataSource dataSource;

    @RequestMapping(value = "/orders", method = RequestMethod.GET, produces = "application/json")
    public List<Order> getOrders() {
        log.info("Received the customer request");
        List<OrderEntity> resultList = (List<OrderEntity>) orderRepository.findAll();
        Stream<OrderEntity> dbResults = resultList.stream();
        Stream<OrderEntity> dbResults2 = resultList.stream();
        log.info("resultados: "+resultList);
        List<Order> orders = dbResults.map( it 
                -> 
        new Order(it.getOrderID(),it.getOrderDate(),
                it.getPrice().longValue(),it.getComments()))
                .collect(Collectors.toList());
        
        return orders;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity createOrder(@RequestBody List<Order> orders) {
        //TODO: create empty validations
        OrderEntity entityAux;
        for(Order order : orders){
            entityAux = new OrderEntity();
            entityAux.setOrderDate(new Date());
            entityAux.setCustomerId(order.getCustomerDetails().getCustomerId());
            entityAux.setComments(order.getOrderComments());
            entityAux.setOrderStatus("CREATED");
            orderRepository.save(entityAux);
        }
        return ResponseEntity.ok().build();
    }

}
