package io.github.aravindvasudev.jtodo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main extends Application {
    Controller mainController;
    public SessionFactory sessionFactory = new Configuration()
            .configure()
            .buildSessionFactory();

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("jTodo — The app that you deserve, but not the one you need right now");
        primaryStage.setScene(new Scene(root));

        mainController = fxmlLoader.<Controller>getController();
        primaryStage.show();

        mainController.getTodoDAO().load();
    }

    @Override
    public void stop() throws Exception {
        mainController.getTodoDAO().save();
        sessionFactory.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
