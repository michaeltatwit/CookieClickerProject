package application;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;
import Application.Cookie;

public class Main extends Application implements Initializable {

    @FXML
    Button myButton;

    @FXML
    Text myText;

    @FXML
    ProgressBar bar;


    @Override
    public void start(Stage primaryStage) {
        try {

            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("application/Root.fxml"));

            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

            primaryStage.setResizable(false);
            primaryStage.setTitle("");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
       myButton.setOnAction(new Start() {});
    }
}
