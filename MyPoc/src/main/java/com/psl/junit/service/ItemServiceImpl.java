package com.psl.junit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.junit.dao.ItemDao;
import com.psl.junit.exception.ItemException;
import com.psl.junit.model.Item;

@Service("Itemservice")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;
	
	@Override
	public List<Item> getAllItem() {
		// TODO Auto-generated method stub
		return itemDao.getAllItem();
	}

	@Override
	public Item getTItemById(long id) throws ItemException {
		// TODO Auto-generated method stub
		return itemDao.getItemId(id);
	}

	@Override
	public Item saveItem(Item item) throws ItemException {
		// TODO Auto-generated method stub
		return itemDao.saveItem(item);
	}

	@Override
	public void removeItem(Item item) throws ItemException {
		// TODO Auto-generated method stub
		itemDao.removeItem(item);
		
	}

	

}
