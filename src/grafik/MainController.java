package grafik;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import logik.Spiel;
import logik.internal.chessmen.ISpielfigur;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainController {

    Spiel game;

    @FXML
    private TextField lblMove;

    @FXML
    private Label lblGiveInformations;

    @FXML
    private Button btnHelp;

    @FXML
    private Button btnMove;

    @FXML
    private Button btnGiveUp;

    @FXML
    private ImageView a1;
    @FXML
    private ImageView b1;
    @FXML
    private ImageView c1;
    @FXML
    private ImageView d1;
    @FXML
    private ImageView e1;
    @FXML
    private ImageView f1;
    @FXML
    private ImageView g1;
    @FXML
    private ImageView h1;


    @FXML
    private ImageView a2;
    @FXML
    private ImageView b2;
    @FXML
    private ImageView c2;
    @FXML
    private ImageView d2;
    @FXML
    private ImageView e2;
    @FXML
    private ImageView f2;
    @FXML
    private ImageView g2;
    @FXML
    private ImageView h2;


    @FXML
    private ImageView a3;
    @FXML
    private ImageView b3;
    @FXML
    private ImageView c3;
    @FXML
    private ImageView d3;
    @FXML
    private ImageView e3;
    @FXML
    private ImageView f3;
    @FXML
    private ImageView g3;
    @FXML
    private ImageView h3;


    @FXML
    private ImageView a4;
    @FXML
    private ImageView b4;
    @FXML
    private ImageView c4;
    @FXML
    private ImageView d4;
    @FXML
    private ImageView e4;
    @FXML
    private ImageView f4;
    @FXML
    private ImageView g4;
    @FXML
    private ImageView h4;


    @FXML
    private ImageView a5;
    @FXML
    private ImageView b5;
    @FXML
    private ImageView c5;
    @FXML
    private ImageView d5;
    @FXML
    private ImageView e5;
    @FXML
    private ImageView f5;
    @FXML
    private ImageView g5;
    @FXML
    private ImageView h5;


    @FXML
    private ImageView a6;
    @FXML
    private ImageView b6;
    @FXML
    private ImageView c6;
    @FXML
    private ImageView d6;
    @FXML
    private ImageView e6;
    @FXML
    private ImageView f6;
    @FXML
    private ImageView g6;
    @FXML
    private ImageView h6;


    @FXML
    private ImageView a7;
    @FXML
    private ImageView b7;
    @FXML
    private ImageView c7;
    @FXML
    private ImageView d7;
    @FXML
    private ImageView e7;
    @FXML
    private ImageView f7;
    @FXML
    private ImageView g7;
    @FXML
    private ImageView h7;


    @FXML
    private ImageView a8;
    @FXML
    private ImageView b8;
    @FXML
    private ImageView c8;
    @FXML
    private ImageView d8;
    @FXML
    private ImageView e8;
    @FXML
    private ImageView f8;
    @FXML
    private ImageView g8;

    @FXML
    private ImageView h8 = new ImageView();

    PauseTransition pause5 = new PauseTransition(
            Duration.seconds(5)
    );

    PauseTransition pause20 = new PauseTransition(
            Duration.seconds(20)
    );

    List<List<ImageView>> field = new ArrayList<>();

    List<ImageView> row1 = new ArrayList<>();
    List<ImageView> row2 = new ArrayList<>();
    List<ImageView> row3 = new ArrayList<>();
    List<ImageView> row4 = new ArrayList<>();
    List<ImageView> row5 = new ArrayList<>();
    List<ImageView> row6 = new ArrayList<>();
    List<ImageView> row7 = new ArrayList<>();
    List<ImageView> row8 = new ArrayList<>();
    private ClassLoader getClass;

    public void createFXMLField(){
        row1.add(a1);
        row1.add(b1);
        row1.add(c1);
        row1.add(d1);
        row1.add(e1);
        row1.add(f1);
        row1.add(g1);
        row1.add(h1);
        field.add(row1);

        row2.add(a2);
        row2.add(b2);
        row2.add(c2);
        row2.add(d2);
        row2.add(e2);
        row2.add(f2);
        row2.add(g2);
        row2.add(h2);
        field.add(row2);

        row3.add(a3);
        row3.add(b3);
        row3.add(c3);
        row3.add(d3);
        row3.add(e3);
        row3.add(f3);
        row3.add(g3);
        row3.add(h3);
        field.add(row3);

        row4.add(a4);
        row4.add(b4);
        row4.add(c4);
        row4.add(d4);
        row4.add(e4);
        row4.add(f4);
        row4.add(g4);
        row4.add(h4);
        field.add(row4);

        row5.add(a5);
        row5.add(b5);
        row5.add(c5);
        row5.add(d5);
        row5.add(e5);
        row5.add(f5);
        row5.add(g5);
        row5.add(h5);
        field.add(row5);

        row6.add(a6);
        row6.add(b6);
        row6.add(c6);
        row6.add(d6);
        row6.add(e6);
        row6.add(f6);
        row6.add(g6);
        row6.add(h6);
        field.add(row6);

        row7.add(a7);
        row7.add(b7);
        row7.add(c7);
        row7.add(d7);
        row7.add(e7);
        row7.add(f7);
        row7.add(g7);
        row7.add(h7);
        field.add(row7);

        row8.add(a8);
        row8.add(b8);
        row8.add(c8);
        row8.add(d8);
        row8.add(e8);
        row8.add(f8);
        row8.add(g8);
        row8.add(h8);
        field.add(row8);
    }

    public void createField() {
        List<List<ISpielfigur>> spielfeld = game.getSpielfeld();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){

                if(spielfeld.get(i).get(j) == null){
                    field.get(i).get(j).setImage(null);
                    continue;
                }
                if(spielfeld.get(i).get(j).getName().equalsIgnoreCase("bauer")){
                    field.get(i).get(j).setImage(new Image ("Pictures/characters/" + spielfeld.get(i).get(j).getFarbe() + "/bauer.jpg"));
                }
                if(spielfeld.get(i).get(j).getName().equalsIgnoreCase("dame")){
                    field.get(i).get(j).setImage(new Image ("Pictures/characters/" + spielfeld.get(i).get(j).getFarbe() + "/dame.jpg"));
                }
                if(spielfeld.get(i).get(j).getName().equalsIgnoreCase("könig")){
                    field.get(i).get(j).setImage(new Image ("Pictures/characters/" + spielfeld.get(i).get(j).getFarbe() + "/könig.jpg"));
                }
                if(spielfeld.get(i).get(j).getName().equalsIgnoreCase("läufer")){
                    field.get(i).get(j).setImage(new Image ("Pictures/characters/" + spielfeld.get(i).get(j).getFarbe() + "/läufer.jpg"));
                }
                if(spielfeld.get(i).get(j).getName().equalsIgnoreCase("springer")){
                    field.get(i).get(j).setImage(new Image ("Pictures/characters/" + spielfeld.get(i).get(j).getFarbe() + "/springer.jpg"));
                }
                if(spielfeld.get(i).get(j).getName().equalsIgnoreCase("turm")){
                    field.get(i).get(j).setImage(new Image ("Pictures/characters/" + spielfeld.get(i).get(j).getFarbe() + "/turm.jpg"));
                }
            }
        }
        lblGiveInformations.setText(game.getAktuellerSpieler().getName() + " ist dran!");
        pause5.play();
        pause5.setOnFinished(event1 -> {
            lblGiveInformations.setText(null);
        });
    }

    @FXML
    public void makeMove(ActionEvent event) throws InterruptedException {
        if( game.zugAusfuehren(lblMove.getText()) == false){
            lblGiveInformations.setText("Zug ungültig!");
            pause5.play();
            pause5.setOnFinished(event1 -> {
                lblGiveInformations.setText(null);
                });
        } else {
            createField();
           if (game.spielGewonnen() == false) {
               game.spielerWechsel();
               lblGiveInformations.setText(game.getAktuellerSpieler().getName() + " ist dran!");
               pause5.play();
               pause5.setOnFinished(event1 -> {
                   lblGiveInformations.setText(null);
               });
           } else {
               btnGiveUp.setDisable(true);
               btnHelp.setDisable(true);
               btnMove.setDisable(true);
               lblGiveInformations.setText(game.getAktuellerSpieler().getName() + " hat gewonnen!");
               pause20.play();
               pause20.setOnFinished(event1 -> {
                   lblGiveInformations.setText("Spiel wird geschlossen");
                   pause5.play();
                   pause5.setOnFinished(event2 -> {
                       System.exit(0);
                   });

               });
           }
        }
    }

    public void setGame(Spiel game){
        this.game = game;
    }


        @FXML
        public void giveUp (ActionEvent event) {
             btnGiveUp.setDisable(true);
             btnHelp.setDisable(true);
             btnMove.setDisable(true);
           if (game.getAktuellerSpieler().getName().equals(game.getSpieler1())){
               lblGiveInformations.setText(game.getSpieler1().getName() + " hat aufgegeben");

               pause5.play();
               pause5.setOnFinished(event1 -> {
                   lblGiveInformations.setText(game.getSpieler2().getName() + " hat gewonnen!");
                   pause20.play();
                   pause20.setOnFinished(event2 -> {
                       lblGiveInformations.setText("Spiel wird geschlossen");
                       pause5.play();
                       pause5.setOnFinished(event3 -> {
                           System.exit(0);
                       });
                   });
               });
           } else {
               lblGiveInformations.setText(game.getSpieler2().getName() + " hat aufgegeben");
               pause5.play();
               pause5.setOnFinished(event1 -> {
                   lblGiveInformations.setText(game.getSpieler1().getName() + " hat gewonnen!");
                   pause20.play();
                   pause20.setOnFinished(event2 -> {
                       lblGiveInformations.setText("Spiel wird geschlossen");
                       pause5.play();
                       pause5.setOnFinished(event3 -> {
                           System.exit(0);
                       });

                   });
               });
           }
        }

    @FXML
    public void openHelp (ActionEvent event) throws IOException {

        FXMLLoader fxmlloader = new FXMLLoader (getClass().getResource("HelpFXML.fxml"));
        Parent root1 = (Parent) fxmlloader.load();
        Stage stage = new Stage();

        stage.setTitle("Hilfe?!");
        stage.getIcons().add(new Image("Pictures/questionmark.png"));
        stage.setScene (new Scene(root1));
        stage.show();
    }
}


