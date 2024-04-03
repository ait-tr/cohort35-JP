package org.group35springbootproject.repository;

import org.group35springbootproject.entity.ToDoEntity;

import java.util.List;
import java.util.Optional;

public interface ToDoRepository {
    ToDoEntity save(ToDoEntity entity);

    List<ToDoEntity> findAll();

    Optional<ToDoEntity> findById(Integer id);

}
