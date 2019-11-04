/**
 * View-Klasse
 * @author Felix Hadinger
 * @version 2019-10-31
 */

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class WortTrainerView extends JPanel{
	private JLabel zahl1;
	private JLabel zahl2;
	private JTextField jt = new JTextField("", 15);
	/**
	 * Erstellt ein BorderLayout wo das Textfeld, Bild und buttons angezeigt werden.
	 */
	public WortTrainerView() {
	this.setLayout(new BorderLayout());
	this.setBackground(Color.CYAN);
	
	JPanel jp1 = new JPanel(new GridLayout(2,1));//Zeilen,Spalten,Abstand x-achse,Abstand y-achse
	JLabel jl1 = new JLabel("Welches Wort wird unten dargestellt (Eingabe zum überprüfen)?", SwingConstants.CENTER);
	
	jt.setFont(new Font("SanSerif",Font.BOLD,25));
	jp1.add(jl1);
	jp1.add(jt);
	this.add(jp1,BorderLayout.PAGE_START);
	
	//Image
	ImageIcon icon = null;
	try {
		icon = new ImageIcon(new URL("https://www.pinclipart.com/picdir/middle/20-206356_wenn-hund-clipart.png"));
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Image image = icon.getImage(); // umwandeln in ein Image-Objekt
	image = image.getScaledInstance(250, 250,  Image.SCALE_SMOOTH); // skalieren auf gewünschte Größe
	JLabel jl3 = new JLabel(new ImageIcon(image)); // anzeigen in einem JLabel
	this.add(jl3,BorderLayout.CENTER);
	//
		
	JPanel jp2 = new JPanel(new GridLayout(3,3,20,5));//Zeilen,Spalten,Abstand x-achse,Abstand y-achse
	JLabel jl4 = new JLabel("Richtige Wörter:", SwingConstants.CENTER);
	JLabel zahl1 = new JLabel("0", SwingConstants.CENTER);
	JButton b1 = new JButton("Zurücksetzen");
	JLabel jl6 = new JLabel("Anzahl Wörter:", SwingConstants.CENTER);
	JLabel zahl2 = new JLabel("0", SwingConstants.CENTER);
	JButton b2 = new JButton("Wort hinzufügen");
	JButton b3 = new JButton("WortTrainer speichern");
	JButton b4 = new JButton("WortTrainer laden");

	jp2.add(jl4);
	jp2.add(zahl1);
	jp2.add(b1);
	jp2.add(jl6);
	jp2.add(zahl2);
	jp2.add(b2);
	jp2.add(b3);
	jp2.add(b4);
	this.add(jp2,BorderLayout.PAGE_END);
	}
	/**
	 * Gibt den Text zur�ck der eingegeben wurde
	 * @return Text des Textfelds
	 */
	public String getTextFeld() {
		return jt.getText();
	}
	/**
	 * �ndert die beiden Zahlen
	 * @param zahl1 Richtige W�rter
	 * @param zahl2 Anzahl W�rter
	 */
	public void setDatenRichtig(int zahl1,int zahl2) {
		this.zahl1.setText(""+zahl1);
		this.zahl2.setText(""+zahl2);
	}
	public void setDatenFalsch(int zahl1,int zahl2) {
		this.zahl1.setText(""+zahl1);
		this.zahl2.setText(""+zahl2);
	}
}
