package logik.internal.chessmen;

public interface ISpielfigur {

    public String getName();

    public void setName(String name);

    public String getMomentanePosition();

    public void setMomentanePosition(String momentanePosition);

    public boolean iskorrekteFigur(String position);

    public void zugAusfuehren(String spielzug);

    public boolean spielzugUeberpruefen(String zielPosition, String spielzugType);

}
