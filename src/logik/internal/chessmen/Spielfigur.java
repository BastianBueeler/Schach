package logik.internal.chessmen;

public abstract class Spielfigur implements ISpielfigur{

    protected String name;
    protected String momentanePosition;
    protected String farbe;

    public Spielfigur(String name, String momentanePosition, String farbe){
        setName(name);
        setMomentanePosition(momentanePosition);
        setFarbe(farbe);
    }

    @Override
    public String getFarbe(){
        return farbe;
    }

    @Override
    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String getMomentanePosition(){
        return momentanePosition;
    }

    @Override
    public void setMomentanePosition(String momentanePosition){
        this.momentanePosition = momentanePosition;
    }

    @Override
    public void zugAusfuehren(String position) {
        setMomentanePosition(position);
    }

    @Override
    public boolean iskorrekteFigur(String position) {
        if(position.equals(momentanePosition)){
            return true;
        }else{
            return false;
        }
    }
}
