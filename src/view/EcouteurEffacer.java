package view;

import boggle.model.Boggle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class EcouteurEffacer implements EventHandler<ActionEvent> {

    private Boggle boggle;

    public EcouteurEffacer(Boggle b){
        boggle = b;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        boggle.effacer();
        boggle.notifierObservateurs();
    }
}
