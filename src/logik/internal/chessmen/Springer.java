package logik.internal.chessmen;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.List;

public class Springer extends Spielfigur {

    public Springer(String name, String momentanePosition) {
        super(name, momentanePosition);
    }

    @Override
    public boolean spielzugUeberpruefen(String zielPosition, String spielzugType) {
        char momentanePositionX = momentanePosition.substring(0,1).charAt(0);
        int momentanePositionY = Integer.parseInt(momentanePosition.substring(1));
        List<StringBuffer> erlaubteZuege = new ArrayList<>();
        StringBuffer erlaubterZug = new StringBuffer();

        if(momentanePositionY -1 >= 1 ){
            if(momentanePositionX - 2 >= (char) 97){
                erlaubterZug.append(momentanePositionX -2);
                erlaubterZug.append(momentanePositionY - 1);
                erlaubteZuege.add(erlaubterZug);
                erlaubterZug.delete(0, erlaubterZug.length());
            }
            if(momentanePositionX + 2 <= (char) 104){
                erlaubterZug.append(momentanePositionX +2);
                erlaubterZug.append(momentanePositionY - 1);
                erlaubteZuege.add(erlaubterZug);
                erlaubterZug.delete(0, erlaubterZug.length());
            }
        }
        if(momentanePositionY -2 >= 1){
            if(momentanePositionX - 1 >= (char) 97){
                erlaubterZug.append(momentanePositionX -1);
                erlaubterZug.append(momentanePositionY -2);
                erlaubteZuege.add(erlaubterZug);
                erlaubterZug.delete(0, erlaubterZug.length());
            }
            if(momentanePositionX + 1 <= (char) 104){
                erlaubterZug.append(momentanePositionX + 1);
                erlaubterZug.append(momentanePositionY -2);
                erlaubteZuege.add(erlaubterZug);
                erlaubterZug.delete(0, erlaubterZug.length());
            }
        }

        if(momentanePositionY +1 >= 8 ){
            if(momentanePositionX - 2 >= (char) 97){
                erlaubterZug.append(momentanePositionX -2);
                erlaubterZug.append(momentanePositionY + 1);
                erlaubteZuege.add(erlaubterZug);
                erlaubterZug.delete(0, erlaubterZug.length());
            }
            if(momentanePositionX + 2 <= (char) 104){
                erlaubterZug.append(momentanePositionX +2);
                erlaubterZug.append(momentanePositionY + 1);
                erlaubteZuege.add(erlaubterZug);
                erlaubterZug.delete(0, erlaubterZug.length());
            }
        }
        if(momentanePositionY +2 >= 1){
            if(momentanePositionX - 1 >= (char) 97){
                erlaubterZug.append(momentanePositionX -1);
                erlaubterZug.append(momentanePositionY +2);
                erlaubteZuege.add(erlaubterZug);
                erlaubterZug.delete(0, erlaubterZug.length());
            }
            if(momentanePositionX + 1 <= (char) 104){
                erlaubterZug.append(momentanePositionX + 1);
                erlaubterZug.append(momentanePositionY +2);
                erlaubteZuege.add(erlaubterZug);
                erlaubterZug.delete(0, erlaubterZug.length());
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
