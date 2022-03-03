package view;

import boggle.model.Boggle;
import boggle.model.Observateur;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;

public class VueInfos extends TilePane implements Observateur {

    private Boggle boggle;
    private Label labelMot;
    private Label labelScore;

    public VueInfos(Boggle b){
        super();
        boggle = b;
        labelMot = new Label("Le mot choisi: "+boggle.getMotChoisi());
        labelScore = new Label("Score: "+boggle.getScore());
        this.getChildren().addAll(labelMot,labelScore);
        this.setAlignment(Pos.BOTTOM_CENTER);
        this.boggle.ajouterObservateur(this);

    }


    public void re(){
        labelMot.setText("Le mot choisi: "+boggle.getMotChoisi());
        labelScore.setText("Score: "+boggle.getScore());
    }

    @Override
    public void reagir() {
        this.re();
    }
}
