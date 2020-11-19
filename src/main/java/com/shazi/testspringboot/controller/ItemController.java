package com.shazi.testspringboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.shazi.testspringboot.model.Item;
import com.shazi.testspringboot.service.ItemService;

@RestController
@RequestMapping("/api/v1/")
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	//access pattern:http://localhost:9090/api/v1/getAllitems
	@RequestMapping("/getAllitems")
	@ResponseBody
	public List<Item> getAllItems()
	{
		List<Item> list1=new ArrayList<>();
		list1=itemService.getallItems();
		
		//sorting process in descending order
		List<Item> list2= list1.stream().sorted((Item itm1,Item itm2)->(itm2.getPrice()-itm1.getPrice())).collect(Collectors.toList());		
		list2.forEach(s->System.out.println(s));
		 
		return list2;
	}
	
//access pattern:-> http://localhost:9090/api/v1/itemId/1
@GetMapping("/itemId/{id}")
public Item getItemById(@PathVariable int id)
{
	ObjectMapper mapper = new ObjectMapper();
	mapper.enable(SerializationFeature.INDENT_OUTPUT);
	Item itm= itemService.getItemById(id);
	return itm;

}

//access pattern:-> http://localhost:9090/api/v1/setofItemIds/1,3,4,5
@GetMapping("/setofItemIds/{ids}")
public List<Item>  getAllids(@PathVariable List<Integer> ids )
{
	/*
	 * for(Integer i:ids) { System.out.println("id: "+i); }
	 */	
List<Item> itemlist=itemService.getItemsByIds(ids);
itemlist.forEach(s->System.out.println("Item ID: "+s.getItemId()+" Description: " +s.getDescription()+" Price: "+s.getPrice()+" Brand: "+s.getBrand()));
return itemlist;

}
	
}
