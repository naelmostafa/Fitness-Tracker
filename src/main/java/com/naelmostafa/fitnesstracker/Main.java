package com.naelmostafa.fitnesstracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("tracker-view.fxml"));
        primaryStage.setTitle("Fitness Tracker");
        primaryStage.setScene(new Scene(fxmlLoader.load()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.addKickBoxing(20);
        tracker.addRunning(5);
        launch(args);
    }
}
