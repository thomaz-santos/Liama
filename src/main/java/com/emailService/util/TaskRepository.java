package com.emailService.util;

import com.emailService.model.TaskModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends MongoRepository<TaskModel, UUID> {
    List<TaskModel> findByTitle(String title);

    List<TaskModel> findByBody(String body);

    @Query("{ '$or': [ { 'title': { '$regex': ?0, '$options': 'i' } }, { 'body': { '$regex': ?0, '$options': 'i' } } ] }")
    List<TaskModel> findByBodyOrTitle(String s);

    Optional<TaskModel> findById(UUID taskId);

    List<TaskModel> findAll();

    TaskModel save(TaskModel task);
}
