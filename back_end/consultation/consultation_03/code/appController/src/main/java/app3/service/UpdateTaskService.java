package app3.service;

import app3.dto.UpdateTaskRequest;
import app3.entity.Task;
import app3.repository.TaskRepository;
import app3.service.validation.validationRules.CoreError;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UpdateTaskService {

    private final TaskRepository repository;

    public UpdateTaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task update(UpdateTaskRequest request){
       return repository.updateTask(request);
    }

}
