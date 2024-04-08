package org.group35springbootproject.service;

import org.group35springbootproject.entity.ToDoEntity;
import org.group35springbootproject.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindToDoById {
    private final ToDoRepository repository;

    public FindToDoById(ToDoRepository repository) {
        this.repository = repository;
    }

    public ToDoEntity findById(Integer id){
        Optional<ToDoEntity> optionalToDoEntity = repository.findById(id);
        if (optionalToDoEntity.isPresent()) {
            return optionalToDoEntity.get();
        } else {
            throw new IllegalStateException("Entity with ID = " + id + " not found!");
        }
    }
}
