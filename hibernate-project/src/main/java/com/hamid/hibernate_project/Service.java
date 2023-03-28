package com.hamid.hibernate_project;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.github.javafaker.Faker;
import com.hamid.hibernate_project.beans.Car;
import com.hamid.hibernate_project.beans.Person;
import com.hamid.hibernate_project.utils.HibernateUtils;

public class Service {
		
	Session session=HibernateUtils.getSession();
	Transaction transaction=session.beginTransaction();
	public void create() {

    	Faker faker = new Faker();
        
        String name, address;
        String[] models = {"Honda Civic", "Honda Vezel", "Honda City", "GLI", "KIA Sportage"};
        
		for(int i = 0; i < 10; i++) {
		        	
			name = faker.name().fullName();
        	address = faker.address().buildingNumber() + ", " + faker.address().cityName() + ", " + faker.address().country();
        	
        	System.out.println("Person " + (i+1) + " added");
        	
        	Person person = new Person();
        	person.setName(name);
        	person.setAddress(address);
        	person.setAge(faker.number().numberBetween(18, 100));
        	person.setMarried(faker.number().numberBetween(0, 2));
        	
        	for (int j = 0; j < faker.number().numberBetween(0, 5); j++) {
        		Car car = new Car();
        		car.setModelName(models[faker.number().numberBetween(0, 5)]);
        		car.setRegistrationNo(faker.letterify("???") + faker.numerify("###"));
        		car.setOwner(person);
        		session.save(car);
        		person.getCars().add(car);
        	}
        	session.save(person);
        }
        transaction.commit();
	}
	public void getPersons(){
		Collection<Person> persons = session.createQuery("from Person").list();
		for (Person person : persons) {
			System.out.println(person.toString());
			for(Car car : person.getCars()) {
				System.out.println("     " + car.toString());
			}
		}
	}
	public void getPersonsWithCharacter(char character){
		Collection<Person> persons = session.createQuery("from Person where name LIKE :startWith")
				.setParameter("startWith", character + "%")
				.list();
		for (Person person : persons) {
			System.out.println(person.toString());
		}
	}
	public void getMarriedPerson() {
		Collection<Person> persons = session.createQuery("from Person where married = 1 AND size (cars) > 2").list();
		for (Person person : persons) {
			System.out.println(person.toString());
			for(Car car : person.getCars()) {
				System.out.println("     " + car.toString());
			}
		}
	}
	public void getCarOfPerson(char character){
		Collection<Car> cars = session.createQuery("SELECT c FROM Car c JOIN c.owner p WHERE p.name LIKE :startWith")
			    .setParameter("startWith", character + "%")
			    .list();
		for (Car car : cars) {
			System.out.println(car.toString());
		}
	}

	public void getPersonsCritera(){
		Criteria cr = session.createCriteria(Person.class);
		Collection<Person> persons = cr.list();
		for (Person person : persons) {
			System.out.println(person.toString());
			for(Car car : person.getCars()) {
				System.out.println("     " + car.toString());
			}
		}
	}
	public void getPersonsWithCharacterCriteria(char character){
		Criteria cr = session.createCriteria(Person.class);
		Collection<Person> persons = cr.add(Restrictions.ilike("name", character+"%")).list();
		for (Person person : persons) {
			System.out.println(person.toString());
		}
	}
	public void getMarriedPersonCriteria() {
		Criteria cr = session.createCriteria(Person.class);
		Collection<Person> persons = cr.add(Restrictions.eq("married", true)).list();
		for (Person person : persons) {
			System.out.println(person.toString());
			for(Car car : person.getCars()) {
				System.out.println("     " + car.toString());
			}
		}
	}
	public void getCarOfPersonCriteria(char character){
		Criteria cr = session.createCriteria(Car.class);
		cr.createAlias("owner", "p");
		Collection<Car> cars = cr.add(Restrictions.ilike("p.name", character+"%")).list();
		for (Car car : cars) {
			System.out.println(car.toString());
		}
	}
}

