package logik.internal.chessmen;

import java.util.ArrayList;
import java.util.List;

public class Laeufer extends Spielfigur{

    public Laeufer(String name, String momentanePosition, String farbe) {
        super(name, momentanePosition, farbe);
    }

    @Override
    public boolean spielzugUeberpruefen(String zielPosition, String spielzugType) {
        char momentanePositionX = momentanePosition.substring(0,1).charAt(0);
        int momentanePositionY = Integer.parseInt(momentanePosition.substring(1));
        List<StringBuffer> erlaubteZuege = new ArrayList<>();
        StringBuffer erlaubterZug = new StringBuffer();
        boolean weiter = true;
        int counter = 1;

        while(weiter){
            if(momentanePositionX == (char) 104 || momentanePositionY == 8){
                weiter = false;
                continue;
            }
            erlaubterZug.append(momentanePositionX + counter);
            erlaubterZug.append(momentanePositionY + counter);
            erlaubteZuege.add(erlaubterZug);
            erlaubterZug.delete(0, erlaubterZug.length());
            if(momentanePositionX + counter == (char) 104 || momentanePositionY + counter == 8){
                weiter = false;
            }
        }

        weiter = true;
        while(weiter){
            if(momentanePositionX == (char) 97 || momentanePositionY == 1){
                weiter = false;
                continue;
            }
            erlaubterZug.append(momentanePositionX - counter);
            erlaubterZug.append(momentanePositionY - counter);
            erlaubteZuege.add(erlaubterZug);
            erlaubterZug.delete(0, erlaubterZug.length());
            if(momentanePositionX - counter == (char) 97 || momentanePositionY - counter == 1){
                weiter = false;
            }
        }

        weiter = true;
        while(weiter){
            if(momentanePositionX == (char) 97 || momentanePositionY == 8){
                weiter = false;
                continue;
            }
            erlaubterZug.append(momentanePositionX - counter);
            erlaubterZug.append(momentanePositionY + counter);
            erlaubteZuege.add(erlaubterZug);
            erlaubterZug.delete(0, erlaubterZug.length());
            if(momentanePositionX - counter == (char) 97 || momentanePositionY + counter == 8){
                weiter = false;
            }
        }

        weiter = true;
        while(weiter){
            if(momentanePositionX == (char) 104 || momentanePositionY == 1){
                weiter = false;
                continue;
            }
            erlaubterZug.append(momentanePositionX + counter);
            erlaubterZug.append(momentanePositionY - counter);
            erlaubteZuege.add(erlaubterZug);
            erlaubterZug.delete(0, erlaubterZug.length());
            if(momentanePositionX + counter == (char) 104 || momentanePositionY - counter == 1){
                weiter = false;
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
