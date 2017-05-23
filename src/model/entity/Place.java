package model.entity;

import java.io.Serializable;
import java.util.logging.Level;

public class Place implements Serializable{

	private int code; //codigos unicos establecidos por una entidad DANE
	private byte type; //continente pais departamento municipio correjimiento 
	private String name;
	private String abreviate;
	private Place parent;
	private boolean parentB  = false;
	public long codeAux;
	
	
	public Place(int code, byte type, String name, String abreviate, Place parent) {
		super();
		this.code = code;
		this.type = type;
		this.name = name;
		this.abreviate = abreviate;
		this.parent = parent;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbreviate() {
		return abreviate;
	}

	public void setAbreviate(String abreviate) {
		this.abreviate = abreviate;
	}

	public Place getParent() {
		return parent;
	}

	public void setParent(Place parent) {
		this.parent = parent;
	}

	/**
	 * genera el codigo del lugar
	 * 1. 3 digitos pais
	 * 2. 3 digitos depto
	 * 3. 3 digitos municipio
	 * 4. si tiene mas son otros 3 digitos
	 * @return
	 */
	public long  getFullCodeVer1(){
		switch (this.type){
		case 1 : return code;
		case 2 : return parent.code * 1000 + code;
		case 3 : return parent.parent.code * 1000000 + parent.code * 1000 + code;
		case 4 : return parent.parent.parent.code * 1000000000 + parent.parent.code * 1000000 + parent.code * 1000 + code;
		default : return 0;
		}
	}

	public long  getFullCodeMejorado(){
		long myCode = 1;
		switch (this.type){
		case 1 : myCode = code;
		case 2 : myCode = parent.code * 1000 + code;
		case 3 : myCode = parent.parent.code * 1000000 + parent.code * 1000 + code;
		case 4 : myCode = parent.parent.parent.code * 1000000000 + parent.parent.code * 1000000 + parent.code * 1000 + code;
		default : myCode = 0;
		}
		return myCode;
	}

	public int  getFullCodeRepeticion(){
		long myCode = this.code;
		Place auxParent = this.parent;
		while (auxParent != null) {
			//			myCode = myCode + auxParent
		}
		return 0;
	}

	public void codeWithRecursiveMine(Place place){
		long aux = 0;
		long power = 1;
		if(place != null){
			power *= 1000;
			long codes = place.code;
//			System.out.println(codes);
			
//			System.out.println(codeAux);
			codeWithRecursiveMine(place.parent);
			codeAux = codeAux*power + codes;
		}
		return;
	}
	
	public long  getFullCodeRecursive(Place place){
		long power = 1;
		long aux = 0;
		System.out.println(aux);
		if (hasParent()) {
			aux = getFullCodeRecursive(place.getParent())* 1000 + place.code;
			System.out.println(aux);
		}
		return aux;
	}

	private boolean hasParent() {
		if (parent != null) {
			parentB = true;
		}
		return parentB;
	}

	public long getFullCodeFabian(){
		long power = 1;
		long fullCode = this.code;
		Place auxPlace = this.parent;
		for (int i = 1; i < this.type && this.type > 1; i++) {
			power *= 1000;
			fullCode += auxPlace.code * power;
			auxPlace = auxPlace.getParent();
		}
		return fullCode;
	}

	public Object[] toVector(){
	return new Object[]{code, name};
	}
	
	@Override
	public String toString() {
		return "Place [code=" + code + ", Name= " + name + "  Parent= "+ parent+"]";
	}
}




//hacerlo con recursividad