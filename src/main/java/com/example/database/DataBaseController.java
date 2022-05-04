package com.example.database;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.IOException;

public class DataBaseController {

    @FXML
    private Button addObjectButton;

    @FXML
    private ListView<Person> objectsListView;

    @FXML
    private Button readFileButton;

    @FXML
    private Button saveFileButton;
    private final DataBase data = new DataBase();
    private final String fileName = "dsa.txt";

    public void initialize(){

        try {
            data.readFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        objectsListView.getItems();
    }

    @FXML
    void clickAddOjbectButton(ActionEvent event) {
        data.addObject(new Person());
        objectsListView.setItems(data.objects);
    }

    @FXML
    void clickReadFileButton(ActionEvent event) {
        try {
            data.readFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void clickSaveFileButton(ActionEvent event) {
        data.saveFile(fileName);
    }


}
