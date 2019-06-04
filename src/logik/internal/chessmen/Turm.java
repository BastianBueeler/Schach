package logik.internal.chessmen;

import java.util.List;

public class Turm extends Spielfigur {

    public Turm(String name, String momentanePosition) {
        super(name, momentanePosition);
    }

    @Override
    public boolean spielzugUeberpruefen(String zielPosition, String spielzugType) {
        char momentanePositionX = momentanePosition.substring(0,1).charAt(0);
        int momentanePositionY = Integer.parseInt(momentanePosition.substring(1));
        List<StringBuffer> erlaubteZuege = null;
        StringBuffer erlaubterZug = new StringBuffer();

        int i = momentanePositionY + 1;
        while(i <= 8){
            erlaubterZug.append(momentanePositionX);
            erlaubterZug.append(i);
            erlaubteZuege.add(erlaubterZug);
            i++;
        }

        i = momentanePositionY -1;
        while(i > 0){
            erlaubterZug.append(momentanePositionX);
            erlaubterZug.append(i);
            erlaubteZuege.add(erlaubterZug);
            i--;
        }

        char j = (char) (momentanePositionX + 1);
        while(j <= (char) 104){
            erlaubterZug.append(j);
            erlaubterZug.append(momentanePositionY);
            erlaubteZuege.add(erlaubterZug);
            j++;
        }

        j = (char) (momentanePositionX -1);
        while(j > (char) 97){
            erlaubterZug.append(j);
            erlaubterZug.append(momentanePositionY);
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
