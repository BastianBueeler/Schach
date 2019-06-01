package logik.internal.chessmen;

public class Koenig extends Spielfigur{

    public Koenig(String name, String momentanePosition) {
        super(name, momentanePosition);
    }

    @Override
    public boolean spielzugUeberpruefen(String zielPosition, String spielzugType) {
        return false;
    }
}
