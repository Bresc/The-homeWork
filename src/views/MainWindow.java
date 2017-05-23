package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainWindow extends JFrame{

	private LabelStatus labelStatus;
	private ToolBar toolBar;
	private PanelNavegation panelNavegation;
	private PanelNavegation panelNavegationHotel;
	private DefaultTableModel defaultTableModel;
	private DefaultTableModel defaultTableModelHotel;
	private JTable tableCity;
	private JTable tableHotel;
	private JTabbedPane tabbedPane;
	private static final String ICON = "/img/1494725983_hotel.png";
	public static final String HOTEL = "Hotel";
	private static final String COLOR = "#B97068";
	private static final Object[] TABLE_HEADERS_PLACES = new Object[]{"Id", "Place"};
	private static final Object[] TABLE_HEADERS_HOTEL = new Object[]{"Id", "Hotel"};
	private static final long serialVersionUID = 1L;
	
	public MainWindow() {
		this.toolBar = new ToolBar();
		this.labelStatus = new LabelStatus();
		this.panelNavegation = new PanelNavegation();
		this.panelNavegationHotel = new PanelNavegation();
		init();
	}

	private void init() {
		this.setTitle(HOTEL);
		this.setLayout(new BorderLayout());
		this.getContentPane().setBackground(Color.decode(COLOR));
		this.setIconImage(new ImageIcon(getClass().getResource(ICON)).getImage());
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setJMenuBar(new Menu());
		this.tabbedPane = new JTabbedPane();
		JPanel panelToHotel = new JPanel();
		panelToHotel.setLayout(new BorderLayout());
		this.defaultTableModelHotel = new DefaultTableModel();
		this.defaultTableModelHotel.setColumnIdentifiers(TABLE_HEADERS_HOTEL);
		this.tableHotel = new JTable(){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){  
				return false;  
			}
		};
		this.tableHotel.setModel(defaultTableModelHotel);
		JScrollPane scrollHotel = new JScrollPane(tableHotel);
	
		panelToHotel.add(scrollHotel, BorderLayout.CENTER);
		panelToHotel.add(panelNavegationHotel, BorderLayout.SOUTH);
		this.tabbedPane.addTab("Hotels",panelToHotel);
		
		JPanel panelToContein = new JPanel();
		panelToContein.setLayout(new BorderLayout());
		this.add(toolBar, BorderLayout.NORTH);
		
		this.defaultTableModel = new DefaultTableModel();
		this.defaultTableModel.setColumnIdentifiers(TABLE_HEADERS_PLACES);
		this.tableCity = new JTable(){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){  
				return false;  
			}
		};
		this.tableCity.setModel(defaultTableModel);
		JScrollPane scrollCity = new JScrollPane(tableCity);
	
		panelToContein.add(scrollCity, BorderLayout.CENTER);
		panelToContein.add(panelNavegation, BorderLayout.SOUTH);
		this.tabbedPane.addTab("Place",panelToContein);
		
		
		this.add(tabbedPane, BorderLayout.CENTER);
		this.add(labelStatus, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	/**
	 *add a vector object to the table
	 * @param object
	 */
	public void addToTableCity(Object[] object){
		this.defaultTableModel.addRow(object);
	}
	/**
	 * 
	 * @param actualPage
	 * @param maxPage
	 */
	public void refreshPage(int actualPage, int maxPage){
		this.panelNavegation.refreshPage(actualPage, maxPage);			
	}
	
	public void forTheCity(){
		if (tabbedPane.getSelectedIndex() == 1) {
			
		}
	}
}