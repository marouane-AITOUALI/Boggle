package view;

import boggle.model.Boggle;
import boggle.model.Observateur;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class VueLettres extends GridPane implements Observateur {
    private Boggle boggle;
    private Button [][] lettres;


    public VueLettres(Boggle b){
        boggle = b;
        lettres = new Button[b.getTaille()][b.getTaille()];
        for (int i = 0; i < b.getTaille();i++){
            for (int j = 0; j < b.getTaille();j++){
                lettres[i][j] = new Button(Character.toString(boggle.getLettre(i,j)));
                this.add(lettres[i][j],i,j);
            }
        }
    }

    @Override
    public void reagir() {

    }
}
