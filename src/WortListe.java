import java.util.Arrays;

/**
 * Kann in einem String-array W�rter dazugeben und l�schen
 * @author Felix Hadinger
 * @version 2019-09-07
 */
public class WortListe extends Object{

	private WortEintrag[] liste;
	/*
	 * deklariert liste und zahl
	 */
	public WortListe(){
		liste =new WortEintrag[0];
	}
	public WortEintrag getEintrag(int index) {
		return liste[index];
	}
	public int getLength() {
		return liste.length;
	}

	/**
	 * Gibt eine neue Eintragung in die Liste
	 * @param wort Das Wort des Eintrags
	 * @param url Die URL des Eintrags
	 * @throws IllegalArgumentException
	 */
	public void addToList(String wort, String url) throws IllegalArgumentException{
		liste = Arrays.copyOf(liste, liste.length + 1);
		liste[liste.length - 1] = new WortEintrag(wort, url);
	}
	/**
	 * Gibt einen Text zur�ck
	 * @param index weilcher Text
	 * @return Text
	 * @throws IllegalArgumentException
	 */
	public String getText(int index) throws IllegalArgumentException{
		if(index - 1 > liste.length - 1 || index < 0)throw new IllegalArgumentException();
		return liste[index].getWort();
	}
	/**
	 * L�scht eine Eintragung in der Liste
	 * @param x text der gel�scht wird
	 * @return boolean obs funktioniert hat
	 * @throws IllegalArgumentException
	 */
	public boolean loeschWort(String x)throws IllegalArgumentException {
		boolean passt = false;
		if(x.length()<=1)throw new IllegalArgumentException();
		for(int a=0;a<=liste.length;a++) {
			passt=false;
				if(x.equals(liste[a].getWort())) break;
				else passt=true;
				
			if(passt == true) {
				int lol=0;
				WortEintrag[] beta=liste;
				liste =new WortEintrag[liste.length-1];
				for(int z=0;z<liste.length;z++) {
					if(z==a) {
						lol=1;
					}
					liste[z] = beta[z+lol];
				}
				return true;
			}
		}
	return false;
	}
	/**
	 * Gibt die gesamte Liste zur�ck
	 */
	@Override
	public String toString() {
		String x="";
		for(int b=0;b<liste.length;b++) {
			x += liste[b] + "\n";
		}
		return x;
	}
}
