package persitence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

import model.entity.Place;

public class Persistence {

	//option que se llame hotel que guardar y todo eso
	//grabar lo de hotel
	//revisa en el git
	//subir esto en el git xD
	
	public void read(ArrayList<Place> places){
//		FileSite fileSite = new FileSite("src/data/nuevoBin.bin");
//		for (int i = 0; i < places.size(); i++) {
//			fileSite.open("rw");
//			fileSite.save(places.get(i), i);
//			fileSite.close();
//		}
	}
	
	public ArrayList<Place> readTheText() throws IOException{
		ArrayList<Place> help = new ArrayList<>();
		File file = new File("src/data/municipioscolombia.csv");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String line;
		String[] te;
		while ((line = bufferedReader.readLine())!= null) {
			te = line.split(",");
			try {
				Place place = new Place(Integer.parseInt(te[0].substring(2, 5)), (byte)0, te[1], null, new Place(Integer.parseInt(te[2]), (byte)0, te[3], null, null));
				help.add(place);
			} catch (Exception e) {
				System.out.println("nooo");
			}
		}
		return help;
	}
}