package repository;

import dto.RequestDto;
import entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    Task addNewTask(RequestDto request);

    Optional<Task> findById(Integer id);

    List<Task> findByName(String name);

    Boolean deleteById(Integer id);

    Task updateTask(Integer id, RequestDto request);

    List<Task> findAll();
}
