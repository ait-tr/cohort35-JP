package app3.repository;

import app3.dto.RequestDto;
import app3.entity.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    public Optional<Task> findById(Integer id) {
        return tasks.stream()
                .filter(task -> Objects.equals(task.getTaskId(), id))
                .findFirst();
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

    @Override
    public List<Task> findAll() {
        return tasks;
    }
}
