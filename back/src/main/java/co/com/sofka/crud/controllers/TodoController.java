package co.com.sofka.crud.controllers;

import co.com.sofka.crud.entities.TodoEntity;
import co.com.sofka.crud.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping(value = "api/todos")
    public Iterable<TodoEntity> list(){
        return todoService.list();
    }
    
    @PostMapping(value = "api/todo")
    public TodoEntity save(@RequestBody TodoEntity todo){
        return todoService.save(todo);
    }

    @PutMapping(value = "api/todo")
    public TodoEntity update(@RequestBody TodoEntity todo){
        if(todo.getId() != null){
            return todoService.save(todo);
        }
        throw new RuntimeException("No existe el id para actualizar");
    }

    @DeleteMapping(value = "api/{id}/todo")
    public void delete(@PathVariable("id")Long id){
        todoService.delete(id);
    }

    @GetMapping(value = "api/{id}/todo")
    public TodoEntity get(@PathVariable("id") Long id){
        return todoService.get(id);
    }

}
