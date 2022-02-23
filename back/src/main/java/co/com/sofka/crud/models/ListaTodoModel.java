package co.com.sofka.crud.models;


import javax.persistence.*;

@Entity
public class ListaTodoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 15, nullable = false, unique = true)
    private String name;


    public ListaTodoModel() {
    }

    public ListaTodoModel(String name) {
        this.name = name;
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
        return "ListaTodoModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
