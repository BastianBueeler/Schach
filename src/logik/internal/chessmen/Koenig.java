package logik.internal.chessmen;

import logik.Spiel;

import java.util.ArrayList;
import java.util.List;

public class Koenig extends Spielfigur{

    /**
     * @param name - Der Name der Spielfigur
     * @param momentanePosition - Die momentane Position, welche die Figur hat
     * @param farbe - Die Farbe, welche die Figur hat (white, black)
     */
    public Koenig(String name, String momentanePosition, String farbe) {
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
}
