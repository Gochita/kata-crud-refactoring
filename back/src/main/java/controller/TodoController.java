package controller;

import model.TodoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.TodoService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping(value = "api/todos")
    public Iterable<TodoModel> list(){
        return service.list();
    }
    
    @PostMapping(value = "api/todo")
    public TodoModel save(@RequestBody TodoModel todo){
        return service.save(todo);
    }

    @PutMapping(value = "api/todo")
    public TodoModel update(@RequestBody TodoModel todo){
        if(todo.getId() != null){
            return service.save(todo);
        }
        throw new RuntimeException("No existe el id para actualizar");
    }

    @DeleteMapping(value = "api/{id}/todo")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "api/{id}/todo")
    public TodoModel get(@PathVariable("id") Long id){
        return service.get(id);
    }

}
