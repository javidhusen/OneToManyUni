package com.ty.mobile.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

import com.ty.mobile.dto.Mobile;
import com.ty.mobile.dto.Sim;

public class MobileDao {

	public void saveMobile(){
		
		EntityManagerFactory factory  = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction entityTransaction =entityManager.getTransaction();
		
		Mobile mobile = new Mobile();
		mobile.setName("Vivo");
		mobile.setCost(11000);
		
		Sim sim = new Sim();
		sim.setProvider("BSNL");
		sim.setImrc("BS5826");
		
		Sim sim2 = new Sim();
		sim2.setProvider("VI");
		sim2.setImrc("VI9548");
		
		List<Sim> sim1 = new ArrayList<Sim>();
		sim1.add(sim);
		sim1.add(sim2);
		
		mobile.setSim(sim1);
		
		
		entityTransaction.begin();
		entityManager.persist(mobile);
		entityManager.persist(sim);
		entityManager.persist(sim2);
		entityTransaction.commit();
	}
	
	public Mobile getMobileById(int id) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=factory.createEntityManager();
		
		Mobile mobile = entityManager.find(Mobile.class, id);
		if(mobile != null) {
			return mobile;
		}
		return null;
		
	}
}
