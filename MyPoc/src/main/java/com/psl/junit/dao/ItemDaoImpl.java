package com.psl.junit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.psl.junit.exception.ItemException;
import com.psl.junit.model.Item;
import com.psl.junit.rabbitmq.producer.MessageProducer;
import com.psl.junit.repository.ItemRepository;
import com.psl.junit.util.PayloadValidator;

@Repository("dao")
public class ItemDaoImpl implements ItemDao{
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	MessageProducer messageproducre;
	

	@Override
	public List<Item> getAllItem() {
		// TODO Auto-generated method stub
		messageproducre.sendMessage("getAllItems");
		return (List<Item>) itemRepository.findAll();
	}

	@Override
	public Item getItemId(long id) throws ItemException {
		Item item = itemRepository.findById(id).get();
		// TODO Auto-generated method stub
		if (item  == null || item.getId() <= 0){
            throw new ItemException("Item doesn´t exist");
    	}
		System.out.println("in get itembyid");
		messageproducre.sendMessage("getItemById");
		return itemRepository.findById(id).get();
	}

	@Override
	public Item saveItem(Item item) throws ItemException {
		// TODO Auto-generated method stub
		if (!PayloadValidator.validateCreatePayload(item)){
            throw new ItemException("Payload format wrong, id must not be defined");
    	}
		messageproducre.sendMessage("saveItem");
		return itemRepository.save( item);
	}

	@Override
	public void removeItem(Item item) throws ItemException {
		// TODO Auto-generated method stub
		if (item == null || item.getId() <= 0){
            throw new ItemException("item to update doesn´t exist");
    	}
		messageproducre.sendMessage("removeItem");
		itemRepository.delete(item);
	}

}
