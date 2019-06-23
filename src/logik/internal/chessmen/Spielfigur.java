package logik.internal.chessmen;

/**
 * @author Dario Grob
 * @version 1.0
 */
public abstract class Spielfigur implements ISpielfigur{

    protected String name;
    protected String momentanePosition;
    protected String farbe;

    /**
     * @param name - Der Name der Spielfigur
     * @param momentanePosition - Die momentane Position, welche die Figur hat
     * @param farbe - Die Farbe, welche die Figur hat (white, black)
     */
    public Spielfigur(String name, String momentanePosition, String farbe){
        setName(name);
        setMomentanePosition(momentanePosition);
        setFarbe(farbe);
    }

    /**
     * @return String - gibt die Farbe der Figur zurück
     */
    @Override
    public String getFarbe(){
        return farbe;
    }

    /**
     * @param farbe - wird zur Farbe der Figur
     */
    @Override
    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    /**
     * @return String - gibt den Namen der Figur zurück
     */
    @Override
    public String getName(){
        return name;
    }

    /**
     * @param name - wird zum Namen der Figur
     */
    @Override
    public void setName(String name){
        this.name = name;
    }

    /**
     * @return String - gibt die momentane Position der Figur zurück
     */
    @Override
    public String getMomentanePosition(){
        return momentanePosition;
    }

    /**
     * @param momentanePosition - wird zur momentaner Position der Figur
     */
    @Override
    public void setMomentanePosition(String momentanePosition){
        this.momentanePosition = momentanePosition;
    }

    /**
     * @param position - wird zur momentaner Position der Figur
     */
    @Override
    public void zugAusfuehren(String position) {
        setMomentanePosition(position);
    }

    /**
     * @param position - Position an der überprüft wird, ob sich die Figur befindet
     * @return boolean - ob die Figur an der Position ist oder nicht
     */
    @Override
    public boolean iskorrekteFigur(String position) {
        if(position.equals(momentanePosition)){
            return true;
        }else{
            return false;
        }
    }
}
