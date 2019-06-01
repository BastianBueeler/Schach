package logik.internal.chessmen;

public class SpielfigurFactory {

    private static SpielfigurFactory spielfigurFactory = new SpielfigurFactory();

    public static SpielfigurFactory getInstance() {
        return spielfigurFactory;
    }

    private SpielfigurFactory() {
    }

    public ISpielfigur createSpielfiguren(SpielfigurType spielfigurType, String name, String startPosition){
        if(spielfigurType == SpielfigurType.Bauer) {
            return new Bauer(name, startPosition);
        }else if(spielfigurType == SpielfigurType.Springer){
            return new Springer(name, startPosition);
        }else if(spielfigurType == SpielfigurType.Laeufer){
            return new Laeufer(name, startPosition);
        }else if(spielfigurType == SpielfigurType.Turm){
            return new Turm(name, startPosition);
        }else if(spielfigurType == SpielfigurType.Dame){
            return new Dame(name, startPosition);
        }else if(spielfigurType == SpielfigurType.Koenig){
            return new Koenig(name, startPosition);
        }
        return null;
    }

}
