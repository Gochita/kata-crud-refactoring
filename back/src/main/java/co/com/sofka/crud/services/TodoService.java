package co.com.sofka.crud.services;

import co.com.sofka.crud.repositories.TodoRepository;
import co.com.sofka.crud.models.TodoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Iterable<TodoModel> list(){
        return todoRepository.findAll();
    }

    public TodoModel save(TodoModel todo){
        return todoRepository.save(todo);
    }

    public void delete(Long id){
        todoRepository.delete(get(id));
    }

    public TodoModel get(Long id){
         return todoRepository.findById(id).orElseThrow();
    }

}
