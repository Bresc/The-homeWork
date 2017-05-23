package views;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelNavegation extends JPanel{
	
	private JButton buttonNext;
	private JButton buttonBack;
	private JLabel labelPosition;
	private static final String NEXT_IMAGE = "/img/arrow_one.png";
	private static final String BACK_IMAGE = "/img/arrow_two.png";
	private static final String START_LABEL = "page:";
	private static final long serialVersionUID = 1L;
	
	public PanelNavegation() {
		this.buttonBack = new JButton(new ImageIcon(new ImageIcon(getClass().getResource(BACK_IMAGE)).getImage().getScaledInstance(25, 25, 10)));
		this.buttonNext = new JButton(new ImageIcon(new ImageIcon(getClass().getResource(NEXT_IMAGE)).getImage().getScaledInstance(25, 25, 10)));
		this.labelPosition = new JLabel(START_LABEL);
		init();
	}

	private void init() {
		this.setLayout(new BorderLayout());
		this.add(buttonBack, BorderLayout.WEST);
		this.add(labelPosition, BorderLayout.CENTER);
		this.add(buttonNext, BorderLayout.EAST);
	}

	public void refreshPage(int actualPage, int maxPage) {
		this.labelPosition.setText(START_LABEL+actualPage +"/"+maxPage);
	}
}