package co.com.sofka.crud.entities;


import javax.persistence.*;
import java.util.List;

@Entity
public class ListaTodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique=true, nullable=false)
    private Long id;

    @Column(length = 15, nullable = false, unique = true)
    private String name;



    @OneToMany(cascade = CascadeType.ALL)
    private List<TodoEntity> listaTodoModel;

    public List<TodoEntity> getListaTodoModel() {
        return listaTodoModel;
    }

    public void setListaTodoModel(List<TodoEntity> listaTodoModel) {
        this.listaTodoModel = listaTodoModel;
    }

    public ListaTodoEntity() {
    }

    public ListaTodoEntity(Long id, String name, List<TodoEntity> listaTodoModel) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "ListaTodoEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
