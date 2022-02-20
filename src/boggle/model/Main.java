package boggle.model;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Boggle boggle = new Boggle(4);
        stage.setTitle("Boggle");
        BorderPane root = new BorderPane();
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }

    public static void main(String [] args){
        launch(args);
    }
}
