package boggle.model;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.EcouteurLettre;
import view.PanneauControle;
import view.VueInfos;
import view.VueLettres;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Boggle boggle = new Boggle(8);
        stage.setTitle("Boggle");
        BorderPane root = new BorderPane();
        VueLettres lettres = new VueLettres(boggle);
        root.setCenter(lettres);
        VueInfos infos = new VueInfos(boggle);
        root.setBottom(infos);
        root.setRight(new PanneauControle(boggle));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();

    }

    public static void main(String [] args){
        launch(args);
    }
}
