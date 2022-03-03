package boggle.model;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.PanneauControle;
import view.VueInfos;
import view.VueLettres;
import view.VueMotsTrouvés;

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
        PanneauControle p = new PanneauControle(boggle);
        root.setRight(p);

        VueMotsTrouvés mots = new VueMotsTrouvés(boggle);
        root.setLeft(mots);

        // Ajout de Menu
        Menu file = new Menu("_File");
        MenuItem item1 = new MenuItem("Nouvelle partie...");
        file.getItems().add(item1);
        file.getItems().add(new SeparatorMenuItem());
        MenuItem exitItem = new MenuItem("exit");
        file.getItems().add(exitItem);

        // Ecouteur Menu
        exitItem.setOnAction(e -> Platform.exit());
        item1.setOnAction(e1 -> {
            Stage window = new Stage();
            window.setTitle("Nouvelle Partie");
            VBox panneau = new VBox();
            TextField text = new TextField();
            Label label = new Label("Entrer la taille du jeu Boggle");
            Button b = new Button("Valider");
            panneau.getChildren().addAll(label, text,b);
            b.setOnAction(e2 ->{
                int taille = Integer.parseInt(text.getText());
                Boggle newBoggle = new Boggle(taille);
                window.close();
            });
            window.setScene(new Scene(panneau,250,100));
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
