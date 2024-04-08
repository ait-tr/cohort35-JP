package org.group35springbootproject.repository;

import org.group35springbootproject.entity.ToDoEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ArrayListToDoRepository implements ToDoRepository{

    private Integer idSequence = 1;

    private List<ToDoEntity> database = new ArrayList<>();


    @Override
    public ToDoEntity save(ToDoEntity entity) {
        if (entity.getId() != null) {
          return update(entity);
        } else {
            entity.setId(idSequence++);
            database.add(entity);
        }
        return entity;
    }

    private ToDoEntity update(ToDoEntity entity) {
        for (int i = 0; i < database.size(); i++) {
            var existingEntity = database.get(i);
            if (existingEntity.getId().equals(entity.getId())) {
                database.set(i, entity);
                return entity;
            }
        }
        throw new IllegalStateException("Failed to update");
    }

    @Override
    public List<ToDoEntity> findAll() {
        return database;
    }

    @Override
    public Optional<ToDoEntity> findById(Integer id) {
        return database.stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst();
    }
}
