package logik.internal.chessmen;

import java.util.List;

public class Bauer extends Spielfigur {

    public Bauer(String name, String startPosition) {
        super(name, startPosition);
    }


    @Override
    public boolean spielzugUeberpruefen(String zielPosition, String spielzugType) {
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

        if(!(zielPositionY == momentanePositionY+1)){
            return false;
        }
        return true;
    }

    public boolean spielzugUeperpruefenFressen(String zielPosition){
        char momentanePositionX = momentanePosition.substring(0,1).charAt(0);
        int momentanePositionY = Integer.parseInt(momentanePosition.substring(1));
        List<Character> erlaubteXPositionen = null;

        if(momentanePositionX == (char) 97){
            erlaubteXPositionen.add((char)(((int) momentanePositionX) +1));
        }else if (momentanePositionX == (char) 104){
            erlaubteXPositionen.add((char)(((int) momentanePositionX) -1));
        }else{
            erlaubteXPositionen.add((char)(((int) momentanePositionX) +1));
            erlaubteXPositionen.add((char)(((int) momentanePositionX) -1));
        }

        for(Character x : erlaubteXPositionen){
            StringBuffer erlaubterZug = new StringBuffer();
            erlaubterZug.append(x);
            erlaubterZug.append(momentanePositionY + 1);
            if(zielPosition.equals(erlaubterZug.toString()));{
                return true;
            }
        }
        return false;
    }
}
