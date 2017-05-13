/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.aes.pica.repositories;

import co.edu.javeriana.aes.pica.entities.OrderEntity;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author sebastianpacheco
 */
public interface OrderRepository extends CrudRepository<OrderEntity, Integer>{
    
}
