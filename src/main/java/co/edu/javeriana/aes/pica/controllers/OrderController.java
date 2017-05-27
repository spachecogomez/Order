/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.aes.pica.controllers;

import co.edu.javeriana.aes.pica.entities.ItemEntity;
import co.edu.javeriana.aes.pica.entities.ItemEntityPK;
import co.edu.javeriana.aes.pica.entities.OrderEntity;
import co.edu.javeriana.aes.pica.model.Order;
import co.edu.javeriana.aes.pica.model.OrderDetail;
import co.edu.javeriana.aes.pica.repositories.ItemRepository;
import co.edu.javeriana.aes.pica.repositories.OrderRepository;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    private ItemRepository itemRepository;

    @Autowired
    DataSource dataSource;

    @RequestMapping(value = "/orders", method = RequestMethod.GET, produces = "application/json")
    public List<Order> getOrders(@RequestParam int start, @RequestParam int pageSize) {
        log.info("Received the customer request");
        List<OrderEntity> resultList = orderRepository.findAll(new PageRequest(start, pageSize)).getContent();
        Stream<OrderEntity> dbResults = resultList.stream();
        Stream<OrderEntity> dbResults2 = resultList.stream();
        log.info("resultados: " + resultList);
        List<Order> orders = dbResults.map(it
                -> new Order(Optional.ofNullable(it.getOrderID()).orElse(0),
                        Optional.ofNullable(it.getOrderDate()).orElse(new Date()),
                        Optional.ofNullable(new BigDecimal(it.getPrice())).orElse(BigDecimal.ZERO),
                        Optional.ofNullable(it.getOrderStatus()).orElse(""),
                        Optional.ofNullable(it.getComments()).orElse("")))
                .collect(Collectors.toList());

        return orders;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity createOrder(@RequestBody List<Order> orders) {
        //TODO: create empty validations
        OrderEntity entityAux;
        List<OrderEntity> savedOrders = new ArrayList<>();
        List<ItemEntity> items = null;
        ItemEntity entity;
        ItemEntityPK entityPK;
        for (Order order : orders) {
            items = new ArrayList<>();
            log.debug("Amount on order details:" + order.getOrderDetails().size());
            entityAux = new OrderEntity();
            entityAux.setOrderDate(new Date());
            entityAux.setCustId(order.getCustomerDetails().getCustomerId() + "");
            entityAux.setComments(order.getOrderComments());
            entityAux.setOrderStatus("CREATED");
//            for (OrderDetail detail : order.getOrderDetails()) {
//                entity = new ItemEntity();
//                entityPK = new ItemEntityPK();
//                entityPK.setItemId(""+detail.getItemId());
//                entityPK.setOrdId(""+entityAux.getOrderID());
//                entity.setProdId(new BigInteger("" + detail.getProductId()));
//                entity.setProductName(detail.getSpectacleName());
//                entity.setPrice(detail.getTotalPrice());
//                entity.setQuantity(detail.getQuantity());
//                entity.setOrderEntity(entityAux);
//                entity.setItemEntityPK(entityPK);
//                items.add(entity);
//            }
            //entityAux.setItemEntity(items);
            orderRepository.save(entityAux);
            savedOrders.add(entityAux);
        }
        return ResponseEntity.ok(savedOrders);
    }

        @RequestMapping(value = "/orders/{orderId}", method = RequestMethod.GET, produces = "application/json")
    public Order getOrderById(@PathVariable int orderId) {
        log.debug(String.format("Getting the order with id %d", orderId));
        OrderEntity entity = orderRepository.findOne(orderId);
        return new Order(Optional.ofNullable(entity.getOrderID()).orElse(0),
                Optional.ofNullable(entity.getOrderDate()).orElse(new Date()),
                Optional.ofNullable(new BigDecimal(entity.getPrice())).orElse(BigDecimal.ZERO),
                Optional.ofNullable(entity.getOrderStatus()).orElse(""),
                Optional.ofNullable(entity.getComments()).orElse(""));
    }
    
    @RequestMapping(value = "/orders/size", method = RequestMethod.GET, produces = "application/json")
    public Long getAmountOfOrders(){
        return orderRepository.count();
    }

}
