package io.github.aravindvasudev.jtodo;

import java.time.LocalDate;

public class Todo {
    private String description;
    private LocalDate date;

    public Todo(String description, LocalDate date) {
        this.description = description;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("%s → %s", this.getDate(), this.getDescription());
    }
}
