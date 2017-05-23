package test;

import model.entity.Place;
import persitence.DaoPlace;

public class TestDaoPlace {

	public static void main(String[] args) {
		Place site1 = new Place(57, (byte) 1, "Colombia", "COL", null);
		Place site2 = new Place(15, (byte) 2, "Boyaca", "BOY", site1);
		Place site3 = new Place(001, (byte) 3, "Tunja", "TUN", null);
		site3.setParent(site2);
		
		char[] myName= {'T', 'U', 'N', 'J', 'A'};

		DaoPlace daoPlace = new DaoPlace(site1);
//		DaoPlace daoPlace = new DaoPlace(1, (byte) 2, myName, null, null);
//		System.out.println("name " + daoPlace.getName() + " " + daoPlace.getName().length());
//		daoPlace.setName("este un nombre de ciudad muy muy largo de mas de 20");
//		System.out.println("name " + daoPlace.getName() + " " + daoPlace.getName().length());
	}
}
