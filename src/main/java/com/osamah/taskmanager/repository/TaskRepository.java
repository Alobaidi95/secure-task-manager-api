package com.osamah.taskmanager.repository;

import com.osamah.taskmanager.model.Task;
import com.osamah.taskmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task,Long>{

    List<Task> findByUser(User user);
    Optional<Task> findByIdAndUser(Long id , User user);
    void deleteByIdAndUserId(Long id, User user);
}
