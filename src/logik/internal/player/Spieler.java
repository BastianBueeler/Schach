package logik.internal.player;

import logik.internal.chessmen.ISpielfigur;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dario Grob
 * @version 1.0
 */
public class Spieler {

    private String name;
    private List<ISpielfigur> spielfiguren = new ArrayList<>();

    /**
     * @param name - Wird zum Namen des Spielers
     */
    public Spieler (String name){
        this.name = name;
    }

    /**
     * @return String - Gibt den Namen des Spielers zurück
     */
    public String getName() {
        return name;
    }

    /**
     * @param name - wird zum Namen des Spielers
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return List<ISpielfigur> - Gibt die Figuren zurück, welche der Spieler noch besitzt
     */
    public List<ISpielfigur> getSpielfiguren() {
        return spielfiguren;
    }

    /**
     * @param spielfiguren - Diese Figuren besitzt dieser Spieler nun
     */
    public void setSpielfiguren(List<ISpielfigur> spielfiguren) {
        this.spielfiguren = spielfiguren;
    }

    public void figurFressen(ISpielfigur figur){
        spielfiguren.remove(figur);
    }
}