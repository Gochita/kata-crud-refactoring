package co.com.sofka.crud.models;

import javax.persistence.*;

@Entity
public class TodoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(length = 25, nullable = false)
    private String name;

    @Column
    private boolean completed;

    @Column(length = 10, nullable = false, unique = true)
    private String groupListId;




    public String getGroupListId() {
        return groupListId;
    }

    public void setGroupListId(String groupListId) {
        this.groupListId = groupListId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public TodoModel() {
    }

    public TodoModel(String name, boolean completed, String groupListId) {
        this.name = name;
        this.completed = completed;
        this.groupListId = groupListId;
    }
}
