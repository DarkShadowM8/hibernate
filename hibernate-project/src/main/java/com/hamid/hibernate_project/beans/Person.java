	package com.hamid.hibernate_project.beans;
	
	import java.util.ArrayList;
	import java.util.List;
	
	import javax.annotation.processing.Generated;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.OneToMany;
	
	@Entity
	public class Person {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		
		private String name;
		private String address;
		private boolean married;
		private int age;
		
		@OneToMany
		private List<Car> cars = new ArrayList<>();
		
		public List<Car> getCars() {
			return cars;
		}
		public void setCars(List<Car> cars) {
			this.cars = cars;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			address = address;
		}
		public boolean isMarried() {
			return married;
		}
		public void setMarried(int i) {
			if (i == 0) {
				this.married = false;
			}
			else {
				this.married = true;
			}
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		@Override
		public String toString() {
			return "Person [id=" + id + ", name=" + name + ", Address=" + address + ", married=" + married + ", age=" + age + "]";
		}
		
		
	}
