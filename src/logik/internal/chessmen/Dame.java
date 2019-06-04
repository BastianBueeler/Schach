package logik.internal.chessmen;

import java.util.ArrayList;
import java.util.List;

public class Dame extends Spielfigur {

    public Dame(String name, String momentanePosition) {
        super(name, momentanePosition);
    }

    @Override
    public boolean spielzugUeberpruefen(String zielPosition, String spielzugType) {
        if(zugKoenig(zielPosition) || zugLaeufer(zielPosition) || zugSpringer(zielPosition) || zugTurm(zielPosition)){
            return true;
        }
        return false;
    }

    public boolean zugKoenig(String zielPosition){
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

    public boolean zugLaeufer(String zielPosition){
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

    public boolean zugSpringer(String zielPosition){
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

    public boolean zugTurm(String zielPosition){
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
