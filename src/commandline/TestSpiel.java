package commandline;

import logik.Spiel;
import logik.internal.chessmen.ISpielfigur;

import java.util.List;

public class TestSpiel {

    public static void main(String[] args) {
        Spiel spiel = new Spiel();
        spiel.createSpieler("Spieler 1");
        spiel.createSpieler("Spieler 2");
        spiel.createSpielfiguren();

        List<List<ISpielfigur>> spielfeld = spiel.getSpielfeld();
        for (List<ISpielfigur> row: spielfeld) {
            for (ISpielfigur cell: row) {
                System.out.print(cell == null ? "<null>" : cell.getName());
            }
            System.out.println();
        }
    }

}
