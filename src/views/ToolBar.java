package views;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar{

	/**
	 * 
	 */
	private JButton buttonAdd;
	private JButton buttonDelte;
	private JButton buttonSearch;
	private JTextField textToSearch;
	private static final String IMAGE_ADD = "/img/1494736790_icons_add.png";
	private static final String IMAGE_DELETE = "/img/1476952496_delete.png";
	private static final String IMAGE_SEARCH = "/img/1476952520_search.png";
	private static final long serialVersionUID = 1L;

	public ToolBar() {
		this.buttonAdd = new JButton(new ImageIcon(new ImageIcon(getClass().getResource(IMAGE_ADD)).getImage().getScaledInstance(25, 25, 0)));
		this.buttonDelte = new JButton(new ImageIcon(new ImageIcon(getClass().getResource(IMAGE_DELETE)).getImage().getScaledInstance(25, 25, 0)));
		this.buttonSearch = new JButton(new ImageIcon(new ImageIcon(getClass().getResource(IMAGE_SEARCH)).getImage().getScaledInstance(25, 25, 0)));
		this.textToSearch = new JTextField();
		init();
	}

	private void init() {
		this.setFloatable(false);
		this.buttonAdd.setToolTipText(ConstantUI.TEXT_ADD_HOTEL);
		this.add(buttonAdd);
		this.buttonDelte.setToolTipText(ConstantUI.TEXT_DELETE_HOTEL);
		this.add(buttonDelte);
		this.add(Box.createRigidArea(new Dimension(1000, 0)));
		this.textToSearch.setToolTipText(ConstantUI.TEXT_TEXT_SEARCH);
		this.add(textToSearch);
		this.buttonSearch.setToolTipText(ConstantUI.TEXT_SEARCH);
		this.add(buttonSearch);
	}
}