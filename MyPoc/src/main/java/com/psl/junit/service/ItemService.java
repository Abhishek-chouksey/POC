package com.psl.junit.service;

import java.util.List;

import com.psl.junit.exception.ItemException;
import com.psl.junit.model.Item;

public interface ItemService {
	
	public List<Item> getAllItem();
	public Item getTItemById(long id) throws ItemException; 
	public Item saveItem(Item item) throws ItemException ;
	public void removeItem(Item item) throws ItemException;

}
