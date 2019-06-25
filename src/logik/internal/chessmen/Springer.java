package logik.internal.chessmen;

import logik.Spiel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dario Grob
 * @version 1.0
 */
public class Springer extends Spielfigur {

    /**
     * @param name - Der Name der Spielfigur
     * @param momentanePosition - Die momentane Position, welche die Figur hat
     * @param farbe - Die Farbe, welche die Figur hat (white, black)
     */
    public Springer(String name, String momentanePosition, String farbe) {
        super(name, momentanePosition, farbe);
    }

    /**
     * @param zielPosition - Position wo die Figur nach dem Zug soll sein
     * @param spielzugType - ob bei dem Zug eine Figur gefressen wird oder nicht
     * @param spiel - das Spiel, welches zentral liegt und alle figuren und Spieler kennt
     * @return boolean ob Zug erlaubt ist oder nicht
     */
    @Override
    public boolean spielzugUeberpruefen(String zielPosition, String spielzugType, Spiel spiel) {
        char momentanePositionX = momentanePosition.substring(0,1).charAt(0);
        int momentanePositionY = Integer.parseInt(momentanePosition.substring(1));
        List<StringBuffer> erlaubteZuege = new ArrayList<>();

        if(momentanePositionY -1 >= 1 ){
            if(momentanePositionX - 2 >= (char) 97){
                StringBuffer erlaubterZug = new StringBuffer();
                erlaubterZug.append((char) (momentanePositionX -2));
                erlaubterZug.append(momentanePositionY - 1);
                erlaubteZuege.add(erlaubterZug);
            }
            if(momentanePositionX + 2 <= (char) 104){
                StringBuffer erlaubterZug = new StringBuffer();
                erlaubterZug.append((char) (momentanePositionX +2));
                erlaubterZug.append(momentanePositionY - 1);
                erlaubteZuege.add(erlaubterZug);
            }
        }
        if(momentanePositionY -2 >= 1){
            if(momentanePositionX - 1 >= (char) 97){
                StringBuffer erlaubterZug = new StringBuffer();
                erlaubterZug.append((char) (momentanePositionX -1));
                erlaubterZug.append(momentanePositionY -2);
                erlaubteZuege.add(erlaubterZug);
            }
            if(momentanePositionX + 1 <= (char) 104){
                StringBuffer erlaubterZug = new StringBuffer();
                erlaubterZug.append((char) (momentanePositionX + 1));
                erlaubterZug.append(momentanePositionY -2);
                erlaubteZuege.add(erlaubterZug);
            }
        }

        if(momentanePositionY +1 <= 8 ){
            if(momentanePositionX - 2 >= (char) 97){
                StringBuffer erlaubterZug = new StringBuffer();
                erlaubterZug.append((char) (momentanePositionX -2));
                erlaubterZug.append(momentanePositionY + 1);
                erlaubteZuege.add(erlaubterZug);
            }
            if(momentanePositionX + 2 <= (char) 104){
                StringBuffer erlaubterZug = new StringBuffer();
                erlaubterZug.append((char) (momentanePositionX +2));
                erlaubterZug.append(momentanePositionY + 1);
                erlaubteZuege.add(erlaubterZug);
            }
        }
        if(momentanePositionY +2 <= 8){
            if(momentanePositionX - 1 >= (char) 97){
                StringBuffer erlaubterZug = new StringBuffer();
                erlaubterZug.append((char) (momentanePositionX -1));
                erlaubterZug.append(momentanePositionY +2);
                erlaubteZuege.add(erlaubterZug);
            }
            if(momentanePositionX + 1 <= (char) 104){
                StringBuffer erlaubterZug = new StringBuffer();
                erlaubterZug.append((char) (momentanePositionX + 1));
                erlaubterZug.append(momentanePositionY +2);
                erlaubteZuege.add(erlaubterZug);
            }
        }

        for(StringBuffer zug : erlaubteZuege){
            if(zielPosition.equals(zug.toString())){
                return true;
            }
        }

        return false;
    }
}
