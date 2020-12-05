package com.solncev.fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(FXMLApplication.class.getResource("/UserListController.fxml"));
        AnchorPane anchorPane = loader.load();
        Scene scene = new Scene(anchorPane);

//        scene.getStylesheets().add("/user.css");

        primaryStage.setTitle("User List");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
