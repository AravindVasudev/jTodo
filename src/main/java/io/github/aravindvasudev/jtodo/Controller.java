package io.github.aravindvasudev.jtodo;

import io.github.aravindvasudev.jtodo.model.Todo;
import io.github.aravindvasudev.jtodo.model.TodoCSVModel;
import io.github.aravindvasudev.jtodo.model.TodoDAO;
import io.github.aravindvasudev.jtodo.model.TodoDBModel;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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

    private TodoDAO todoDAO = new TodoDBModel();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // focus description
        Platform.runLater(() -> {
            description.requestFocus();
        });

        // set datePicker to today
        refresh();
    }

    public TodoDAO getTodoDAO() {
        return todoDAO;
    }

    /**
     * Add entry to todoList and reset description
     *
     * @param e Event
     */
    @FXML
    private void addTodo(Event e) {
        if (description.getText() == null) return;
        todoDAO.add(new Todo(description.getText(), new Date(), datePicker.getValue()));

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
            todoDAO.remove(table.getSelectionModel().getSelectedItem());
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
