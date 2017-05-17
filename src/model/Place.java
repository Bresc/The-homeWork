package model;

public class Place {

	private int code;
	private byte level;
	private String name;
	private String abre;
	private Place Parent;
	
	public Place(int code, byte level, String name, String abre, Place parent) {
		this.code = code;
		this.level = level;
		this.name = name;
		this.abre = abre;
		Parent = parent;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public byte getLevel() {
		return level;
	}

	public void setLevel(byte level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbre() {
		return abre;
	}

	public void setAbre(String abre) {
		this.abre = abre;
	}

	public Place getParent() {
		return Parent;
	}

	public void setParent(Place parent) {
		Parent = parent;
	}
	
}