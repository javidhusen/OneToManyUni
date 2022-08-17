package com.ty.organization.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.organization.dto.Bus;
import com.ty.organization.dto.Organization;

public class OrganizationDao {

	public void saveOrganization() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Organization org  = new Organization();
		org.setName("KSRTC");
	    org.setAdress("Banglore");
	    
	    Bus b = new Bus();
	    b.setType("Non A/C");
	    b.setCapacity(60);
	    
	    Bus b1 = new Bus();
	    b1.setType("Non A/C");
	    b1.setCapacity(50);
	     
	    Bus b2 = new Bus();
	    b2.setType("BMTC");
	    b2.setCapacity(50);
	    
	    List<Bus> bus = new ArrayList<Bus>();
	    bus.add(b);
	    bus.add(b1);
	    bus.add(b2);
	    
	     org.setBus(bus);
	     
	    entityTransaction.begin();
	    entityManager.persist(org);
	    entityManager.persist(b);
	    entityManager.persist(b1);
	    entityManager.persist(b2);
	    entityTransaction.commit();
				
	}
}
