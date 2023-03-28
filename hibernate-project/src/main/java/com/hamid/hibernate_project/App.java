package com.hamid.hibernate_project;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.github.javafaker.Faker;
import com.hamid.hibernate_project.beans.Car;
import com.hamid.hibernate_project.beans.Person;
import com.hamid.hibernate_project.utils.HibernateUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Service service = new Service();
    	service.getCarOfPersonCriteria('s');;
    }
}
