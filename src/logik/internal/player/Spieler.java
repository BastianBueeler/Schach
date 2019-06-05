package logik.internal.player;

import logik.internal.chessmen.ISpielfigur;

import java.util.List;

public class Spieler {

    private String name;
    private List<ISpielfigur> spielfiguren;

    public Spieler (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ISpielfigur> getSpielfiguren() {
        return spielfiguren;
    }

    public void setSpielfiguren(List<ISpielfigur> spielfiguren) {
        this.spielfiguren = spielfiguren;
    }
}