package com.solncev.fx;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Optional;

public class JavaFxApp extends Application {
    public void start(Stage primaryStage) {

        // simple line
        Line line = new Line();
        line.setStartX(50);
        line.setStartY(50);
        line.setEndX(150);
        line.setEndY(150);

        // adding text element
        Text text = new Text();
        text.setFont(new Font(40));
        text.setX(100);
        text.setY(200);
        text.setText("Some text");

        // dialog window
        Dialog<String> dialog = new Dialog();
        dialog.setTitle("Some form");

        // grid fot input
        GridPane grid = new GridPane();
        final ButtonType sendButtonType = new ButtonType("Send", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(sendButtonType);
        final TextField username = new TextField();
        username.setPromptText("Username");
        grid.add(username, 1, 0);
        dialog.getDialogPane().setContent(grid);

        // button press processing
        dialog.setResultConverter(
                button -> {
                    if (button.equals(sendButtonType)) {
                        return username.getText();
                    }
                    return null;
                }
        );

        // processing input
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(System.out::println);

        //alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        Button cl = new Button("click me");
        cl.setOnAction(event -> alert.show());

        // root group
        Group root = new Group();

        // adding elements
        ObservableList list = root.getChildren();
        list.addAll(line, text, cl);

        // main scene
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setTitle("My first JavaFx app");
        primaryStage.setScene(scene);
        primaryStage.show();

        // key press processing
        scene.setOnKeyPressed(key -> {
            switch (key.getCode()) {
                case A:
                    alert.show();
                case Q:
                    primaryStage.close();
            }
        });
    }

    // run app
    public static void main(String[] args) {
        launch(args);
    }
}
