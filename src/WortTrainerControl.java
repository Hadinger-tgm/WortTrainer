import java.io.IOException;

/**
 * Main-Klasse
 * @author Felix Hadinger
 * @version 2019-10-31
 */
public class WortTrainerControl {
	/**
	 * Diese Klasse ist die Main-Methode und benutzt das Frame
	 */
	private WortTrainerView wtv;
	private WortTrainer wt;
	public static void main(String[] args) throws IOException {
		new WortTrainerFrame("Wort-Trainer");
		///////////////////////////
		WortEintrag we = new WortEintrag("le","https://a.lsd");
		System.out.println("checkURL: "+we.checkURL());
		we.setWort("gg");
		System.out.println("getWort: "+we.getWort());
		we.setUrl("http://l.el");
		System.out.println("getURL: "+we.getUrl());
		System.out.println("toString: "+we.toString());
		//////////////////////
		WortListe wl = new WortListe();
		wl.addToList("lel","https://a.lsd");
		wl.addToList("gg","http://l.el");
		wl.addToList("jee","http://a.so");
		System.out.println("giveText: " + wl.getText(2));
		System.out.println("l�scht: " + wl.loeschWort("lel;https://a.lsd"));
		System.out.println("getZahl: "+wl.getLength());
		System.out.println("toString: \n"+wl.toString());
		///////////////////////
		WortTrainer wt = new WortTrainer(wl.getLength(),wl);
		System.out.println("random: "+wt.randomWort());
		System.out.println("aktuell: "+wt.aktWort());
		System.out.println("check: "+wt.check("jeeeee"));//Falsche
		System.out.println("checkIgnoreCase: "+wt.checkIgnoreCase("JeE"));//Richtige
		System.out.println("Gesamt: " + wt.getAnzahl());
		System.out.println("Richtige: " + wt.getRanzahl());
		////////////////////
		WortFile wf = new WortFile(wl,wt);
		wf.speichern("D://testFile1.txt");
		//wf.defaultSpeichern();
		wf.laden("D://testFile1.txt");
		//wf.defaultLaden();
		System.out.println("WortTrainer: " + wf.toString());
	}
}
