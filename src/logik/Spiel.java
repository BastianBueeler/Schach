package logik;

import logik.internal.chessmen.ISpielfigur;
import logik.internal.chessmen.SpielfigurFactory;
import logik.internal.chessmen.SpielfigurType;
import logik.internal.player.Spieler;
import logik.internal.player.SpielerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dario Grob
 * @version 1.0
 */
public class Spiel{

    private Spieler spieler1;
    private Spieler spieler2;
    private Spieler aktuellerSpieler;
    private String[] bauerPositionenen1 = {"a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2"};
    private String[] bauerPositionenen2 = {"a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7"};
    private String[] springerPositionenen1 = {"b1", "g1"};
    private String[] springerPositionenen2 = {"b8", "g8"};
    private String[] laeuferPositionenen1 = {"c1", "f1"};
    private String[] laeuferPositionenen2 = {"c8", "f8"};
    private String[] turmPositionenen1 = {"a1", "h1"};
    private String[] turmPositionenen2 = {"a8", "h8"};
    private List<List<ISpielfigur>> spielfeld = new ArrayList<>();

    /**
     * @param name - Wird zum Namen des Spielers, welcher erstellt werden soll
     */
    public void createSpieler(String name){
        SpielerFactory spielerFactory = SpielerFactory.getInstance();
        if(spieler1 == null){
            spieler1 = spielerFactory.createSpieler(name);
            aktuellerSpieler = spieler1;
        }else{
            spieler2 = spielerFactory.createSpieler(name);
        }
    }

    public void createSpielfiguren(){
        SpielfigurFactory spielfigurFactory = SpielfigurFactory.getInstance();
        List<ISpielfigur> spielfiguren1 = new ArrayList<>();
        List<ISpielfigur> spielfiguren2 = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            spielfiguren1.add(spielfigurFactory.createSpielfiguren(SpielfigurType.Bauer, "Bauer", bauerPositionenen1[i], "white"));
            spielfiguren2.add(spielfigurFactory.createSpielfiguren(SpielfigurType.Bauer, "Bauer", bauerPositionenen2[i], "black"));
        }
        for(int i = 0; i < 2; i++){
            spielfiguren1.add(spielfigurFactory.createSpielfiguren(SpielfigurType.Springer, "Springer", springerPositionenen1[i], "white"));
            spielfiguren2.add(spielfigurFactory.createSpielfiguren(SpielfigurType.Springer, "Springer", springerPositionenen2[i], "black"));
        }
        for(int i = 0; i < 2; i++){
            spielfiguren1.add(spielfigurFactory.createSpielfiguren(SpielfigurType.Laeufer, "Läufer", laeuferPositionenen1[i], "white"));
            spielfiguren2.add(spielfigurFactory.createSpielfiguren(SpielfigurType.Laeufer, "Läufer", laeuferPositionenen2[i], "black"));
        }
        for(int i = 0; i < 2; i++){
            spielfiguren1.add(spielfigurFactory.createSpielfiguren(SpielfigurType.Turm, "Turm", turmPositionenen1[i], "white"));
            spielfiguren2.add(spielfigurFactory.createSpielfiguren(SpielfigurType.Turm, "Turm", turmPositionenen2[i], "black"));
        }
        spielfiguren1.add(spielfigurFactory.createSpielfiguren(SpielfigurType.Koenig, "König", "e1", "white"));
        spielfiguren2.add(spielfigurFactory.createSpielfiguren(SpielfigurType.Koenig, "König", "e8", "black"));

        spielfiguren1.add(spielfigurFactory.createSpielfiguren(SpielfigurType.Dame, "Dame", "d1", "white"));
        spielfiguren2.add(spielfigurFactory.createSpielfiguren(SpielfigurType.Dame, "Dame", "d8", "black"));

        spieler1.setSpielfiguren(spielfiguren1);
        spieler2.setSpielfiguren(spielfiguren2);

        figurenAufSpielfeldSetzen();
    }

    public void spielerWechsel(){
        if(aktuellerSpieler == spieler1){
            aktuellerSpieler = spieler2;
        }else{
            aktuellerSpieler = spieler1;
        }
    }

    public void figurenAufSpielfeldSetzen(){
        spielfeld.clear();
        List<ISpielfigur> zeile;
        StringBuffer position = new StringBuffer();
        for(int i = 0; i < 8; i++){
            zeile = new ArrayList<>();
            for(int j = 0; j < 8; j++){
                position.append((char) (j + 97));
                position.append((int)i + 1);
                ISpielfigur figur = positionVonSpieler1Besetzt(position.toString());
                if(figur == null){
                    figur = positionVonSpieler2Besetzt(position.toString());
                    zeile.add(figur);
                }else {
                    zeile.add(figur);
                }
                position.delete(0, position.length());
            }
            spielfeld.add(zeile);
        }
    }

    /**
     * @param position - überprüft ob an dieser Position eine Figur des Spielers 1 ist
     * @return ISpielfigur - gibt die Figur welcher an dieser Position ist zurück
     */
    public ISpielfigur positionVonSpieler1Besetzt(String position){
        for(ISpielfigur figur : spieler1.getSpielfiguren()){
            if(figur.iskorrekteFigur(position)){
                return figur;
            }
        }
        return null;
    }

    /**
     * @param position - überprüft ob an dieser Position eine Figur des Spielers 2 ist
     * @return ISpielfigur - gibt die Figur welcher an dieser Position ist zurück
     */
    public ISpielfigur positionVonSpieler2Besetzt(String position){
        for(ISpielfigur figur : spieler2.getSpielfiguren()){
            if(figur.iskorrekteFigur(position)){
                return figur;
            }
        }
        return null;
    }

    /**
     * @param zug - Der Zug welcher der Spieler eingegeben hat und ausgeführt werden soll
     * @return boolean - ob der Zug erfolgreich ausgeführt worden ist oder nicht
     */
    public boolean zugAusfuehren(String zug){
        String figurPosition = zug.substring(0, 2);
        String spielzugTyp = zug.substring(2, 3);
        String zielPosition = zug.substring(3, 5);

        if(spielzugTyp.equals("x")){
            if(aktuellerSpieler == spieler1) {
                if(positionVonSpieler2Besetzt(zielPosition) == null){
                    return false;
                }
            }else {
                if(positionVonSpieler1Besetzt(zielPosition) == null){
                    return false;
                }
            }

            for(ISpielfigur figur : aktuellerSpieler.getSpielfiguren()){
                if(figur.iskorrekteFigur(figurPosition)){
                    if(figur.spielzugUeberpruefen(zielPosition, spielzugTyp, this)){
                        figurFressen(zielPosition);
                        figur.zugAusfuehren(zielPosition);
                        return true;
                    }
                }
            }
            return false;

        }else {
            if(!(positionVonSpieler1Besetzt(zielPosition) == null )){
                return false;
            }
            if(!(positionVonSpieler2Besetzt(zielPosition) == null)){
                return false;
            }
            for(ISpielfigur figur : aktuellerSpieler.getSpielfiguren()){
                if(figur.iskorrekteFigur(figurPosition)){
                    if(figur.spielzugUeberpruefen(zielPosition, spielzugTyp, this)){
                        figur.zugAusfuehren(zielPosition);
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /**
     * @return List<List<ISpielfiguren>> - gibt das Spielfeld mit den Figuren zurück
     */
    public List<List<ISpielfigur>> getSpielfeld(){
        figurenAufSpielfeldSetzen();
        return spielfeld;
    }

    /**
     * @return boolean - ob der Spieler gewonnen hat
     */
    public boolean spielGewonnen(){
        if(aktuellerSpieler == spieler1){
            for(ISpielfigur figur : spieler2.getSpielfiguren()) {
                if (figur.getName().equals("König")) {
                    return false;
                }
            }
        }else {
            for(ISpielfigur figur : spieler1.getSpielfiguren()){
                if(figur.getName().equals("König")){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @param position - Die Figur an dieser Position wird gelöscht/gefressen
     */
    public void figurFressen(String position){
        ISpielfigur zuLoeschendeFigur= null;
        if(aktuellerSpieler == spieler1){
            for(ISpielfigur figur : spieler2.getSpielfiguren()){
                if(figur.iskorrekteFigur(position)){
                    zuLoeschendeFigur = figur;
                }
            }
            spieler2.figurFressen(zuLoeschendeFigur);
        }else {
            for(ISpielfigur figur : spieler1.getSpielfiguren()){
                if(figur.iskorrekteFigur(position)){
                    zuLoeschendeFigur = figur;
                }
            }
            spieler1.figurFressen(zuLoeschendeFigur);
        }
    }

    /**
     * @return Spieler - gibt den aktuellen Spieler zurück
     */
    public Spieler getAktuellerSpieler(){
        return aktuellerSpieler;
    }

    /**
     * @return Spieler - gibt Spieler 1 zurück
     */
    public Spieler getSpieler1(){
        return spieler1;
    }

    /**
     * @return Spieler - gibt Spieler 2 zurück
     */
    public Spieler getSpieler2(){
        return spieler2;
    }

    public boolean positionBesetzt(String position){
        if(positionVonSpieler1Besetzt(position) != null){
            return true;
        }

        if(positionVonSpieler2Besetzt(position) != null){
            return true;
        }

        return false;
    }
}