package com.psl.junit.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.verification.ArgumentsAreDifferent;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import com.psl.junit.dao.ItemDao;
import com.psl.junit.exception.ItemException;
import com.psl.junit.model.Item;
import com.psl.junit.service.ItemServiceImpl;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
//@WebMvcTest(value = ItemController.class)
public class ItemServiceTest {
	
	@Mock
	private ItemDao itemDao;;
	
	@InjectMocks
	private ItemServiceImpl itemService;
	
	@org.junit.Before
	public void init() {
	MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAllItemTest() throws Exception{
		
		List<Item> input = new ArrayList<Item>();
		input.add(new Item((long) 3,"Item3",20,100));
		input.add(new Item((long) 2,"Item2",10,200));
		
		Mockito.when(itemService.getAllItem()).thenReturn(input);
		assertEquals(2, itemService.getAllItem().size());
		verify(itemDao, atLeast(1)).getAllItem();
	}
	
	@Test
	public void getItemByIdTest() throws ItemException
	{
		Item item = new Item((long) 3,"Item3",20,100);
		Mockito.when(itemService.getTItemById(Mockito.anyLong())).thenReturn(item);
		assertEquals(3, itemService.getTItemById(Mockito.anyLong()).getId());
		
		verify(itemDao, atLeast(1)).getItemId(Mockito.anyLong());
	}
	
	
	@Test
	public void saveItemTest() throws ItemException {
		Item item = new Item((long) 3,"Item3",20,100);
		Mockito.when(itemService.saveItem(Mockito.any())).thenReturn(item);
		
		assertEquals(3, itemService.saveItem(item).getId());
		verify(itemDao, atLeast(1)).saveItem(item);
		
	}
	
	@Test
	public void removeItemTest() throws ItemException {
		
		Item item = new Item((long) 3,"Item3",20,100);
		
//		doAnswer(new Answer<Void>() {
//		    public Void answer(InvocationOnMock invocation) {
//		      Object[] args = invocation.getArguments();
//		      System.out.println("called with arguments: " + Arrays.toString(args));
//		      return null;
//		    }
//		}).when(itemDao).removeItem(anyObject());
		
		 doNothing().when(itemDao).removeItem(item);
		 
		 itemService.removeItem(item);

	    

	     // test that there was a call
		 verify(itemDao, atLeast(1)).removeItem(item);
	}
	

	
	
	

}

