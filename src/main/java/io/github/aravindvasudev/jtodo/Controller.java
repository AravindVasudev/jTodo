package io.github.aravindvasudev.jtodo;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    Button addButton;

    @FXML
    TextField description;

    @FXML
    DatePicker datePicker;

    @FXML
    ListView<Todo> todoList;

    ObservableList<Todo> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // focus description
        Platform.runLater(() -> {
            description.requestFocus();
        });

        // set datePicker to today
        refresh();
    }

    @FXML
    private void addTodo(Event e) {
        list.add(new Todo(description.getText(), datePicker.getValue()));
        todoList.setItems(list);

        refresh();
    }

    /**
     * clears description and sets datePicker to now
     */
    private void refresh() {
        datePicker.setValue(LocalDate.now());
        description.setText(null);
    }
}
