/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.aes.pica.repositories;


import co.edu.javeriana.aes.pica.entities.ItemEntity;
import co.edu.javeriana.aes.pica.entities.ItemEntityPK;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author sebastianpacheco
 */
public interface ItemRepository extends PagingAndSortingRepository<ItemEntity,ItemEntityPK>{
    
}
