package org.jpaspringdata.repository;


import lombok.experimental.PackagePrivate;
import org.jpaspringdata.entity.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDoEntity, Integer> {

    public List<ToDoEntity> findByName(String name);
    public List<ToDoEntity> findByDescription(String description);

    default List<ToDoEntity> findToDoWithLongNames(int minLength){
        return findAll().stream()
                .filter(toDoEntity -> toDoEntity.getName() != null && toDoEntity.getName().length() > minLength)
                .toList();
    }

    @Query("SELECT t FROM ToDoEntity t WHERE LENGTH(t.name) > 10 AND t.id > :id")
    public List<ToDoEntity> findToDoWithNameLengthLongerThanAndIdGreaterThan(@Param("id") Integer id);

}
