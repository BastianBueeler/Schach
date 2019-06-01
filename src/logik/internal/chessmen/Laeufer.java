package logik.internal.chessmen;

public class Laeufer extends Spielfigur{

    public Laeufer(String name, String momentanePosition) {
        super(name, momentanePosition);
    }

    @Override
    public boolean spielzugUeberpruefen(String zielPosition, String spielzugType) {
        return false;
    }
}
