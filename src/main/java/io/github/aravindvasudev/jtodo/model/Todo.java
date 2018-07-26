package io.github.aravindvasudev.jtodo.model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Todo {
    private String description;
    private Date startDate;
    private LocalDate endDate;

    private SimpleDateFormat startDateFormat;
    private DateTimeFormatter endDateFormat;

    public Todo(String description, Date startDate, LocalDate endDate) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;

        startDateFormat = new SimpleDateFormat("HH:mm MM/dd");
        endDateFormat = DateTimeFormatter.ofPattern("MM/dd");
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDateFormat.format(startDate);
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate.format(endDateFormat);
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
