package view;

import boggle.model.Boggle;
import boggle.model.Observateur;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class PanneauControle extends VBox implements Observateur {

    private Button valider, effacer, quitter;
    private Boggle boggle;

    public PanneauControle(Boggle b){
        super(5);
        boggle = b;
        valider = new Button("Valider");
        effacer = new Button("Effacer");
        quitter = new Button("Quitter");
        boggle.ajouterObservateur(this);
        this.getChildren().addAll(valider,effacer,quitter);
        this.setAlignment(Pos.CENTER_RIGHT);
        valider.setOnAction(e -> boggle.valider());
        effacer.setOnAction(e -> {
            boggle.effacer();
            boggle.notifierObservateurs();
        });
        quitter.setOnAction(e -> Platform.exit());
    }

    @Override
    public void reagir() {

    }
}
