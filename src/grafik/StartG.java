package grafik;

import logik.Spiel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartG extends JFrame implements ActionListener {
    private JButton btnNextSite;
    private JTextField txtPlayer1 = new JTextField("Spieler1");
    private JTextField txtPlayer2 = new JTextField("Spieler2");
    private JLabel lblRequest = new JLabel("Bitte gebt die Spielernamen ein.");
    private JPanel Panel1, Panel2, Panel3;
    private Spiel game = new Spiel();
    private JPanel panel1;

    public StartG() {

        setLayout(new BorderLayout(5,5));


        Panel1.setLayout(new BorderLayout(5,5));
        add(Panel1, BorderLayout.CENTER);
        Panel1.add(lblRequest);

        Panel2.setLayout(new GridLayout(1,2,5,5));
        Panel1.add(Panel2, BorderLayout.CENTER);
        Panel2.add(txtPlayer1);
        Panel2.add(txtPlayer2);

        Panel3.setLayout(new BorderLayout(5,5));
        add(Panel3, BorderLayout.SOUTH);
        Panel3.add(btnNextSite);

        btnNextSite.addActionListener(this);

        this.setVisible(true);
        this.setSize(1500, 1000); // Fenstergr�sse
        this.setTitle("Schach");

    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnNextSite) {
            game.createSpieler(txtPlayer1.getText());
            game.createSpieler(txtPlayer2.getText());
        }
    }

}