package com.psl.junit.rabbitmq.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.psl.junit.rabbitmq.model.Activity;
import com.psl.junit.rabbitmq.repository.ConsumerRepository;

@Repository
public class ConsumerDaoImpl implements ConsumerDao {

	@Autowired
	ConsumerRepository consumerRepository;
	@Override
	public void getAllCount() {
		// TODO Auto-generated method stub
		Optional<Activity> newActivity = consumerRepository.findById("getAllItems");
		if(!newActivity.isPresent())
		{
			consumerRepository.save(new Activity("getAllItems",1));
			Optional<Activity> temp=consumerRepository.findById("getAllItems");
//			temp.get().incrimentCount();
//			consumerRepository.save(temp.get());
//			
			System.out.println("Inserted");
			
		}
		else
		{
			newActivity.get().incrimentCount();;
			consumerRepository.save(newActivity.get());
		}
	}

	@Override
	public void getItemByIdCount() {
		// TODO Auto-generated method stub
		System.out.println("inside idbycount");
		Optional<Activity> newActivity = consumerRepository.findById("getItemById");
		if(!newActivity.isPresent())
		{
			consumerRepository.save(new Activity("getItemById",1));
			Optional<Activity> temp=consumerRepository.findById("getItemById");
//			temp.get().incrimentCount();
//			consumerRepository.save(temp.get());
//			
			System.out.println("Inserted");
			
		}
		else
		{
			newActivity.get().incrimentCount();;
			consumerRepository.save(newActivity.get());
		}
	}

	@Override
	public void saveItemCount() {
		// TODO Auto-generated method stub
		System.out.println("inside save");
		Optional<Activity> newActivity = consumerRepository.findById("saveItem");
		if(!newActivity.isPresent())
		{
			consumerRepository.save(new Activity("saveItem",1));
			Optional<Activity> temp=consumerRepository.findById("saveItem");
//			temp.get().incrimentCount();
//			consumerRepository.save(temp.get());
			System.out.println(temp);
			System.out.println("Inserted");
			
		}
		else
		{
			newActivity.get().incrimentCount();;
			consumerRepository.save(newActivity.get());
		}
	}

	@Override
	public void deleteItemCount() {
		// TODO Auto-generated method stub
		Optional<Activity> newActivity = consumerRepository.findById("removeItem");
		if(!newActivity.isPresent())
		{
			consumerRepository.save(new Activity("removeItem",1));
			Optional<Activity> temp=consumerRepository.findById("removeItem");
//			temp.get().incrimentCount();
//			consumerRepository.save(temp.get());
//			
			System.out.println("deleted");
			
		}
		else
		{
			newActivity.get().incrimentCount();;
			consumerRepository.save(newActivity.get());
		}
	}

}
