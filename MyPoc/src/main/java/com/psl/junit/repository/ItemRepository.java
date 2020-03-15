package com.psl.junit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.psl.junit.model.Item;


public interface ItemRepository extends JpaRepository<Item, Long>{

}
