package logik.internal.chessmen;

import java.util.List;

public class Bauer extends Spielfigur {

    public Bauer(String name, String startPosition) {
        super(name, startPosition);
    }


    @Override
    public boolean spielzugUeberpruefen(String zielPosition, String spielzugType) {
        return false;
    }
}
