package test;

import model.entity.Place;

public class TestSite {

	public static void main(String[] args) {
		Place site1 = new Place(57, (byte) 1, "Colombia", "COL", null);
		Place site2 = new Place(15, (byte) 2, "Boyaca", "BOY", site1);
		Place site3 = new Place(001, (byte) 3, "Tunja", "TUN", site2);
		
//		System.out.println(site3.getName() + "(" + site1.getParent().getAbreviate() + " )");
//		System.out.println(site1.getFullCodeVer1() + " > " + site1.getName());
//		System.out.println(site2.getFullCodeVer1() + " > " + site2.getName());
//		System.out.println(site3.getFullCodeVer1() + " > " + site3.getName());
		System.out.println(site3.getFullCodeFabian());
		site3.codeWithRecursiveMine(site3);
		System.out.println(site3.codeAux);
//		System.out.println(site1.getFullCodeFabian() + " > " + site1.getName());
//		System.out.println(site2.getFullCodeFabian() + " > " + site2.getName());
//		System.out.println(site3.getFullCodeFabian() + " > " + site3.getName());
	}
}
