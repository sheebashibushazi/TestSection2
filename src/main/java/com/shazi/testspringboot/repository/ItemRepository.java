package com.shazi.testspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.shazi.testspringboot.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
