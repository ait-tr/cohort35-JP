package app3.controller;

import app3.dto.RequestDto;
import app3.dto.ResponseDto;
import app3.dto.TaskDto;
import app3.dto.UpdateTaskRequest;
import app3.entity.Task;
import app3.service.AddTaskService;
import app3.service.FindAllTaskService;
import app3.service.FindTaskByIdService;
import app3.service.UpdateTaskService;
import app3.service.validation.validationRules.CoreError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final AddTaskService addTaskService;
    private final FindAllTaskService findAllTaskService;
    private final FindTaskByIdService findTaskByIdService;
    private final UpdateTaskService updateTaskService;

    public TaskController(AddTaskService addTaskService, FindAllTaskService findAllTaskService, FindTaskByIdService findTaskByIdService, UpdateTaskService updateTaskService) {
        this.addTaskService = addTaskService;
        this.findAllTaskService = findAllTaskService;
        this.findTaskByIdService = findTaskByIdService;
        this.updateTaskService = updateTaskService;
    }


    @PostMapping
    public ResponseDto<Optional<Task>> add(@RequestBody RequestDto request) {
        return addTaskService.addNewTask(request);
    }

    @GetMapping
    public ResponseDto<List<TaskDto>> findAll(){
        return findAllTaskService.findAll();
    }

    @GetMapping(value = "/{idPath}")
    public ResponseDto<TaskDto> findById(@PathVariable("idPath") Integer id){
        return findTaskByIdService.findById(id);
    }

    @PutMapping
    public ResponseDto<Task> updateTask(@RequestBody UpdateTaskRequest request) {
        return new ResponseDto<>(updateTaskService.update(request), new ArrayList<>());
    }


}
