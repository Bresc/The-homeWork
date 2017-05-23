package persitence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import model.dao.HotelGroup;
import model.entity.Hotel;

public class PersistenceSerializable implements Serializable{

	private static final long serialVersionUID = 1L;

	public static ArrayList<Hotel> readTheFile() throws IOException, ClassNotFoundException{
		ObjectInputStream obj = new ObjectInputStream(new FileInputStream("src/data/serializado.bra"));
		ArrayList<Hotel> list = (ArrayList<Hotel>)obj.readObject();
		System.out.println(list.toString());
		return  list;
	}
	
	public void writeThatFile(HotelGroup hotels) throws IOException{
		File file = new File("src/data/serializado.bra");
		FileOutputStream fi = new FileOutputStream(file);
		ObjectOutputStream h = new ObjectOutputStream(fi);
		h.writeObject(hotels.getTheArray());
		h.close();
	}
	
	public static void main(String[] args) {
		PersistenceSerializable s = new PersistenceSerializable();
		Hotel h = new Hotel("holi", "a", "asd", null, "123123", "asda", "ASDAD");
		Hotel h2 = new Hotel("holi", "a", "asd", null, "123123", "asda", "ASDAD");
		HotelGroup group = new HotelGroup();
		group.addHotel(h);
		group.addHotel(h2);
		try {
			s.writeThatFile(group);
			s.readTheFile();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}