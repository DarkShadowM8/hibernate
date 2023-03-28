package com.hamid.hibernate_project.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import com.hamid.hibernate_project.beans.Car;	
import com.hamid.hibernate_project.beans.Person;


public class HibernateUtils {
	
	public static Session getSession(){
		AnnotationConfiguration config = new AnnotationConfiguration().configure().addAnnotatedClass(Person.class).addAnnotatedClass(Car.class);
		SessionFactory sessionFactory = config.buildSessionFactory();
		return sessionFactory.openSession();
	}
}
