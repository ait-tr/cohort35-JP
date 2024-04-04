package app3.repository;

import app3.dto.RequestDto;
import app3.dto.UpdateTaskRequest;
import app3.entity.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
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
    public Task updateTask(UpdateTaskRequest request) {
        for (int i = 0; i < tasks.size(); i++) {
            var existingTask = tasks.get(i);
            if (existingTask.getTaskId().equals(request.getId())) {
                Task updatedTask = new Task(request.getId(), request.getName(), request.getDescription());
                tasks.set(i, updatedTask);
                return updatedTask;
            }
        }
       throw new IllegalStateException("Failed to update");
    }

    @Override
    public List<Task> findAll() {
        return tasks;
    }
}
