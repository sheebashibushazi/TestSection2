package com.shazi.testspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shazi.testspringboot.exception.ResourceNotFoundException;
import com.shazi.testspringboot.model.Item;
import com.shazi.testspringboot.repository.ItemRepository;

@Service
public class ItemService {
@Autowired
private ItemRepository itemRepository;

public List<Item> getallItems()
{
	return itemRepository.findAll();
}

public Item getItemById(int id)
{
	
return itemRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist with id: "+id));
	
}
public List<Item> getItemsByIds(List<Integer> ids)
{
	return itemRepository.findAllById(ids);
}

}
