package model.dao;

import java.io.Serializable;
import java.util.ArrayList;

import model.entity.Hotel;
import model.entity.Place;
import model.exception.DidNotFindHotel;

public class HotelGroup implements Serializable{

	private ArrayList<Hotel> hotels;
	
	public HotelGroup() {
		this.hotels = new ArrayList<>();
	}
	
	public HotelGroup(ArrayList<Hotel> hotelList){
		this.hotels = hotelList;
	}
	
	public static Hotel creatHotel(String name, String nameLarge, String address, Place place, String phone, String url, String email){
		Hotel hotel = new Hotel(name, nameLarge, address, place, phone, url, email);
		return hotel;
	}
	
	public void addHotel(Hotel hotel){
		this.hotels.add(hotel);
	}
	
	public ArrayList<Hotel> findHotel(String nameHotel){
		ArrayList<Hotel> hotelAux = new ArrayList<>();
		for (Hotel hotel : hotels) {
			if (hotel.getName().equals(nameHotel)) {
				hotelAux.add(hotel);
			}
		}
		return hotelAux;
	}
	
	public Hotel deleteHotel(String nameHotel) throws DidNotFindHotel{
		Hotel hote = null;
		for (Hotel hotel : hotels) {
			if (hotel.getName().equals(nameHotel)) {
				hote = hotel;
				hotels.remove(hotel);
			}
		}
		if (hote.equals(null)) {
			throw new DidNotFindHotel();
		}else{
			return hote;
		}
	}
	
	public ArrayList<Hotel> getTheArray(){
		return hotels;
	}
}