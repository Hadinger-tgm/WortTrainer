import javax.swing.*;
import java.io.*;

/**
 * Worttrainer speichern und laden mit einer txt-Datei
 * @author Felix Hadinger
 * @version 2019-10-31
 */
public class WortFile {
    WortListe wl;
    WortTrainer wt;

    /**
     * Alle nötigen Wort-Klassen in WortFile einfügen
     * @param wl WortListe
     * @param wt WortTrainer
     */
    public WortFile(WortListe wl, WortTrainer wt){
        this.wl = wl;
        this.wt = wt;
    }

    /**
     * Speichert die Einträge von WortTrainer anhand einer txt-Datei im angegebenen Pfad
     * @param pfad Der Pfad
     * @throws IOException Wenn beim auswählen des Pfades oder beim schreiben ein Fehler aufkommt
     */
    public void speichern(String pfad) throws IOException {
        try {
            File file = new File(pfad);
            FileWriter writer = new FileWriter(file);
            writer.write(wt.toString());
            writer.close();
        }
        catch(IOException io){
            JOptionPane.showMessageDialog(null,"Ein Fehler ist aufgetreten!");
        }
    }

    /**
     * Das selbe wie die Methode speichern nur mit einen fix angegebenen Pfad
     * @throws IOException Wenn beim auswählen des Pfades ein Fehler auftritt
     */
    public void defaultSpeichern() throws IOException {
        this.speichern("D://WortTrainer.txt");
    }

    /**
     * Ladet eine txt-Datei speichert sie als WortTrainer und gibt sie im Terminal aus
     * @param pfad Der PFad
     * @throws IOException Wenn beim auswählen des Pfades ein Fehler auftritt
     */
    public void laden(String pfad) throws IOException {
        wl = new WortListe();
        try {
            BufferedReader br = new BufferedReader(new FileReader(pfad));
            String text;
            int zahl = 0;
            while ((text = br.readLine()) != null) {
                System.out.println("\n" + text);
                        if(zahl > 0){
                    String [] eintrag = new String[2];
                    eintrag = text.split(";");
                    System.out.println("Split: " + eintrag[0] + " und " +eintrag[1]);
                    if(eintrag[0].equals("Richtige") == true) { //Wenn Richtige Anzahl kommt
                        int an = Integer.parseInt(eintrag[1]);
                        wt.setRanzahl(an);
                    }
                    else{
                        if(eintrag[0].equals("Gesamte") == true){ //Wenn Gesamte Anzahl kommt
                            int an = Integer.parseInt(eintrag[1]);
                            wt.setAnzahl(an);
                        }
                            else {                                  //Wenn es Einträge sind
                            wl.addToList(eintrag[0],eintrag[1]);
                        }
                    }

                }
                zahl++;
            }
        }
        catch(IOException io){
            JOptionPane.showMessageDialog(null,"Ein Fehler ist aufgetreten!");
        }
    }

    /**
     * Das selbe wie die Methode laden nur mit einen fix angegebenen Pfad
     * @throws IOException Wenn beim auswählen des Pfades ein Fehler auftritt
     */
    public void defaultLaden() throws IOException {
        this.laden("D://WortTrainer.txt");
    }
    public String toString(){
        return wt.toString();
    }
}
