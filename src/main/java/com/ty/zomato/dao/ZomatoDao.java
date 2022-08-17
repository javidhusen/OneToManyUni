package com.ty.zomato.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.zomato.dto.FoodOrder;
import com.ty.zomato.dto.Item;

public class ZomatoDao {

	void saveFoodOrder() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction entityTransaction  = entityManager.getTransaction();
		
		FoodOrder order = new FoodOrder();
		order.setAdress("Katriguppe");
		order.setPhone(9845762441l);
		order.setCustername("Tom");
		
		Item item = new Item();
		item.setName("Biryani");
		item.setQuantity(1);
		item.setCost(200);
		
		Item item1 = new Item();
		item1.setName("palav");
		item1.setQuantity(1);
		item1.setCost(70);
		
		Item item2 = new Item();
		item2.setName("Dosa");
		item2.setQuantity(1);
		item2.setCost(60);
		
		List<Item> ls = new ArrayList();
		ls.add(item);
		ls.add(item1);
		ls.add(item2);
		
		order.setItem(ls);
		
		entityTransaction.begin();
		entityManager.persist(order);
		entityManager.persist(item);
		entityManager.persist(item2);
		entityManager.persist(item1);
		entityTransaction.commit();
		
	}
}
