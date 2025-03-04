package com.emailService.controller;

import com.emailService.model.TaskModel;
import com.emailService.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/list")
    public List<TaskModel> listTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/list/{taskID}")
    public Optional<TaskModel> listTasks(@PathVariable UUID taskID) {
        return taskService.getByID(taskID);
    }

    @GetMapping("/list/title/{title}")
    public List<TaskModel> getTaskbyTitle(@PathVariable String title) {
        return taskService.getByTitle(title);
    }

    @GetMapping("/list/body/{body}")
    public List<TaskModel> getTaskbyBody(@PathVariable String body) {
        return taskService.getByBody(body);
    }

    @GetMapping("/list/search")
    public List<TaskModel> getTaskbyBodyOrTitle(@RequestParam String s) {
        return taskService.getByBodyOrTitle(s);
    }

    @PostMapping("/create")
    public TaskModel createTask(@RequestBody TaskModel task) {
        return taskService.createTask(task);
    }

    @PutMapping("/update/{taskID}")
    public TaskModel updateTask(@PathVariable UUID taskID, @RequestBody TaskModel task) {
        return taskService.updateTask(taskID, task);
    }

    @DeleteMapping("/delete/{taskID}")
    public Optional<TaskModel> deleteTask(@PathVariable UUID taskID) {
        return taskService.deleteTask(taskID);
    }
}
