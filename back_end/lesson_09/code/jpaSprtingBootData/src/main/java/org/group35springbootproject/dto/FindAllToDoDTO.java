package org.group35springbootproject.dto;

import org.group35springbootproject.entity.ToDoEntity;

import java.util.List;

public class FindAllToDoDTO {

    private List<ToDoEntity> entities;
    private List<String> errors;
    public FindAllToDoDTO(List<ToDoEntity> entities, List<String> errors) {
        this.entities = entities;
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "FindAllToDoDTO{" +
                "entities=" + entities +
                ", errors=" + errors +
                '}';
    }
}
