package logik.internal.chessmen;

import logik.Spiel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dario Grob
 * @version 1.0
 */
public class Dame extends Spielfigur {

    /**
     * @param name - Der Name der Spielfigur
     * @param momentanePosition - Die momentane Position, welche die Figur hat
     * @param farbe - Die Farbe, welche die Figur hat (white, black)
     */
    public Dame(String name, String momentanePosition, String farbe) {
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
        if(zugKoenig(zielPosition) || zugLaeufer(zielPosition, spielzugType, spiel) || zugTurm(zielPosition, spielzugType, spiel)){
            return true;
        }
        return false;
    }

    /**
     * @param zielPosition - Position wo die Figur nach dem Zug soll sein
     * @return boolean ob Zug erlaubt ist oder nicht
     */
    public boolean zugKoenig(String zielPosition){
        char momentanePositionX = momentanePosition.substring(0,1).charAt(0);
        int momentanePositionY = Integer.parseInt(momentanePosition.substring(1));
        List<StringBuffer> erlaubteZuege = new ArrayList<>();
        StringBuffer erlaubterZug = null;
        List<Character> erlaubteXPosition = new ArrayList<>();
        List<Integer> erlaubteYPosition = new ArrayList<>();
        erlaubteXPosition.add(momentanePositionX);
        erlaubteYPosition.add(momentanePositionY);

        if(momentanePositionX == (char) 97) {
            erlaubteXPosition.add((char) (momentanePositionX + 1));
            erlaubterZug = new StringBuffer();
            erlaubterZug.append((char) (momentanePositionX + 1));
            erlaubterZug.append(momentanePositionY);
            erlaubteZuege.add(erlaubterZug);
        }else if (momentanePositionX == (char) 104){
            erlaubteXPosition.add((char)(momentanePositionX - 1));
            erlaubterZug = new StringBuffer();
            erlaubterZug.append((char) (momentanePositionX -1));
            erlaubterZug.append(momentanePositionY);
            erlaubteZuege.add(erlaubterZug);
        }else {
            erlaubteXPosition.add((char)(momentanePositionX + 1));
            erlaubterZug = new StringBuffer();
            erlaubterZug.append((char) (momentanePositionX + 1));
            erlaubterZug.append(momentanePositionY);
            erlaubteZuege.add(erlaubterZug);

            erlaubteXPosition.add((char)(momentanePositionX - 1));
            erlaubterZug = new StringBuffer();
            erlaubterZug.append((char) (momentanePositionX -1));
            erlaubterZug.append(momentanePositionY);
            erlaubteZuege.add(erlaubterZug);
        }

        if(momentanePositionY == 1) {
            erlaubteYPosition.add(momentanePositionY + 1);
            erlaubterZug = new StringBuffer();
            erlaubterZug.append(momentanePositionX);
            erlaubterZug.append(momentanePositionY + 1);
            erlaubteZuege.add(erlaubterZug);
        }else if(momentanePositionY == 8){
            erlaubteYPosition.add(momentanePositionY - 1);
            erlaubterZug = new StringBuffer();
            erlaubterZug.append(momentanePositionX);
            erlaubterZug.append(momentanePositionY - 1);
            erlaubteZuege.add(erlaubterZug);
        }else {
            erlaubteYPosition.add(momentanePositionY + 1);
            erlaubterZug = new StringBuffer();
            erlaubterZug.append(momentanePositionX);
            erlaubterZug.append(momentanePositionY + 1);
            erlaubteZuege.add(erlaubterZug);

            erlaubteYPosition.add(momentanePositionY - 1);
            erlaubterZug = new StringBuffer();
            erlaubterZug.append(momentanePositionX);
            erlaubterZug.append(momentanePositionY - 1);
            erlaubteZuege.add(erlaubterZug);
        }

        for(Character x : erlaubteXPosition){
            for(Integer y : erlaubteYPosition){
                erlaubterZug = new StringBuffer();
                erlaubterZug.append(x);
                erlaubterZug.append(y);
                erlaubteZuege.add(erlaubterZug);
            }
        }

        for(StringBuffer zug : erlaubteZuege){
            if(zielPosition.equals(zug.toString()) && ! zielPosition.equals(momentanePosition)){
                return true;
            }
        }

        return false;
    }

    /**
     * @param zielPosition - Position wo die Figur nach dem Zug soll sein
     * @return boolean ob Zug erlaubt ist oder nicht
     */
    public boolean zugLaeufer(String zielPosition, String spielzugType, Spiel spiel){
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

    /**
     * @param zielPosition - Position wo die Figur nach dem Zug soll sein
     * @return boolean ob Zug erlaubt ist oder nicht
     */
    public boolean zugTurm(String zielPosition, String spielzugType, Spiel spiel){
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
