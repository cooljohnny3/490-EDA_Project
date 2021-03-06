package com.COMP490.EDA;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Home.fxml"));
        loader.setController(new HomeController());
        Parent page = loader.load();
        Scene scene = new Scene(page);

        primaryStage.getIcons().add(new Image("/img/HomeBackground.jpg"));
        primaryStage.setTitle("Symbol Editor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
