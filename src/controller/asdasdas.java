package controller;

import java.io.IOException;
import java.util.ArrayList;

import model.dao.HotelGroup;
import model.entity.Hotel;
import persitence.PersistenceSerializable;

public class asdasdas {

	private ArrayList<Hotel> dao;
	
	public asdasdas() {
		try {
			this.dao = PersistenceSerializable.readTheFile();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		asdasdas a = new asdasdas();
		System.out.println("asds");
		System.out.println(a.dao.toString());
	}
}
