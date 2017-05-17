package persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import model.Place;

public class FileSite {
	
	private File file;
	private RandomAccessFile randomAccessFile;
	
	public FileSite(String fileName) {
		this.file = new File(fileName);
	}
	
	public void open(String openForm) throws FileNotFoundException{
		this.randomAccessFile = new RandomAccessFile(this.file, openForm);
	}
	
	public void close() throws IOException{
		this.randomAccessFile.close();
	}
	
	public void save(Place place) throws IOException{
		this.randomAccessFile.writeInt(place.getCode());
		this.randomAccessFile.writeByte(place.getLevel());
		this.randomAccessFile.writeUTF(place.getName());//---> la longitud es el problema 
		this.randomAccessFile.writeUTF(place.getAbre()); // ---> igual
		this.randomAccessFile.writeInt(place.getParent().getCode()); // ----> puede haber duplicidad
	}
	
	public Place read(int code){
		return null;
	}
	
	public ArrayList<Place> search(String name){
		return null;
	}
}