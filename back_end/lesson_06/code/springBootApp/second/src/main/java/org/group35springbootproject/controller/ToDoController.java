package org.group35springbootproject.controller;

import org.group35springbootproject.dto.AddToDoRequest;
import org.group35springbootproject.entity.ToDoEntity;
import org.group35springbootproject.service.AddToDoService;
import org.group35springbootproject.service.FindAllToDoService;
import org.group35springbootproject.service.FindToDoById;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    private final AddToDoService addToDoService;
    private final FindAllToDoService findAllToDoService;
    private final FindToDoById findToDoById;

    public ToDoController(AddToDoService addToDoService, FindAllToDoService findAllToDoService, FindToDoById findToDoById) {
        this.addToDoService = addToDoService;
        this.findAllToDoService = findAllToDoService;
        this.findToDoById = findToDoById;
    }

    @PostMapping
    public ToDoEntity add(@RequestBody AddToDoRequest request) {
        return addToDoService.add(request);
    }

    @GetMapping
    public List<ToDoEntity> findAll() {
        return findAllToDoService.findAll();
    }

    @GetMapping(value = "/{idPath}")
    public ToDoEntity findToDoById(@PathVariable("idPath") Integer id) {
        return findToDoById.findById(id);
    }
}

