package persitence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import model.entity.Place;

public class FileSite {

	private File file;
	private RandomAccessFile randomAccessFile;

	public FileSite(String fileName) {
		this.file = new File(fileName);
	}

	public void open(String mode) {
		try {
			randomAccessFile = new RandomAccessFile(file, mode);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			randomAccessFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void save(Place place, int position) {
		DaoPlace daoPlace = new DaoPlace(place);
		try {
			randomAccessFile.seek(position*daoPlace.RECORD_SIZE);
			randomAccessFile.writeInt(daoPlace.getCode());
			randomAccessFile.writeByte(daoPlace.getType());
			//			randomAccessFile.writeChars(s);
			randomAccessFile.write(daoPlace.getName()); //--> tamaño determinado
			randomAccessFile.write(daoPlace.getAbreviate()); //--> tamaño determinado 
			randomAccessFile.writeLong(daoPlace.getCodeParent()); //-->duplicidad
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Place load(int position) {
		DaoPlace daoPlace = new DaoPlace();
		try {
			randomAccessFile.seek(position*daoPlace.RECORD_SIZE);
			daoPlace.setCode(randomAccessFile.readInt());
			daoPlace.setType(randomAccessFile.readByte());
			byte[] data = new byte[daoPlace.NAME_LENGTH];
			randomAccessFile.read(data);
			daoPlace.setName(data); //--> tamaño determinado
			data = new byte[daoPlace.ABREVIATE_LENGTH];
			randomAccessFile.read(data);
			daoPlace.setAbreviate(data); //--> tamaño determinado 
			daoPlace.setCodeParent(randomAccessFile.readLong()); //-->duplicidad
		} catch (IOException e) {
			System.out.println("Noooooooooo");
		}
		return daoPlace.binToPlace();
	}
	/**
	 * ordenar por burbuja
	 */
	public void sort(){
		this.open("rw");
		Place place1;
		Place place2;
		boolean isSort = false;
		while (!isSort) {
			isSort = true;
			for (int i = 0; i < this.file.length()/DaoPlace.RECORD_SIZE-1; i++) {
				//				for (int j = i+1; j < this.file.length()/DaoPlace.RECORD_SIZE; j++) {
				place1 = this.load(i);
				place2 = this.load(i+1);
				if (place1.getName().compareTo(place2.getName()) > 0) {
					this.save(place2, i);
					this.save(place1, i+1);
					isSort = false;
				}
				//				}

			}	
		}
		this.close();
	}

	//tarea --> cargar los municipios con los codigos reales, puede ser en formato de comas, de archivo texto a archivo binario
	// persistencia
	// - buscar por codigo por level ---> retorna un objeto place
	// -el proceso de migracion lo de pasar el csv a binario
	// interfaz grafica de usuario 
	// concerbar una copia por si acaso c:
	//no es para mañana, mañana no es la secion de clase
	/**
	 * metodo de Ordenamiento por shell
	 */
	public void sortShell(){
		this.open("rw");
		this.close();
	}
	
	public ArrayList<Place> search(String name) {
		return null;
	}
}