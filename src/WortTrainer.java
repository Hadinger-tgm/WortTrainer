import java.util.Random;

/**
 * Benutzt WortListe
 * @author Felix Hadinger
 * @version 2019-10-31
 */
public class WortTrainer {
	private WortListe wl;
	private int zahl;
	private int anzahl = 0;
	private int ranzahl = 0;
	/**
	 * 
	 * @param a Anzahl der Listen-elementen
	 * @param wl Wortliste
	 */
	public WortTrainer(int a,WortListe wl) {
		this.wl=wl;
		this.zahl = a-1;
	}
	/**
	 * Gibt ein ranfom Wort zur�ck
	 * @return wort
	 */
	public String randomWort() {
		Random r = new Random();
		int a = r.nextInt(wl.getLength());
		return wl.getText(a);
	}
	/**
	 * Gibt das aktuelle Wort zur�ck
	 * @return wort
	 */
	public String aktWort() {
		return wl.getText(zahl);
	}
	/**
	 * �berpr�ft param-text und aktuellen text
	 * @param x text
	 * @return false/true
	 */
	public boolean check(String x) {
		boolean b = x.equals(wl.getText(zahl));
		if(b) ranzahl++;
		anzahl++;
		return b;
	}

	/**
	 * �berpr�ft param-text und aktuellen text (ignoriert aber Gro�/klein-schreibung)
	 * @param x text
	 * @return true/false
	 */
	public boolean checkIgnoreCase(String x) {
		boolean b = x.equalsIgnoreCase(wl.getText(zahl));
		if(b) ranzahl++;
		anzahl++;
		return b;
	}
	public int getAnzahl(){
		return anzahl;
	}
	public void setAnzahl(int a){
		this.anzahl = a;
	}
	public int getRanzahl(){
		return ranzahl;
	}
	public void setRanzahl(int a){
		this.ranzahl = a;
	}
	public String toString() {
		return "Einträge: \n" + wl.toString() + "Richtige;" + ranzahl + "\nGesamte;" + anzahl;
	}
}
