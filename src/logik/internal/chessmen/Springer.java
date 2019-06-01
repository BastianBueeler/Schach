package logik.internal.chessmen;

public class Springer extends Spielfigur {

    public Springer(String name, String momentanePosition) {
        super(name, momentanePosition);
    }

    @Override
    public boolean spielzugUeberpruefen(String zielPosition, String spielzugType) {
        return false;
    }
}
