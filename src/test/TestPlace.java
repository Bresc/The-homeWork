package test;

import model.Place;

public class TestPlace {

	public static void main(String[] args) {
		Place co = new Place(57, (byte)1, "Colombia", "COL", null);
		Place Bo = new Place(15, (byte)2, "Boyacá", "BOY", co);
		Place place = new Place(001, (byte) 3, "Tunja", "TUN", Bo);
		System.out.println(place.getParent().getParent().getCode()+ "-"+ place.getParent().getCode()+"-" + place.getCode());
	}
}