/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.aes.pica.controllers;

import co.edu.javeriana.aes.pica.model.CustomerDetail;
import co.edu.javeriana.aes.pica.model.Order;
import co.edu.javeriana.aes.pica.model.OrderDetail;
import co.edu.javeriana.aes.pica.model.OrderStatus;
import co.edu.javeriana.aes.pica.model.OrderWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @RequestMapping(value = "/orders", method = RequestMethod.GET,produces = "application/json")
    public List<Order> getOrders(){
        log.debug("Received the customer request");
        return getMockResponse();
    }
    
    private List<Order> getMockResponse(){
        List<Order> result;
        result = new LinkedList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setItemId(1);
        orderDetail.setProductId(1);
        orderDetail.setQuantity(2);
        orderDetail.setSpectacleName("El clasico");
        CustomerDetail customerDetail = new CustomerDetail();
        customerDetail.setCustomerAdress("Fake 123");
        customerDetail.setCustomerCreditCardNumber("123123-123123");
        customerDetail.setCustomerCreditCardType("VISA");
        customerDetail.setCustomerEmail("user@test.com");
        customerDetail.setCustomerFirstName("Test");
        customerDetail.setCustomerId(10);
        customerDetail.setCustomerLastName("Mock");
        customerDetail.setCustomerPassword("****");
        customerDetail.setCustomerPhone("1234567");
        customerDetail.setCustomerStatus("active");
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setStatusId(1);
        orderStatus.setStatusName("active");
        Order order = new Order();
        order.setCustomerDetails(customerDetail);
        order.setOrderDate(new Date());
        order.setOrderDetails(new ArrayList<>());
        order.getOrderDetails().add(orderDetail);
        order.setOrderId(1);
        OrderWrapper orderWrapper = new OrderWrapper();
        orderWrapper.setOrders(new ArrayList<>());
        orderWrapper.getOrders().add(order);
        result.add(order);
        return result;
    }
    
}
