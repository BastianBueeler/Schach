package logik.internal.chessmen;

public class Dame extends Spielfigur {

    public Dame(String name, String momentanePosition) {
        super(name, momentanePosition);
    }

    @Override
    public boolean spielzugUeberpruefen(String zielPosition, String spielzugType) {
        return false;
    }
}
