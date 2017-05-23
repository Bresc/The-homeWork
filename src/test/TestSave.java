package test;

import model.entity.Place;
import persitence.FileSite;

public class TestSave {

	public static void main(String[] args) {
		Place site1 = new Place(57, (byte) 1, "Colombia", "COL", null);
		Place site2 = new Place(15, (byte) 2, "Boyaca", "BOY", site1);
		Place site3 = new Place(001, (byte) 3, "Tunja", "TUN", site2);
		FileSite fileSite = new FileSite("src/data/aca.bin");
//		fileSite.sort();
		fileSite.open("rw");
		fileSite.save(site1, 0);
		fileSite.save(site2, 1);
		fileSite.save(site3, 2);
		fileSite.close();
//		fileSite.open("r");
//		Place place;
//		for (int i = 0; i < 3 ; i++) {
//			place = fileSite.load(i);
//			System.out.println(place.getCode());
//			System.out.println(place.getType());
//			System.out.println(place.getName());
//			for (int j = 0; j < place.getName().length(); j++) {
//				System.err.println(place.getName().charAt(j));
//			}
//			System.out.println(place.getAbreviate());
//			System.out.println(place.getFullCodeFabian());
//		}
//		fileSite.close();
	}
}