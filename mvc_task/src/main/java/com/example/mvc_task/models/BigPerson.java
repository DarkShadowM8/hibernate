package com.example.mvc_task.models;

import java.util.ArrayList;
import java.util.List;

public class BigPerson extends Person{

	private List<Person> childerns = new ArrayList<Person>();

	public List<Person> getChilderns() {
		return childerns;
	}

	public void setChilderns(List<Person> childerns) {
		List<Person> oldList = this.childerns;
		this.childerns = childerns;
		super.getPCS().firePropertyChange("ChildernsUpdated", oldList, childerns);
	}
	
	public int getChildCount() {
		return childerns.size();
	}
	public Person getChildAt(int index) {
		try {
			Person person = childerns.get(index);
			return person;
		}
		catch (Exception e) {
			System.out.println("Child not found");
			return null;
		}
	}
	
	public void addChildAt(int index,Person person) {
		childerns.add(index, person);
	}
	
	public String removeChildAt(int index) {
		try {
			Person person = childerns.remove(index);
			return "Removed Successfully!!!";
		}
		catch (Exception e) {
			return "Child not found";
		}
	}
}
