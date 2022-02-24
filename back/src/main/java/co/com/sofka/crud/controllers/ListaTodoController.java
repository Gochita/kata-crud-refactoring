package co.com.sofka.crud.controllers;

import co.com.sofka.crud.entities.TodoEntity;
import co.com.sofka.crud.models.ListaTodoDTO;
import co.com.sofka.crud.models.TodoDTO;
import co.com.sofka.crud.services.ListaTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class ListaTodoController {

    //Trae los servicios
    @Autowired
    private ListaTodoService listaTodoService;

//Trae los todos de una lista por su id
    @GetMapping(value = "/todos/{listId}")
    public List<TodoDTO>  findTodosByListId(@PathVariable ("listId") Long listId){
        return listaTodoService.getTodosByListId(listId);
    }
//Guarda un nuevo to do
    @PostMapping(value = "/todolist")
    public ListaTodoDTO saveNewTodoListById(@RequestBody ListaTodoDTO listaTodoDto) {
        return listaTodoService.createTodoList(listaTodoDto);
    }
    //guarda una nuevo to do por id de la lista
    @PostMapping("/todo/{listId}")
    public TodoDTO saveNewTodoByListId(@PathVariable("listId") Long listId, @RequestBody TodoDTO todoDTO){
        return listaTodoService.saveNewTodoByListId(listId, todoDTO);
    }
    //Actualiza un to do, en caso de no conseguirlo manda un runtimexception
    @PutMapping(value = "/todo/{listId}")
    public TodoDTO updateTodo(@PathVariable("listId") Long listId, @RequestBody TodoDTO todoDTO){
        return listaTodoService.updateToDoByListId(listId, todoDTO);
    }

    //Elimina una lista por id
    @DeleteMapping("/todolist/{listId}")
    public void removeTodoListById(@PathVariable("listId") Long listId){
        listaTodoService.removeTodoListById(listId);
    }

    //Elimina un to do por id
    @DeleteMapping("/todo/{todoId}")
    public void removeTodoById(@PathVariable("todoId") Long todoId){
        listaTodoService.removeTodoById(todoId);
    }

    @GetMapping(value = "api/{id}/todo")
    public TodoEntity get(@PathVariable("id") Long id){
        return listaTodoService.get(id);
    }


}
