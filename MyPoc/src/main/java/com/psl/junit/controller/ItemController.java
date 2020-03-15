package com.psl.junit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.psl.junit.exception.ItemException;
import com.psl.junit.model.Item;
import com.psl.junit.model.Response;
import com.psl.junit.service.ItemService;

@RestController
public class ItemController {
	
	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value="/item", method=RequestMethod.GET)
	public ResponseEntity<List<Item>> getAllItem(){
    	logger.info("Returning all the items");
    	System.out.println("loooololloll");
		return new ResponseEntity<List<Item>>(itemService.getAllItem(), HttpStatus.OK);
	}
	
    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
	public ResponseEntity<Item> getItemById(@PathVariable("id") long id) throws ItemException{
    	logger.info("Item id to return " + id);
    	System.out.println(itemService.getTItemById(id));
		return new ResponseEntity<Item>(itemService.getTItemById(id), HttpStatus.OK);
	}

    @RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response> removeItemDoById(@PathVariable("id") long id) throws ItemException {
    	logger.info("item id to remove " + id);
    	Item item = itemService.getTItemById(id);
		itemService.removeItem(item);
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "item has been deleted"), HttpStatus.OK);
	}
    
    @RequestMapping(value = "/item", method = RequestMethod.POST)
   	public ResponseEntity<Item> saveItem(@RequestBody Item payload) throws ItemException{
    	logger.info("Payload to save " + payload);
		return new ResponseEntity<Item>(itemService.saveItem(payload), HttpStatus.OK);
   	}
    
   
	
}
