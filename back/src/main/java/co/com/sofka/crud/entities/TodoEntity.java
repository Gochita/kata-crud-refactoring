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

    @Column(nullable=false)
    private Long idLista;

    public Long getId() {
        return id;
    }

    public Long getIdLista() {
        return idLista;
    }

    public void setIdLista(Long idLista) {
        this.idLista = idLista;
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

    public TodoEntity(Long id, String name, boolean completed, Long idLista) {
        this.id = id;
        this.name = name;
        this.completed=completed;
        this.idLista=idLista;
    }

    public TodoEntity() {
    }
}
