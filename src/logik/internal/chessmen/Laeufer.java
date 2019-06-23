package logik.internal.chessmen;

import logik.Spiel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dario Grob
 * @version 1.0
 */
public class Laeufer extends Spielfigur{

    /**
     * @param name - Der Name der Spielfigur
     * @param momentanePosition - Die momentane Position, welche die Figur hat
     * @param farbe - Die Farbe, welche die Figur hat (white, black)
     */
    public Laeufer(String name, String momentanePosition, String farbe) {
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
        int counter = 1;

        while(true){
            if(momentanePositionX + counter > (char) 104 || momentanePositionY + counter > 8){
                break;
            }
            StringBuffer erlaubterZug = new StringBuffer();
            erlaubterZug.append((char) (momentanePositionX + counter));
            erlaubterZug.append(momentanePositionY + counter);
            if(spiel.positionBesetzt(erlaubterZug.toString())){
                if(spielzugType == "-"){
                    break;
                }else{
                    erlaubteZuege.add(erlaubterZug);
                    break;
                }
            }
            erlaubteZuege.add(erlaubterZug);
            counter++;
        }

        counter = 1;
        while(true){
            if(momentanePositionX - counter < (char) 97 || momentanePositionY - counter < 1){
                break;
            }
            StringBuffer erlaubterZug = new StringBuffer();
            erlaubterZug.append((char) (momentanePositionX - counter));
            erlaubterZug.append(momentanePositionY - counter);
            if(spiel.positionBesetzt(erlaubterZug.toString())){
                if(spielzugType == "-"){
                    break;
                }else{
                    erlaubteZuege.add(erlaubterZug);
                    break;
                }
            }
            erlaubteZuege.add(erlaubterZug);
            counter++;
        }

        counter = 1;
        while(true){
            if(momentanePositionX - counter < (char) 97 || momentanePositionY + counter > 8){
                break;
            }
            StringBuffer erlaubterZug = new StringBuffer();
            erlaubterZug.append((char) (momentanePositionX - counter));
            erlaubterZug.append(momentanePositionY + counter);
            if(spiel.positionBesetzt(erlaubterZug.toString())){
                if(spielzugType == "-"){
                    break;
                }else{
                    erlaubteZuege.add(erlaubterZug);
                    break;
                }
            }
            erlaubteZuege.add(erlaubterZug);
            counter++;
        }

        counter = 1;
        while(true){
            if(momentanePositionX + counter > (char) 104 || momentanePositionY - counter < 1){
                break;
            }
            StringBuffer erlaubterZug = new StringBuffer();
            erlaubterZug.append((char) (momentanePositionX + counter));
            erlaubterZug.append(momentanePositionY - counter);
            if(spiel.positionBesetzt(erlaubterZug.toString())){
                if(spielzugType == "-"){
                    break;
                }else{
                    erlaubteZuege.add(erlaubterZug);
                    break;
                }
            }
            erlaubteZuege.add(erlaubterZug);
            counter++;
        }

        for(StringBuffer zug : erlaubteZuege){
            if(zielPosition.equals(zug.toString())){
                return true;
            }
        }
        return false;
    }
}
