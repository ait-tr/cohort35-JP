package app3.controller;

import app3.dto.RequestDto;
import app3.dto.ResponseDto;
import app3.dto.TaskDto;
import app3.entity.Task;
import app3.service.AddTaskService;
import app3.service.FindAllTaskService;
import app3.service.FindTaskByIdService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final AddTaskService addTaskService;
    private final FindAllTaskService findAllTaskService;
    private final FindTaskByIdService findTaskByIdService;

    public TaskController(AddTaskService addTaskService, FindAllTaskService findAllTaskService, FindTaskByIdService findTaskByIdService) {
        this.addTaskService = addTaskService;
        this.findAllTaskService = findAllTaskService;
        this.findTaskByIdService = findTaskByIdService;
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


}
