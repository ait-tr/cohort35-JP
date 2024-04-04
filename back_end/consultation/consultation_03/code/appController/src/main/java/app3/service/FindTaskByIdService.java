package service;

import dto.ResponseDto;
import dto.TaskDto;
import entity.Task;
import repository.TaskRepository;
import service.validation.validationRules.CoreError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FindTaskByIdService {
    private TaskRepository repository;

    public FindTaskByIdService(TaskRepository repository) {
        this.repository = repository;
    }

    public ResponseDto<TaskDto> findById(Integer id) {

        Optional<Task> foundTask = repository.findById(id);
        TaskDto foundTaskDto = null;
        List<CoreError> errors = new ArrayList<>();

        if (foundTask.isEmpty()) {
            errors.add(new CoreError("Task with id = " + id + " doesn't exist"));
        } else {
            foundTaskDto = converter(foundTask.get());
        }

        return new ResponseDto<>(foundTaskDto, errors);
    }

    private TaskDto converter(Task task) {
        return new TaskDto(task.getName(), task.getDescription());
    }
}
