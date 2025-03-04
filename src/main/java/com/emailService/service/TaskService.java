package com.emailService.service;

import com.emailService.model.TaskModel;
import com.emailService.util.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskModel> findByTitle(String title) {
        return taskRepository.findByTitle(title);
    }

    public List<TaskModel> getAllTasks() {
        return taskRepository.findAll();
    }

    public TaskModel createTask(TaskModel task) {
        return taskRepository.save(task);
    }

    public Optional<TaskModel> getByID(UUID taskID) {
        return taskRepository.findById(taskID);
    }

    public TaskModel updateTask(UUID taskID, TaskModel updatedTask) {
        Optional<TaskModel> oldTask = taskRepository.findById(taskID);

        if (oldTask.isPresent()) {
            TaskModel task = oldTask.get();
            task.setTitle(updatedTask.getTitle());
            task.setBody(updatedTask.getBody());
            task.setExpirationDate(updatedTask.getExpirationDate());

            return taskRepository.save(task);
        }
        throw new RuntimeException("Not found task with id: " + taskID);
    }

    public Optional<TaskModel> deleteTask(UUID taskID) {
        Optional<TaskModel> deletedTask = taskRepository.findById(taskID);
        taskRepository.deleteById(taskID);
        return deletedTask;
    }

    public List<TaskModel> getByTitle(String title) {
        return taskRepository.findByTitle(title);
    }

    public List<TaskModel> getByBody(String body) {
        return taskRepository.findByBody(body);
    }

    public List<TaskModel> getByBodyOrTitle(String s) {
        return taskRepository.findByBodyOrTitle(s);
    }
}
