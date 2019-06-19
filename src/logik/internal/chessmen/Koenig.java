package logik.internal.chessmen;

import java.util.List;

public class Koenig extends Spielfigur{

    public Koenig(String name, String momentanePosition, String farbe) {
        super(name, momentanePosition, farbe);
    }

    @Override
    public boolean spielzugUeberpruefen(String zielPosition, String spielzugType) {
        char momentanePositionX = momentanePosition.substring(0,1).charAt(0);
        int momentanePositionY = Integer.parseInt(momentanePosition.substring(1));
        List<StringBuffer> erlaubteZuege = null;
        List<Character> erlaubteXPosition = null;
        List<Integer> erlaubteYPosition = null;
        erlaubteXPosition.add(momentanePositionX);
        erlaubteYPosition.add(momentanePositionY);

        if(momentanePositionX == (char) 97) {
            erlaubteXPosition.add((char) (momentanePositionX + 1));
        }else if (momentanePositionX == (char) 104){
            erlaubteXPosition.add((char)(momentanePositionX - 1));
        }else {
            erlaubteXPosition.add((char)(momentanePositionX + 1));
            erlaubteXPosition.add((char)(momentanePositionX - 1));
        }

        if(momentanePositionY == 1) {
            erlaubteYPosition.add(momentanePositionY + 1);
        }else if(momentanePositionY == 8){
            erlaubteYPosition.add(momentanePositionY - 1);
        }else {
            erlaubteYPosition.add(momentanePositionY + 1);
            erlaubteYPosition.add(momentanePositionY - 1);
        }

        for(Character x : erlaubteXPosition){
            for(Integer y : erlaubteYPosition){
                StringBuffer erlaubterZug = new StringBuffer();
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
