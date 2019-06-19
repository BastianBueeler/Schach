package logik.internal.chessmen;

public class SpielfigurFactory {

    private static SpielfigurFactory spielfigurFactory = new SpielfigurFactory();

    public static SpielfigurFactory getInstance() {
        return spielfigurFactory;
    }

    private SpielfigurFactory() {
    }

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
