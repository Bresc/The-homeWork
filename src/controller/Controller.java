package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import model.entity.Place;
import persitence.Persistence;
import views.MainWindow;

public class Controller implements ActionListener{

	private MainWindow mainWindow;
	private Persistence persistence;

	public Controller() {
		this.mainWindow = new MainWindow();
		this.persistence = new Persistence();
		addThatToTable();
		theBin();
	}
	
	public void theBin(){
		try {
			this.persistence.read(persistence.readTheText());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addThatToTable(){
		try {
			for (Place place : persistence.readTheText()) {
				mainWindow.addToTableCity(place.toVector());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		switch (Action.valueOf(event.getActionCommand())) {
		case ADD_CITY:
			addCity();
			break;
		case DELETE_CITY:
			deleteCity();
			break;
		case SERCH_CITY:
			serchCity();
		default:
			break;
		}
	}
	
	private void serchCity() {
		// TODO Auto-generated method stub
		
	}

	private void deleteCity() {
		// TODO Auto-generated method stub
		
	}

	private void addCity() {
		// TODO Auto-generated method stub
		
	}
	
}