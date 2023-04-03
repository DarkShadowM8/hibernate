package com.example.mvc_task.controllers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.example.mvc_task.enums.Gender;
import com.example.mvc_task.models.Person;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.AbstractField;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.Select;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PersonEditor extends VerticalLayout implements PropertyChangeListener{

	private TextField idField;
    private TextField nameField;
    private TextField ageField;
    private Select genderField;
    
    private Person person;
    
    public PersonEditor(Person person) {
    	// setPerson(person);
    	this.person = person;
    	person.addPropertyChangeListener(this);
		initUI();
	}
    
    private void initUI() {

    	idField = new TextField("ID");
        idField.setValue(person.getId());
        idField.setImmediate(true);
    	update(idField);
    	
    	nameField = new TextField("Name");
    	nameField.setValue(person.getName());
    	nameField.setImmediate(true);
    	update(nameField);
    	
    	ageField = new TextField("Age");
    	ageField.setValue(person.getAge());
    	ageField.setImmediate(true);
    	update(ageField);
    	
    	genderField = new Select("Select an option");
    	for (Gender option : Gender.values()) {
    		genderField.addItem(option);
    		genderField.setItemCaption(option, option.getDisplayName());
    	}
    	genderField.setValue(person.getGender());
    	genderField.setImmediate(true);
    	update(genderField);
    	
    	addComponent(idField);
    	addComponent(nameField);
    	addComponent(ageField);
    	addComponent(genderField);
	}
    
    public void setPerson(Person person) {
    	this.person.removePropertyChangeListener(this);
    	this.person = person;
    	this.person.addPropertyChangeListener(this);
    }
    
    private void update(final TextField fieldName){
    	fieldName.addListener(new ValueChangeListener() {
            public void valueChange(ValueChangeEvent event) {
            	System.out.println("Update Invoked!!!");
            	if(fieldName.getCaption().equals("ID"))
            		person.setId(Integer.parseInt(fieldName.getValue().toString()));
            	else if(fieldName.getCaption().equals("Name"))
            		person.setName(fieldName.getValue().toString());
            	else if(fieldName.getCaption().equals("Age"))
            		person.setAge(Integer.parseInt(fieldName.getValue().toString()));
            }
        });
    }
    
    private void update(final Select fieldName) {
    	fieldName.addListener(new Property.ValueChangeListener() {
            public void valueChange(ValueChangeEvent event) {
            	person.setGender(fieldName.getValue().toString());
            }
    	});
    }
    

	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("Property Change method Invoked!!");
		// TODO Auto-generated method stub
		if (evt.getPropertyName().equals("setId"))
			idField.setValue(person.getId());
		else if (evt.getPropertyName().equals("setName"))
			nameField.setValue(person.getName());
		else if (evt.getPropertyName().equals("setAge"))
			ageField.setValue(person.getAge());
		else if (evt.getPropertyName().equals("setGender"))
			genderField.setValue(person.getGender());
	}
}

//private void addPropertyChangeListenerForPerson() {
//person.addPropertyChangeListener(new PropertyChangeListener() {
//    public void propertyChange(PropertyChangeEvent evt) {
//        if ("id".equals(evt.getPropertyName()))
//            idField.setValue(evt.getNewValue().toString());
//        else if ("name".equals(evt.getPropertyName())) 
//            nameField.setValue((String) evt.getNewValue());
//        else if ("age".equals(evt.getPropertyName()))
//            ageField.setValue(evt.getNewValue().toString());
//    }
//});
//}

