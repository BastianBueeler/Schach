package logik.internal.chessmen;

/**
 * @author Dario Grob
 * @version 1.0
 */
public class SpielfigurFactory {

    private static SpielfigurFactory spielfigurFactory = new SpielfigurFactory();

    /**
     * @return SpielfigurFactoriy - Gibt die Instanz dieser Klasse zurück
     */
    public static SpielfigurFactory getInstance() {
        return spielfigurFactory;
    }

    private SpielfigurFactory() {
    }

    /**
     * @param spielfigurType - Der Figurentyp welcher erstellt werden soll
     * @param name - Der Name der Figur
     * @param startPosition - Position an der sich die Figur beim starten des Spiels befindet
     * @param farbe - Farbe der Figur
     * @return ISpielfigur - Die erstelle Figur
     */
    public ISpielfigur createSpielfiguren(SpielfigurType spielfigurType, String name, String startPosition, String farbe){
        if(spielfigurType == SpielfigurType.Bauer) {
            return new Bauer(name, startPosition, farbe);
        }else if(spielfigurType == SpielfigurType.Springer){
            return new Springer(name, startPosition, farbe);
        }else if(spielfigurType == SpielfigurType.Laeufer){
            return new Laeufer(name, startPosition, farbe);
        }else if(spielfigurType == SpielfigurType.Turm){
            return new Turm(name, startPosition, farbe);
        }else if(spielfigurType == SpielfigurType.Dame){
            return new Dame(name, startPosition, farbe);
        }else if(spielfigurType == SpielfigurType.Koenig){
            return new Koenig(name, startPosition, farbe);
        }
        return null;
    }

}
