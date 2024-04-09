package org.jpaspringdata.service;

import org.jpaspringdata.entity.ToDoEntity;
import org.jpaspringdata.repository.ToDoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;



@Service
public class FindToDoById {
    private final ToDoRepository repository;

    public FindToDoById(ToDoRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<ToDoEntity> findById(Integer id){
        Optional<ToDoEntity> optionalToDoEntity = repository.findById(id);
        if (optionalToDoEntity.isPresent()) {
            return new ResponseEntity<>(optionalToDoEntity.get(), HttpStatus.OK);
        } else {
            throw new IllegalStateException("Entity with ID = " + id + " not found!");
        }
    }
}
