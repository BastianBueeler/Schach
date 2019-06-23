package logik.internal.chessmen;

import logik.Spiel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dario Grob
 * @version 1.0
 */
public class Turm extends Spielfigur {

    /**
     * @param name - Der Name der Spielfigur
     * @param momentanePosition - Die momentane Position, welche die Figur hat
     * @param farbe - Die Farbe, welche die Figur hat (white, black)
     */
    public Turm(String name, String momentanePosition, String farbe) {
        super(name, momentanePosition, farbe);
    }

    /**
     * @param zielPosition - Position wo die Figur nach dem Zug soll sein
     * @param spielzugType - ob bei dem Zug eine Figur gefressen wird oder nicht
     * @param spiel
     * @return boolean ob Zug erlaubt ist oder nicht
     */
    @Override
    public boolean spielzugUeberpruefen(String zielPosition, String spielzugType, Spiel spiel) {
        char momentanePositionX = momentanePosition.substring(0,1).charAt(0);
        int momentanePositionY = Integer.parseInt(momentanePosition.substring(1));
        List<StringBuffer> erlaubteZuege = new ArrayList<>();
        StringBuffer erlaubterZug;

        int i = momentanePositionY + 1;
        while(i <= 8){
            erlaubterZug = new StringBuffer();
            erlaubterZug.append((char) (momentanePositionX));
            erlaubterZug.append(i);
            if(spiel.positionBesetzt(erlaubterZug.toString())){
                if(spielzugType == "-"){
                    break;
                }else{
                    erlaubteZuege.add(erlaubterZug);
                    break;
                }
            }
            erlaubteZuege.add(erlaubterZug);
            i++;
        }

        i = momentanePositionY -1;
        while(i > 0){
            erlaubterZug = new StringBuffer();
            erlaubterZug.append((char) (momentanePositionX));
            erlaubterZug.append(i);
            if(spiel.positionBesetzt(erlaubterZug.toString())){
                if(spielzugType == "-"){
                    break;
                }else{
                    erlaubteZuege.add(erlaubterZug);
                    break;
                }
            }
            erlaubteZuege.add(erlaubterZug);
            i--;
        }

        char j = (char) (momentanePositionX + 1);
        while(j <= (char) 104){
            erlaubterZug = new StringBuffer();
            erlaubterZug.append((char) (j));
            erlaubterZug.append(momentanePositionY);
            if(spiel.positionBesetzt(erlaubterZug.toString())){
                if(spielzugType == "-"){
                    break;
                }else{
                    erlaubteZuege.add(erlaubterZug);
                    break;
                }
            }
            erlaubteZuege.add(erlaubterZug);
            j++;
        }

        j = (char) (momentanePositionX -1);
        while(j >= (char) 97){
            erlaubterZug = new StringBuffer();
            erlaubterZug.append((char) (j));
            erlaubterZug.append(momentanePositionY);
            if(spiel.positionBesetzt(erlaubterZug.toString())){
                if(spielzugType == "-"){
                    break;
                }else{
                    erlaubteZuege.add(erlaubterZug);
                    break;
                }
            }
            erlaubteZuege.add(erlaubterZug);
            j--;
        }

        for(StringBuffer zug : erlaubteZuege){
            if(zielPosition.equals(zug.toString())){
                return true;
            }
        }
            return false;
    }
}
