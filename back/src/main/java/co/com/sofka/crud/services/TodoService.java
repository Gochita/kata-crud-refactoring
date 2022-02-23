package co.com.sofka.crud.services;

import co.com.sofka.crud.repositories.TodoRepository;
import co.com.sofka.crud.entities.TodoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Iterable<TodoEntity> list(){
        return todoRepository.findAll();
    }

    public TodoEntity save(TodoEntity todo){
        return todoRepository.save(todo);
    }

    public void delete(Long id){
        todoRepository.delete(get(id));
    }

    public TodoEntity get(Long id){
         return todoRepository.findById(id).orElseThrow();
    }

}
