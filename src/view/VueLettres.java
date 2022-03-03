package view;

import boggle.model.Boggle;
import boggle.model.Observateur;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class VueLettres extends GridPane implements Observateur {
    private Boggle boggle;
    private Button [][] lettres;

    public Button getButton(int i, int j){
        return lettres[i][j];
    }

    public VueLettres(Boggle b){
        super();
        this.setPadding(new Insets(3));
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);this.setVgap(10);
        this.setPrefSize(40,40);
        //this.setStyle("-fx-background-color: #000");
        boggle = b;
        lettres = new Button[boggle.getTaille()][boggle.getTaille()];
        for (int i = 0; i < b.getTaille();i++){
            for (int j = 0; j < b.getTaille();j++){
                lettres[i][j] = new Button(Character.toString(boggle.getLettre(i,j)));
                lettres[i][j].setStyle("-fx-font: 16 arial;" +
                        " -fx-background-color: #45F9A3");
                Button bouton = lettres[i][j];
                bouton.setPrefWidth(this.getPrefWidth());
                bouton.setPrefHeight(this.getPrefHeight());
                bouton.setMaxHeight(20);
                bouton.setMinWidth(15);
                this.add(bouton,j,i);
                bouton.setOnAction(new EcouteurLettre(boggle,i,j));
            }
        }
        //this.boggle.ajouterObservateur(this);
    }

    @Override
    public void reagir() {
    }
}
