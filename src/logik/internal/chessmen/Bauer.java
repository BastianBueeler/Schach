package logik.internal.chessmen;

import logik.Spiel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dario Grob
 * @version 1.0
 */

public class Bauer extends Spielfigur {
    /**
     * @param name - Der Name der Spielfigur
     * @param startPosition - Die momentane Position der Spielfigur
     * @param farbe - Die Farbe der Spielfigur (white, black)
     */
    public Bauer(String name, String startPosition, String farbe) {
        super(name, startPosition, farbe);
    }

    /**
     * @param zielPosition - Position wo die Figur nach dem Zug soll sein
     * @param spielzugType - ob bei dem Zug eine Figur gefressen wird oder nicht
     * @param spiel
     * @return boolean ob Zug erlaubt ist oder nicht
     */
    @Override
    public boolean spielzugUeberpruefen(String zielPosition, String spielzugType, Spiel spiel) {
        String zielPositionX = zielPosition.substring(0,1);
        int zielPositionY = Integer.parseInt(zielPosition.substring(1));
        String momentanePositionX = momentanePosition.substring(0,1);
        int momentanePositionY = Integer.parseInt(momentanePosition.substring(1));

        if(spielzugType.equals("x")){
            return spielzugUeperpruefenFressen(zielPosition);
        }

        if(!zielPositionX.equals(momentanePositionX)){
            return false;
        }

        if(this.getFarbe().equals("white")){
            if(momentanePositionY == 2){
                if(zielPositionY == momentanePositionY+2){
                    return true;
                }
                if(zielPositionY == momentanePositionY+1){
                    return true;
                }
            }else {
                if(zielPositionY == momentanePositionY+1){
                    return true;
                }
            }
        }else {
            if(momentanePositionY == 7){
                if(zielPositionY == momentanePositionY-2){
                    return true;
                }
                if(zielPositionY == momentanePositionY-1){
                    return true;
                }
            }else {
                if(zielPositionY == momentanePositionY-1){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param zielPosition - Position wo die Figur nach dem Zug soll sein
     * @return boolean ob Zug erlaubt ist oder nicht
     */
    public boolean spielzugUeperpruefenFressen(String zielPosition){
        char momentanePositionX = momentanePosition.substring(0,1).charAt(0);
        int momentanePositionY = Integer.parseInt(momentanePosition.substring(1));
        List<StringBuffer> erlaubteZuege = new ArrayList<>();

        if(this.getFarbe().equals("white")){
            if(momentanePositionX + 1 <= (char) 104 && momentanePositionY + 1 <= 8){
                StringBuffer erlaubterZug = new StringBuffer();
                erlaubterZug.append((char) (momentanePositionX +1));
                erlaubterZug.append(momentanePositionY + 1);
                erlaubteZuege.add(erlaubterZug);
            }

            if(momentanePositionX - 1 >= (char) 97 && momentanePositionY + 1 <= 8){
                StringBuffer erlaubterZug = new StringBuffer();
                erlaubterZug.append((char) (momentanePositionX -1));
                erlaubterZug.append(momentanePositionY + 1);
                erlaubteZuege.add(erlaubterZug);
            }
        }else {
            if(momentanePositionX + 1 <= (char) 104 && momentanePositionY - 1 >= 1){
                StringBuffer erlaubterZug = new StringBuffer();
                erlaubterZug.append((char) (momentanePositionX +1));
                erlaubterZug.append(momentanePositionY - 1);
                erlaubteZuege.add(erlaubterZug);
            }

            if(momentanePositionX - 1 >= (char) 97 && momentanePositionY - 1 >= 1){
                StringBuffer erlaubterZug = new StringBuffer();
                erlaubterZug.append((char) (momentanePositionX -1));
                erlaubterZug.append(momentanePositionY - 1);
                erlaubteZuege.add(erlaubterZug);
            }
        }

        for(StringBuffer zug : erlaubteZuege){
            if(zug.toString().equals(zielPosition)){
                return true;
            }
        }
        return false;
    }
}
