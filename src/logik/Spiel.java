package logik;

import logik.internal.Spieler;
import logik.internal.SpielerFactory;

public class Spiel{

    private Spieler spieler1;
    private Spieler spieler2;

    public void createSpieler(String name){
        SpielerFactory spielerFactory = SpielerFactory.getInstance();
        if(spieler1 == null){
            spieler1 = spielerFactory.createSpieler(name);
        }else{
            spieler2 = spielerFactory.createSpieler(name);
        }
    }
}