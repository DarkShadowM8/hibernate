package com.hamid.house_room;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Room {
	
	@Id
	private int id;
	
	private int numOfBeds;
	private boolean furnished;
	private boolean attachedBath;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumOfBeds() {
		return numOfBeds;
	}
	public void setNumOfBeds(int numOfBeds) {
		this.numOfBeds = numOfBeds;
	}
	public boolean isFurnished() {
		return furnished;
	}
	public void setFurnished(boolean furnished) {
		this.furnished = furnished;
	}
	public boolean isAttachedBath() {
		return attachedBath;
	}
	public void setAttachedBath(boolean attachedBath) {
		this.attachedBath = attachedBath;
	}
	
	
}
