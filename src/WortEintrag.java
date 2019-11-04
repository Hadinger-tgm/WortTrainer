/**
 * �berpr�ft URL und Wort 
 * @author Felix Hadinger
 * @version 2019-09-07
 */
public class WortEintrag extends Object{
	private String wort,url;
	/**
	 * Gibt ein Wort und eine Url 
	 * @param w neues Wort
	 * @param u neue Url
	 * @throws IllegalArgumentException
	 */
	public WortEintrag(String w,String u)throws IllegalArgumentException{
		if(w.length() <= 1 || w.length() <= 1) throw new IllegalArgumentException();
			wort = w;
			url = u;
	}
	/**
	 * �berpr�ft, ob die Url richtig ist
	 * @return bool ob false/true
	 */
	public boolean checkURL() {
		String beta = "https://";
		String alpha = "http://";
		int zahl = 0;
		for(int z = 0;z < 7;z++) {
			if(url.charAt(z) != beta.charAt(z)) {
				if(url.charAt(z) == alpha.charAt(z)) {
					zahl = 1;
				}
				else return false;
			}
		}
		if(Character.isLetter(url.charAt(8-zahl)) == false) return false;
		return true;
	}
	/**
	 * �ndert Wort
	 * @param w das neue Wort
	 * @throws IllegalArgumentException
	 */
	public void setWort(String w) throws IllegalArgumentException{
		if(w.length()<=1) throw new IllegalArgumentException();
			wort=w;
	}
	/**
	 * Returnt wort
	 * @return wort
	 */
	public String getWort() {
		return wort;
	}
	/**
	 * �ndert url
	 * @param u neue url
	 * @throws IllegalArgumentException
	 */
	public void setUrl(String u) throws IllegalArgumentException{
		if(u.length()<=1)throw new IllegalArgumentException();
			url=u;
	}
	/**
	 * Returnt url
	 * @return url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * Gibt das Wort und die Url zur�ck
	 * @return Text
	 */
	@Override
	public String toString() {
		return wort + ";" + url;
	}
	//lol
}
