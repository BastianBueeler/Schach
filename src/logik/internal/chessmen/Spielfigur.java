package logik.internal.chessmen;

public abstract class Spielfigur implements ISpielfigur{

    protected String name;
    protected String momentanePosition;

    public Spielfigur(String name, String momentanePosition){
        setName(name);
        setMomentanePosition(momentanePosition);
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
