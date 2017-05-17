package persistence;

import model.Place;

public class DaoPlace {
	private int code;
	private byte level;
	private char[] name;
	private char[] abre;
	private char[] codeParent;
	public static final int RECORD_SIZE = 40;
	private static final int NAME_LENGTH = 20;
	
	public DaoPlace(int code, byte level, char[] name, char[] abre, char[] codeParent) {
		super();
		this.code = code;
		this.level = level;
		this.name = name;
		this.abre = abre;
		this.codeParent = codeParent;
	}

	public DaoPlace placeToBin(Place place){
		return new DaoPlace(place.getCode(), place.getLevel(),setName(place.getName()) , charAbre(place.getAbre()), codeParent);
	}
	
	private char[] charAbre(String abre) {
		this.abre = new char[NAME_LENGTH];
		for (int i = 0; i < Math.min(this.abre.length, NAME_LENGTH); i++) {
			this.abre[i] = abre.charAt(i);
		}
		return this.abre;
	}

	private char[] setName(String name) {
		this.name = new char[NAME_LENGTH];
		for (int i = 0; i < Math.min(this.name.length, NAME_LENGTH); i++) {
			this.name[i] = name.charAt(i);
		}
		return this.name;
	}
	
	private String charName(char[] name){
		String aux = "";
		for (int i = 0; i < this.name.length; i++) {
			aux += name[i];
		}
		return aux;
	}

	private String charAbre(char[] abre){
		String aux = "";
		String.valueOf(abre);
		for (int i = 0; i < this.abre.length; i++) {
			aux += abre[i];
		}
		return aux;
	}	
	
	public Place binToPlace(DaoPlace daoPlace){
		return new Place(code, level, charName(name), charAbre(abre), null);
	}
}