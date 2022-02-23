package co.com.sofka.crud.models;


import co.com.sofka.crud.entities.ListaTodoEntity;

public class TodoDTO {

    private Long id;
    private String name;
    private boolean completed;
    private ListaTodoEntity listaTodoModel;

    public TodoDTO() {
    }

    public TodoDTO(Long id, String name, boolean completed, ListaTodoEntity listaTodoModel) {
        this.id = id;
        this.name = name;
        this.completed = completed;
        this.listaTodoModel = listaTodoModel;
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

    public ListaTodoEntity getListaTodoModel() {
        return listaTodoModel;
    }

    public void setListaTodoModel(ListaTodoEntity listaTodoModel) {
        this.listaTodoModel = listaTodoModel;
    }
}
