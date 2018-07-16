package io.github.aravindvasudev.jtodo;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Controller for main.fxml
 */
public class Controller implements Initializable {
    @FXML private TextField description;
    @FXML private DatePicker datePicker;

    @FXML private TableView<Todo> table;

    private ObservableList<Todo> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // focus description
        Platform.runLater(() -> {
            description.requestFocus();
        });

        // set datePicker to today
        refresh();
    }

    public ObservableList<Todo> getList() {
        return list;
    }

    /**
     * Add entry to todoList and reset description
     *
     * @param e Event
     */
    @FXML
    private void addTodo(Event e) {
        if (description.getText() == null) return;
        list.add(new Todo(description.getText(), new Date(), datePicker.getValue()));

        refresh();
    }

    /**
     * delete todoList entry on right click
     *
     * @param e MouseEvent
     */
    @FXML
    private void deleteTodoEntry(MouseEvent e) {
        if (table.getSelectionModel().getSelectedItem() == null) return;

        if (e.getButton().equals(MouseButton.SECONDARY)) {
            list.remove(table.getSelectionModel().getSelectedItem());
        }
    }

    /**
     * clears description and sets datePicker to now
     */
    private void refresh() {
        datePicker.setValue(LocalDate.now());
        description.setText(null);
    }
}
