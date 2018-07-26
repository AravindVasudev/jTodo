package io.github.aravindvasudev.jtodo.model;

import javafx.collections.ObservableList;

public interface TodoDAO {
    public void add(Todo todo);
    public void remove(Todo toDeleteTodo);
    public void save() throws Exception;
    public ObservableList<Todo> getList();
}
