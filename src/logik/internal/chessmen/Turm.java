package logik.internal.chessmen;

public class Turm extends Spielfigur {

    public Turm(String name, String momentanePosition) {
        super(name, momentanePosition);
    }

    @Override
    public boolean spielzugUeberpruefen(String zielPosition, String spielzugType) {
        return false;
    }
}
