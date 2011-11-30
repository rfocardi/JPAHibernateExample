package com.mkyong;

import com.mkyong.user.DBUser;
import com.mkyong.util.HibernateUtil;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Date;

public class AppJPA {
	public static void main(String[] args) {

        System.out.println("Maven + Hibernate + MySQL");
		EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

		DBUser user = new DBUser(666, "pippo", "riccardo");
 
	    em.persist(user);
        tx.commit();
        em.close();
	}
}