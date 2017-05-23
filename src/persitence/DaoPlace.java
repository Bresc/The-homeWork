package persitence;

import java.nio.charset.Charset;

import org.w3c.dom.NameList;

import model.entity.Place;

public class DaoPlace {
	public static final int RECORD_NULL = -1;
	public static final int RECORD_SIZE = 39;
	public static final int NAME_LENGTH = 20;
	public static final int ABREVIATE_LENGTH = 10;
	
	private int code; //codigos unicos establecidos por una entidad DANE
	private byte type; //continente pais departamento municipio correjimiento 
	private byte[] name;
	private byte[] abreviate;
	private long codeParent; //codigo del parent 
	
	public DaoPlace(int code, byte type, String name, String abreviate, Place parent) {
		this.code = code;
		this.type = type;
		this.name = stringToArray(name, NAME_LENGTH);
		this.abreviate = stringToArray(abreviate, ABREVIATE_LENGTH);
		this.codeParent = parent == null? RECORD_NULL: parent.getFullCodeFabian();
	}
	//EN VEZ DE GRABAR UTF GRABAR UN ARREGLO DE CHAR GUARDAR ARREGLOS
	public DaoPlace(Place place) {
		this.code = place.getCode();
		this.type = place.getType();
		this.name = stringToArray(place.getName(), NAME_LENGTH);
		this.abreviate = stringToArray(place.getAbreviate(), ABREVIATE_LENGTH);
		this.codeParent = place.getParent() != null? place.getParent().getFullCodeFabian(): RECORD_NULL;
	}
	
	public DaoPlace() {
		
	}

	public byte[] getName() {
		return name;
	}
	public byte[] getAbreviate() {
		return abreviate;
	}
	private byte[] stringToArray(String string, int size) {
		byte[] array = new byte[size];
		for (int i = 0; i < Math.min(string.length(), size); i++) {
			array[i] = (byte)string.charAt(i);
		}
		return array;
	}
	
	private String arrayToString(byte[] array, int size){
		String string = "";
		if (array != null) {
			for (int i = 0; i < size; i++) {
				string += (char)array[i];
			}
		}
		return string;
		
	}
	
	public byte[] iDontKnow(){
		return new String(name).getBytes(Charset.forName("UTF_8"));
	}
	
	public	String getNameByte() {
		return arrayToString(this.name, NAME_LENGTH);
	}

	public	String getAbreviateByte() {
		return arrayToString(this.abreviate, ABREVIATE_LENGTH);
	}
	
	public void setName(String name){
		this.name = stringToArray(name, NAME_LENGTH);
	}
	
	public void setAbreviate(String abreviate){
		this.abreviate = stringToArray(abreviate, ABREVIATE_LENGTH);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public byte getType() {
		return type;
	}

	public void setType(byte type) {
		this.type = type;
	}

	public long getCodeParent() {
		return codeParent;
	}

	public void setCodeParent(long codeParent) {
		this.codeParent = codeParent;
	}

	public void setName(byte[] name) {
		this.name = name;
	}

	public void setAbreviate(byte[] abreviate) {
		this.abreviate = abreviate;
	}
//	public DaoPlace placeToBin(Place place) {
//		return this.getFullCode();
//	}

	public Place binToPlace(){
		return new Place(this.code, this.type, this.getNameByte(), getAbreviateByte(), null);
	}
}