package co.com.sofka.crud.controllers;

import co.com.sofka.crud.entities.TodoEntity;
import co.com.sofka.crud.services.ListaTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class ListaTodoController {

    //Trae los servicios
    @Autowired
    private ListaTodoService listaTodoService;

//Trae todas las listas de to dos
    @GetMapping(value = "api/todos")
    public Iterable<TodoEntity> list(){
        return listaTodoService.list();
    }
//Guarda un nuevo to do
    @PostMapping(value = "api/todo")
    public TodoEntity save(@RequestBody TodoEntity todo){
        return listaTodoService.save(todo);
    }
//Actualiza un to do, en caso de no conseguirlo manda un runtimexception
    @PutMapping(value = "api/todo")
    public TodoEntity update(@RequestBody TodoEntity todo){
        if(todo.getId() != null){
            return listaTodoService.save(todo);
        }
        throw new RuntimeException("No existe el id para actualizar");
    }

//elimina una lista
    @DeleteMapping(value = "api/{id}/todo")
    public void delete(@PathVariable("id")Long id){
        listaTodoService.delete(id);
    }



    @GetMapping(value = "api/{id}/todo")
    public TodoEntity get(@PathVariable("id") Long id){
        return listaTodoService.get(id);
    }


}
