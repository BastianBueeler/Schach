package logik;

import logik.internal.chessmen.ISpielfigur;
import logik.internal.chessmen.Spielfigur;
import logik.internal.chessmen.SpielfigurFactory;
import logik.internal.chessmen.SpielfigurType;
import logik.internal.player.Spieler;
import logik.internal.player.SpielerFactory;

import java.util.ArrayList;
import java.util.List;

public class Spiel{

    private Spieler spieler1;
    private Spieler spieler2;
    private Spieler aktuellerSpieler = spieler1;
    private String[] bauerPositionenen1 = {"a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2"};
    private String[] bauerPositionenen2 = {"a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7"};
    private String[] springerPositionenen1 = {"b1", "g1"};
    private String[] springerPositionenen2 = {"b8", "g8"};
    private String[] laeuferPositionenen1 = {"c1", "f1"};
    private String[] laeuferPositionenen2 = {"c8", "f8"};
    private String[] turmPositionenen1 = {"a1", "h1"};
    private String[] turmPositionenen2 = {"a8", "h8"};
    private List<List<ISpielfigur>> spielfeld = new ArrayList<>();

    public void createSpieler(String name){
        SpielerFactory spielerFactory = SpielerFactory.getInstance();
        if(spieler1 == null){
            spieler1 = spielerFactory.createSpieler(name);
        }else{
            spieler2 = spielerFactory.createSpieler(name);
        }
    }

    public void createSpielfiguren(){
        SpielfigurFactory spielfigurFactory = SpielfigurFactory.getInstance();
        List<ISpielfigur> spielfiguren1 = new ArrayList<>();
        List<ISpielfigur> spielfiguren2 = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            spielfiguren1.add(spielfigurFactory.createSpielfiguren(SpielfigurType.Bauer, "Bauer", bauerPositionenen1[i]));
            spielfiguren2.add(spielfigurFactory.createSpielfiguren(SpielfigurType.Bauer, "Bauer", bauerPositionenen2[i]));
        }
        for(int i = 0; i < 2; i++){
            spielfiguren1.add(spielfigurFactory.createSpielfiguren(SpielfigurType.Springer, "Springer", springerPositionenen1[i]));
            spielfiguren2.add(spielfigurFactory.createSpielfiguren(SpielfigurType.Springer, "Springer", springerPositionenen2[i]));
        }
        for(int i = 0; i < 2; i++){
            spielfiguren1.add(spielfigurFactory.createSpielfiguren(SpielfigurType.Laeufer, "Läufer", laeuferPositionenen1[i]));
            spielfiguren2.add(spielfigurFactory.createSpielfiguren(SpielfigurType.Laeufer, "Läufer", laeuferPositionenen2[i]));
        }
        for(int i = 0; i < 2; i++){
            spielfiguren1.add(spielfigurFactory.createSpielfiguren(SpielfigurType.Turm, "Turm", turmPositionenen1[i]));
            spielfiguren2.add(spielfigurFactory.createSpielfiguren(SpielfigurType.Turm, "Turm", turmPositionenen2[i]));
        }
        spielfiguren1.add(spielfigurFactory.createSpielfiguren(SpielfigurType.Koenig, "König", "e1"));
        spielfiguren2.add(spielfigurFactory.createSpielfiguren(SpielfigurType.Koenig, "König", "e8"));

        spielfiguren1.add(spielfigurFactory.createSpielfiguren(SpielfigurType.Dame, "Dame", "d1"));
        spielfiguren2.add(spielfigurFactory.createSpielfiguren(SpielfigurType.Dame, "Dame", "d8"));

        spieler1.setSpielfiguren(spielfiguren1);
        spieler2.setSpielfiguren(spielfiguren2);

        figurenAufSpielfeldSetzen();
    }

    public void spielerWechsel(){
        if(aktuellerSpieler == spieler1){
            aktuellerSpieler = spieler2;
        }else{
            aktuellerSpieler = spieler1;
        }
    }

    public List<List<ISpielfigur>> figurenAufSpielfeldSetzen(){
        List<ISpielfigur> zeile;
        StringBuffer position = new StringBuffer();
        for(int i = 0; i < 8; i++){
            zeile = new ArrayList<>();
            for(int j = 0; j < 8; j++){
                position.append((char)j +97);
                position.append((int)i + 1);
                for(ISpielfigur figur1 : spieler1.getSpielfiguren()){
                    if(figur1.iskorrekteFigur(position.toString())){
                        zeile.add(figur1);
                    }else{
                        for(ISpielfigur figur2 : spieler2.getSpielfiguren()){
                            if(figur2.iskorrekteFigur((position.toString()))){
                                zeile.add(figur2);
                            }else{
                                zeile.add(null);
                            }
                        }
                    }
                }
            }
            spielfeld.add(zeile);
        }
        return spielfeld;
    }

    public boolean zugAusfuehren(String zug){
        String figurPosition = zug.substring(0, 2);
        String spielzugTyp = zug.substring(2, 3);
        String zielPosition = zug.substring(3, 5);
        Spieler gegner;
        ISpielfigur figur = null;

        if(spielzugTyp.equals("x")){
            if(aktuellerSpieler == spieler1) {
                gegner = spieler2;
            }else {
                gegner = spieler1;
            }

            for(ISpielfigur figurGegner : gegner.getSpielfiguren()){
                if(!figurGegner.iskorrekteFigur(zielPosition)){

                }else {
                    for(ISpielfigur ueberpruefendeFigur : aktuellerSpieler.getSpielfiguren()){
                        if(ueberpruefendeFigur.iskorrekteFigur(figurPosition)){
                            figur = ueberpruefendeFigur;
                        }
                    }
                    break;
                }
            }
            if(figur.spielzugUeberpruefen(zielPosition, spielzugTyp)){
                figur.zugAusfuehren(zielPosition);
            }else {
                return false;
            }

        }else {

        }

        return false;
    }

    public List<List<ISpielfigur>> getSpielfeld(){
        return spielfeld;
    }
}