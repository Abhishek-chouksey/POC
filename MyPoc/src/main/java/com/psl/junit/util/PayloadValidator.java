package com.psl.junit.util;

import com.psl.junit.model.Item;

public class PayloadValidator {
	
	public static boolean validateCreatePayload(Item item){
		if (item.getId()== null){
			return true;
		}
		return false;
	}

}
