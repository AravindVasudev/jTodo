package io.github.aravindvasudev.jtodo.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.*;

public class TodoCSVModel implements TodoDAO {
    private ObservableList<Todo> list;
    private StringBuilder csv;
    private String seperator;
    private String linebreak;
    private String savePath;

    public TodoCSVModel() {
        list = FXCollections.observableArrayList();

        csv = new StringBuilder();
        seperator = ",";
        linebreak = "\n";
        savePath = "./todo.csv";
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
        for (Todo todo : list) {
            int i = 0;
            for (PropertyDescriptor propertyDescriptor : Introspector.getBeanInfo(Todo.class, Object.class).getPropertyDescriptors()) {
                String property = propertyDescriptor.getReadMethod().invoke(todo, null).toString();

                property = property.replaceAll(",", "");

                if (i != 0) {
                    csv.append(seperator);
                }
                csv.append(property);

                i++;
            }

            csv.append(linebreak);
        }

        writeToFile();
    }

    @Override
    public void load() throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(savePath)));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] params = line.split(",");
                list.add(new Todo(params[0], params[2], params[1]));
            }
        } catch (Exception e) {}
    }

    private boolean writeToFile() {
        try (PrintWriter out = new PrintWriter(savePath)) {
            out.println(csv);
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }


    @Override
    public ObservableList<Todo> getList() {
        return list;
    }
}
