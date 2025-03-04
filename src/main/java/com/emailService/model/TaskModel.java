package com.emailService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Setter
@Getter
@Document(collection = "Tasks")
@AllArgsConstructor
public class TaskModel {

    private String title;
    private String body;
    private LocalDateTime expirationDate;
    @Id private UUID taskID;

    public TaskModel() {
        this.taskID = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "Title: " + this.getTitle() + "\nBody: " + this.getBody() + "\nTaskID: " + this.getTaskID() + "\n";
    }
}
