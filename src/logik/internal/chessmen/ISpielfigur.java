package logik.internal.chessmen;

import logik.Spiel;

/**
 * @author Dario Grob
 * @version 1.0
 */
public interface ISpielfigur {

    public String getName();

    public void setName(String name);

    public String getMomentanePosition();

    public void setMomentanePosition(String momentanePosition);

    public boolean iskorrekteFigur(String position);

    public void zugAusfuehren(String spielzug);

    public boolean spielzugUeberpruefen(String zielPosition, String spielzugType, Spiel spiel);

    public String getFarbe();

    public void setFarbe(String farbe);
}