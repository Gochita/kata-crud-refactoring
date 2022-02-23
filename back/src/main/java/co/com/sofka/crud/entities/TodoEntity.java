package co.com.sofka.crud.entities;

import javax.persistence.*;

@Entity
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique=true, nullable=false)
    private Long id;


    @Column(length = 25, nullable = false)
    private String name;

    @Column(nullable=false)
    private boolean completed;



/*
    public ListaTodoEntity getListaTodoModel() {
        return listaTodoModel;
    }

    public void setListaTodoModel(ListaTodoEntity listaTodoModel) {
        this.listaTodoModel = listaTodoModel;
    }
*/

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

    public TodoEntity() {
    }

    public TodoEntity(String name, boolean completed, ListaTodoEntity listaTodoModel) {
        this.name = name;
        this.completed = completed;
    }
}
