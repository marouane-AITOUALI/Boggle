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
        this.setPrefWidth(30);
        boggle = b;
        lettres = new Button[b.getTaille()][b.getTaille()];
        for (int i = 0; i < b.getTaille();i++){
            for (int j = 0; j < b.getTaille();j++){
                lettres[i][j] = new Button(Character.toString(boggle.getLettre(i,j)));
                this.add(lettres[i][j],j,i);
                lettres[i][j].setOnAction(new EcouteurLettre(boggle,i,j));
            }
        }
        //this.boggle.ajouterObservateur(this);
    }

    @Override
    public void reagir() {
    }
}
