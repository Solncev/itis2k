package com.solncev.fxml.controller;

import com.solncev.fxml.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

import java.util.stream.Collectors;


public class UserListController {

    @FXML
    private TextField name;

    @FXML
    private Button search;

    @FXML
    private TableView tableView;

    @FXML
    private Label label;

    @FXML
    private VBox users;

    private final ObservableList<User> userList = FXCollections.observableArrayList();
    private ObservableList<User> resultList = FXCollections.observableArrayList(userList);

    public UserListController() {
        userList.add(new User(1, "Эдуард"));
        userList.add(new User(2, "Илья"));
        userList.add(new User(3, "Глеб"));
    }

    @FXML
    private void initialize() {
        search.setText("Search");
        search.setOnAction(event -> loadData());

//        button.setStyle();

        name.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                loadData();
            }
        });

        name.textProperty().addListener(((observable, oldValue, newValue) ->
                label.setText(newValue)
        ));

        initTable();
    }

    private void initTable() {
        tableView = new TableView<>(FXCollections.observableList(userList));
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn id = new TableColumn("ID");
        id.setCellValueFactory(new PropertyValueFactory("id"));
        TableColumn name = new TableColumn("NAME");
        name.setCellValueFactory(new PropertyValueFactory("name"));
        tableView.getColumns().addAll(id, name);

        users.getChildren().add(tableView);
    }

    private void loadData() {
        String searchText = name.getText();

        Task<ObservableList<User>> task = new Task<ObservableList<User>>() {
            @Override
            protected ObservableList<User> call() {
                return FXCollections.observableArrayList(userList
                        .stream()
                        .filter(u -> u.getName().toLowerCase().contains(searchText.toLowerCase()))
                        .collect(Collectors.toList())
                );
            }
        };

        task.setOnSucceeded(event -> {
            resultList = task.getValue();
            tableView.setItems(FXCollections.observableList(resultList));
        });

        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }
}
