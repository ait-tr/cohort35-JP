package jpa.org;

import jakarta.persistence.*;

@Entity
@Table(name = "workers")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "FIO")
    private String name;

    @Column(name = "otdel")
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public Employee() {

    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}
