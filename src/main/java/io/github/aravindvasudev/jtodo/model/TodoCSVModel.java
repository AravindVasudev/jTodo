package io.github.aravindvasudev.jtodo.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TodoCSVModel implements TodoDAO {
    private ObservableList<Todo> list;

    public TodoCSVModel() {
        list = FXCollections.observableArrayList();
    }

    @Override
    public void add(Todo todo) {
        list.add(todo);
    }

    @Override
    public void remove(Todo toDeleteTodo) {
        list.remove(toDeleteTodo);
    }

    @Override
    public void save() throws Exception {

    }

    @Override
    public ObservableList<Todo> getList() {
        return list;
    }
}
