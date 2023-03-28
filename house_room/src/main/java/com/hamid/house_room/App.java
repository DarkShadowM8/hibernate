package com.hamid.house_room;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Room room = new Room();
    	room.setId(2);
    	room.setNumOfBeds(2);
    	room.setAttachedBath(true);
    	room.setFurnished(true);
    	
    	House house = new House();
    	house.setId(2);
    	house.setHouseNo("C-670");
    	house.getRooms().add(room);
    	
    	
    	// configuration
    	Configuration config = new Configuration().configure().addAnnotatedClass(House.class).addAnnotatedClass(Room.class);
    	
    	// starting a session
    	SessionFactory sf = config.buildSessionFactory();
    	Session session = sf.openSession();
    	
    	// starting transaction
    	Transaction transaction = session.beginTransaction();
    	
    	// hiting the queries
    	session.save(room);
    	session.save(house);
    	
    	// commiting the transaction
    	transaction.commit();
    	
    	
        System.out.println( "Hello World!" );
    }
}
