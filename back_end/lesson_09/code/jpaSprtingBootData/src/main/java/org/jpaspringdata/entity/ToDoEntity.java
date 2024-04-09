package org.jpaspringdata.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jpaspringdata.entity.User;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

//    @Column(columnDefinition = "varchar(255 default 'email@email.com'")
//    private String email;

    @ManyToOne
    @JoinColumn(name = "to_do_author_id")
    private User toDoAuthor;

}
