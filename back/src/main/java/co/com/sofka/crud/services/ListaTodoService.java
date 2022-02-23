package co.com.sofka.crud.services;


import co.com.sofka.crud.entities.ListaTodoEntity;
import co.com.sofka.crud.repositories.ListaTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListaTodoService {


    @Autowired
    private ListaTodoRepository listaTodoRepository;

    public Iterable<ListaTodoEntity> list() {
        return listaTodoRepository.findAll();
    }

    public ListaTodoEntity save(ListaTodoEntity todo) {
        return listaTodoRepository.save(todo);
    }

    public void delete(Long id) {
        listaTodoRepository.delete(get(id));
    }

    public ListaTodoEntity get(Long id) {
        return listaTodoRepository.findById(id).orElseThrow();
    }


}
