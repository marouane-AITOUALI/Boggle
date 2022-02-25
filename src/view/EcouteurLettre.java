package view;

import boggle.model.Boggle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class EcouteurLettre implements EventHandler<ActionEvent> {
    private Boggle boggle;
    private int lig, col;

    public EcouteurLettre(Boggle b, int ligne, int colomne){
        boggle = b;
        lig = ligne;
        col = colomne;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        boggle.ajouterLettre(lig,col);
        boggle.notifierObservateurs();
    }
}
