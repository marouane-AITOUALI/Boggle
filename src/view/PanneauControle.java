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
        super(20);
        boggle = b;
        valider = new Button("Valider");
        effacer = new Button("Effacer");
        quitter = new Button("Quitter");
        this.getChildren().addAll(valider,effacer,quitter);
        this.setAlignment(Pos.CENTER_RIGHT);
        quitter.setOnAction(e -> Platform.exit());
        effacer.setOnAction(new EcouteurEffacer());
    }

    @Override
    public void reagir() {

    }
}
