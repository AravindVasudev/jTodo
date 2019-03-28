package io.github.aravindvasudev.jtodo;

import io.github.aravindvasudev.jtodo.model.TodoDBModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    Controller mainController;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("jTodo — The app that you deserve, but not the one you need right now");
        primaryStage.setScene(new Scene(root));

        mainController = fxmlLoader.getController();
        primaryStage.show();

        mainController.getTodoDAO().load();
    }

    @Override
    public void stop() throws Exception {
        mainController.getTodoDAO().save();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
