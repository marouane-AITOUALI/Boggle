package boggle.model;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.EcouteurLettre;
import view.PanneauControle;
import view.VueInfos;
import view.VueLettres;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // Creation Boggle
        Boggle boggle = new Boggle(8);
        stage.setTitle("Boggle");

        // Panneau
        BorderPane root = new BorderPane();
        VueLettres lettres = new VueLettres(boggle);
        root.setCenter(lettres);
        VueInfos infos = new VueInfos(boggle);
        root.setBottom(infos);
        root.setRight(new PanneauControle(boggle));

        // Ajout de Menu
        Menu file = new Menu("_File");
        MenuItem item1 = new MenuItem("Nouvelle partie...");
        file.getItems().add(item1);
        file.getItems().add(new SeparatorMenuItem());
        MenuItem exitItem = new MenuItem("exit");
        file.getItems().add(exitItem);

        // Ecouteur Menu
        exitItem.setOnAction(e -> Platform.exit());
        item1.setOnAction(e -> {
            Stage window = new Stage();
            window.setTitle("Nouvelle Partie en cours");
            VBox panneau = new VBox();
            Label label = new Label("Entrer la taille du Boggle: ");
            TextField text = new TextField("");
            Button b1 = new Button("Valider");
            b1.setOnAction(e1 -> {
                int tailleBoggle = Integer.parseInt(text.getText());
                stage.setScene(new Scene());
            });
            panneau.getChildren().addAll(label,text,b1);
            window.setScene(new Scene(panneau, 250, 100));
            window.show();
        });

        // Barre de menu
        MenuBar barre = new MenuBar();
        barre.getMenus().add(file);

        root.setTop(barre);
        // Window Parametres
        stage.setScene(new Scene(root, 600, 600));
        stage.setResizable(true);
        stage.show();

    }

    public static void main(String [] args){
        launch(args);
    }
}
