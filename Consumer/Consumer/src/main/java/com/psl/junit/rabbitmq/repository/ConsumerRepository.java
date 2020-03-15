package com.psl.junit.rabbitmq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psl.junit.rabbitmq.model.Activity;

@Repository
public interface ConsumerRepository extends JpaRepository<Activity, String>{

}
