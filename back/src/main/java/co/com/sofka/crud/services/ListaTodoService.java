package co.com.sofka.crud.services;


import co.com.sofka.crud.entities.ListaTodoEntity;
import co.com.sofka.crud.entities.TodoEntity;
import co.com.sofka.crud.models.TodoDTO;
import co.com.sofka.crud.repositories.ListaTodoRepository;
import co.com.sofka.crud.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.el.PropertyNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListaTodoService {
    public static final String msg = "No encontrado";

    @Autowired
    private ListaTodoRepository listaTodoRepository;

    @Autowired
    private TodoRepository todoRepository;


    //Si retorna null, no encontro una lista con ese id
    public List<TodoEntity> getTodosByListId(Long id) {
        if(!listaTodoRepository.findById(id).isPresent()) {
            System.out.println("No existe lista con ese id");
            return null;
        }else{
            return listaTodoRepository.findById(id).get().getListaTodoModel().stream()
                    .map(item -> new TodoEntity(item.getId(), item.getName(), item.isCompleted(),id))
                    .collect(Collectors.toList());
        }
    }


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
