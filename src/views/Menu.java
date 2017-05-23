package views;

import javax.swing.Icon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar{
	
	private JMenu addMenu;
	private JMenu deleteMenu;
	private JMenu options;
	private JMenu aboutUs;
	private JMenuItem aboutMe;
	private JMenuItem deleteHotel;
	private JMenuItem deleteCity;
	private JMenuItem addHotel;
	private JMenuItem addCity;
	
	private static final String OPTIONS = "Options";
	private static final String ADD = "Add";
	private static final String DELETE = "Delete";
	private static final String ABOUT_US = "About";
	private static final String ABOUT_ME = "About us";
	private static final long serialVersionUID = 1L;

	public Menu() {
		this.deleteMenu = new JMenu(DELETE);
		this.addMenu = new JMenu(ADD);
		this.options = new JMenu(OPTIONS);
		this.aboutUs = new JMenu(ABOUT_US);
		this.aboutMe = new JMenuItem(ABOUT_ME);
		this.deleteHotel = new JMenuItem(ConstantUI.TEXT_DELETE_HOTEL);
		this.deleteCity = new JMenuItem(ConstantUI.TEXT_DELETE_CITY);
		this.addHotel = new JMenuItem(ConstantUI.TEXT_ADD_HOTEL);
		this.addCity = new JMenuItem(ConstantUI.TEXT_ADD_CITY);
		init();
	}

	private void init() {
		this.addMenu.add(addHotel);
		this.addMenu.add(addCity);
		this.options.add(addMenu);
		this.deleteMenu.add(deleteHotel);
		this.deleteMenu.add(deleteCity);
		this.options.add(this.deleteMenu);
		this.add(this.options);
		this.aboutUs.add(aboutMe);
		this.add(aboutUs);
	}
}