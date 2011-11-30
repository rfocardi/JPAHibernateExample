package com.mkyong.util;
 
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
 
    private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();
 
    private static EntityManagerFactory buildEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("helloworld");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
 
	public static void shutdown() {
		// Close caches and connection pools
		getEntityManagerFactory().close();
	}
 
}