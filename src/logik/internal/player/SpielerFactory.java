package logik.internal.player;

public class SpielerFactory {

    private static SpielerFactory spielerFactory = new SpielerFactory();

    private SpielerFactory(){

    }

    /**
     * @return SpielerFactory - Gibt die Instanz auf diese Klasse zurück
     */
    public static SpielerFactory getInstance(){
        return spielerFactory;
    }

    /**
     * @param name - Wird zum Namen des Spielers
     * @return Spieler - gibt den erstellten Spieler zurück
     */
    public Spieler createSpieler(String name){
        return new Spieler(name);
    }
}