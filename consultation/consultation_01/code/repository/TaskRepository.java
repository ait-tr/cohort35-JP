package code.repository;

import code.dto.RequestDto;
import code.dto.ResponseDto;
import code.entity.Task;

import java.util.List;

public interface TaskRepository {

    Task addNewTask(RequestDto request);

    Task findById(Integer id);

    List<Task> findByName(String name);

    Boolean deleteById(Integer id);

    Task updateTask(Integer id, RequestDto request);

}
