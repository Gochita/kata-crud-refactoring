package co.com.sofka.crud.models;

public class ListaTodoDTO {

    private Long id;
    private String name;

    public ListaTodoDTO(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
