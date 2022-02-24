package co.com.sofka.crud.models;

import co.com.sofka.crud.entities.TodoEntity;

import java.util.List;

public class ListaTodoDTO {

    private Long id;
    private String name;
    private List<TodoEntity> todos;

    public ListaTodoDTO(Long id, String name, List<TodoEntity> todos) {
        this.id = id;
        this.name = name;
        this.todos= todos;
    }

    public ListaTodoDTO() {
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

    public List<TodoEntity> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoEntity> todos) {
        this.todos = todos;
    }
}
