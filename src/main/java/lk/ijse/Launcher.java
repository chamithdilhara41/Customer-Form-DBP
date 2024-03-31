package lk.ijse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(this.getClass().getResource("/view/LoginForm.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Login Form");
        stage.setScene(scene);
        stage.show();

        /*stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/CustomerForm.fxml"))));
        stage.setTitle("Customer Form");
        stage.centerOnScreen();
        stage.show();*/
    }
}