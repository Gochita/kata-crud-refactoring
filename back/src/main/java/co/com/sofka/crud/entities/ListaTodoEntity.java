package co.com.sofka.crud.entities;


import javax.persistence.*;

@Entity
public class ListaTodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique=true, nullable=false)
    private Long id;

    @Column(length = 15, nullable = false, unique = true)
    private String name;


    public ListaTodoEntity() {
    }

    public ListaTodoEntity(String name) {
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
        return "ListaTodoEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
