package com.psl.junit.dao;

import java.util.List;

import com.psl.junit.exception.ItemException;
import com.psl.junit.model.Item;


public interface ItemDao {
	
	public List<Item> getAllItem();
	public Item getItemId(long id) throws ItemException;
	public void removeItem(Item item) throws ItemException;
	public Item saveItem(Item item) throws ItemException;

}
