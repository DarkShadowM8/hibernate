package com.example.mvc_task;

import com.example.mvc_task.controllers.PersonEditor;
import com.example.mvc_task.enums.Gender;
import com.example.mvc_task.models.Person;
import com.vaadin.Application;
import com.vaadin.ui.*;

public class Mvc_taskApplication extends Application {
	@Override
	public void init() {
		Window mainWindow = new Window("Mvc_task Application");
		Label label = new Label("Hello Vaadin user");
		
		Person person = new Person();
		person.setId(0);
		person.setName("Ali");
		person.setAge(19);
		person.setGender(Gender.Male);
		
		PersonEditor editor1 = new PersonEditor(person);
		PersonEditor editor2 = new PersonEditor(person);
		
		HorizontalLayout hl = new HorizontalLayout();
		
		hl.addComponent(editor1);
		hl.addComponent(editor2);
		
		mainWindow.addComponent(hl);
		setMainWindow(mainWindow);
	}

}
