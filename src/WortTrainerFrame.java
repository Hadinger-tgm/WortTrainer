/**
 * Frame-Klasse
 * @author Felix Hadinger
 * @version 2019-09-24
 */

import javax.swing.*;

public class WortTrainerFrame extends JFrame{
	/**
	 * Erstellt die Standart-einstellungen und und benutzt View-klasse
	 * @param text der Titel der GUI
	 */
	public WortTrainerFrame(String text) {
		super(text);
		this.add(new WortTrainerView());
		this.setBounds(500,100,700,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
}
