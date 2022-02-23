package co.com.sofka.crud.controllers;


import co.com.sofka.crud.entities.ListaTodoEntity;
import co.com.sofka.crud.services.ListaTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ListaTodoController {
    @Autowired
    private ListaTodoService listaTodoService;


    @GetMapping(value = "api/todos")
    public Iterable<ListaTodoEntity> list(){
        return listaTodoService.list();
    }

    @PostMapping(value = "api/todo")
    public ListaTodoEntity save(@RequestBody ListaTodoEntity todo){
        return listaTodoService.save(todo);
    }

    @PutMapping(value = "api/todo")
    public ListaTodoEntity update(@RequestBody ListaTodoEntity todo){
        if(todo.getId() != null){
            return listaTodoService.save(todo);
        }
        throw new RuntimeException("No existe el id para actualizar");
    }


    @DeleteMapping(value = "api/{id}/todo")
    public void delete(@PathVariable("id")Long id){
        listaTodoService.delete(id);
    }

    @GetMapping(value = "api/{id}/todo")
    public ListaTodoEntity get(@PathVariable("id") Long id){
        return listaTodoService.get(id);
    }


}
