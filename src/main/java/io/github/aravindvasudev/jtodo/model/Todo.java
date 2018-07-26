package io.github.aravindvasudev.jtodo.model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Todo {
    private String description;
    private Date startDate;
    private LocalDate endDate;

    private static SimpleDateFormat startDateFormat = new SimpleDateFormat("HH:mm MM/dd");
    private static DateTimeFormatter endDateFormat = DateTimeFormatter.ofPattern("d MMMM yyyy");

    public Todo(String description, Date startDate, LocalDate endDate) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Todo(String description, String startDate, String endDate) throws Exception {
        this(description, startDateFormat.parse(startDate), LocalDate.parse(endDate, endDateFormat));
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
