package io.github.aravindvasudev.jtodo.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue()
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private LocalDate endDate;

    private static SimpleDateFormat startDateFormat = new SimpleDateFormat("HH:mm MM/dd");
    private static DateTimeFormatter endDateFormat = DateTimeFormatter.ofPattern("d MMMM yyyy");

    public Todo() {
    }

    public Todo(String description, Date startDate, LocalDate endDate) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Todo(String description, String startDate, String endDate) throws Exception {
        this(description, startDateFormat.parse(startDate), LocalDate.parse(endDate, endDateFormat));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
