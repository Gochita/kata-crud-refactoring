package co.com.sofka.crud.services;


import co.com.sofka.crud.entities.ListaTodoEntity;
import co.com.sofka.crud.entities.TodoEntity;
import co.com.sofka.crud.models.TodoDTO;
import co.com.sofka.crud.repositories.ListaTodoRepository;
import co.com.sofka.crud.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaTodoService {

public static final String msg ="No encontrado";

@Autowired
private ListaTodoRepository listaTodoRepository;

@Autowired
private TodoRepository todoRepository;




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
