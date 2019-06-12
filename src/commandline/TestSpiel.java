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
        if(spiel.zugAusfuehren("a2-a3")){
            List<List<ISpielfigur>> spielfeld = spiel.getSpielfeld();
            List<ISpielfigur> t = spielfeld.get(0);
            System.out.println(t.get(0).getName());
            //for (List<ISpielfigur> row: spielfeld) {
            //    for (ISpielfigur cell: row) {
            //        System.out.print(cell == null ? "<null>" : cell.getName());
            //    }
            //    System.out.println();
            //}
        }else{
            System.out.println("du hesch verkackt");
        }
    }

}
