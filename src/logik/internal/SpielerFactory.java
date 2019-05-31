package logik.internal;

public class SpielerFactory {

    private static SpielerFactory spielerFactory = new SpielerFactory();

    private SpielerFactory(){

    }

    public static SpielerFactory getInstance(){
        return spielerFactory;
    }

    public Spieler createSpieler(String name){
        return new Spieler(name);
    }
}