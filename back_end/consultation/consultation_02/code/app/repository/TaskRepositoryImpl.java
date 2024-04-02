package code.app.repository;

import code.app.dto.RequestDto;
import code.app.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {

    private Integer taskIdCounter = 0;
    private List<Task> tasks = new ArrayList<>();


    @Override
    public Task addNewTask(RequestDto request) {
        Task newTask = new Task(++taskIdCounter, request.getName(), request.getDescription());
        tasks.add(newTask);
        return newTask;
    }

    @Override
    public Task findById(Integer id) {
        return null;
    }

    @Override
    public List<Task> findByName(String name) {
        return List.of();
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }

    @Override
    public Task updateTask(Integer id, RequestDto request) {
        return null;
    }
}
