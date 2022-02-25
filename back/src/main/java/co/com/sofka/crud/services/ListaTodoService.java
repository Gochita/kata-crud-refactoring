package co.com.sofka.crud.services;


import co.com.sofka.crud.entities.ListaTodoEntity;
import co.com.sofka.crud.entities.TodoEntity;
import co.com.sofka.crud.models.ListaTodoDTO;
import co.com.sofka.crud.models.TodoDTO;
import co.com.sofka.crud.repositories.ListaTodoRepository;
import co.com.sofka.crud.repositories.TodoRepository;
import co.com.sofka.crud.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class ListaTodoService {


    //Autowired de ambos repositorios para manejo de metodos
    @Autowired
    private ListaTodoRepository listaTodoRepository;

    @Autowired
    private TodoRepository todoRepository;


    //Servicio para obtener los Todos de una lista
    public List<TodoDTO> getTodosFromList(Optional <ListaTodoEntity> listaTodoEntity){

        return listaTodoEntity.orElseGet(ListaTodoEntity::new)
                .getListaTodoModel().stream()
                .map(todoEntity -> new TodoDTO(todoEntity.getId(),todoEntity.getName(),
                        todoEntity.isCompleted(),listaTodoEntity.get().getId())).collect(Collectors.toList());
    }


    //Servicio para obtener los todos por el id de una lista
    public List<TodoDTO> getTodosByListId(Long listId) {
        var todoLista = listaTodoRepository.findById(listId);
        return getTodosFromList(todoLista);
    }

    //Servicio para crear una lista de to dos
    public ListaTodoDTO createTodoList(ListaTodoDTO listaTodoDTO) {

        ListaTodoEntity todoList = new ListaTodoEntity();
        todoList.setId(listaTodoDTO.getId());
        todoList.setName(listaTodoDTO.getName());
        todoList.setListaTodoModel(new ArrayList<>());
        ListaTodoEntity prueba=listaTodoRepository.save(todoList);
        System.out.println(prueba);
     //   return Mapper.mapList_ToListDTO(listaTodoRepository.save(todoList));
        return Mapper.mapList_ToListDTO(prueba);
    }


    //Servicio para guardar un to do a una lista por id
    public TodoDTO saveNewTodoByListId(Long listId, TodoDTO todoDTO) {
        var todoLista = listaTodoRepository.findById(listId);
        var todo = Mapper.mapTodoDTO_ToTodo(todoDTO);
        todoLista.orElseGet(ListaTodoEntity::new).getListaTodoModel().add(todo);
        var listUpdated = listaTodoRepository.save(todoLista.get());
        var insertedToDo = listUpdated.getListaTodoModel()
                .stream()
                .max(Comparator.comparing(item -> item.getId().intValue()))
                .orElseThrow();
        todoDTO.setId(insertedToDo.getId());
        todoDTO.setGroupListId(listId);
        return todoDTO;
    }

    private List<TodoEntity> editTodosInList(ListaTodoEntity TodoList, TodoDTO todoDTO){
        return TodoList.getListaTodoModel()
                .stream()
                .map(todoEntity -> {
                    if (todoEntity.getId().equals(todoDTO.getId())){
                        todoEntity.setName(todoDTO.getName());
                        todoEntity.setCompleted(todoDTO.isCompleted());
                    }
                    return todoEntity;
                })
                .collect(Collectors.toList());
    }

    public TodoDTO updateToDoByListId(Long listId, TodoDTO todoDTO){
        var TodoList = listaTodoRepository.findById(listId);
        var updatedTodos = editTodosInList(TodoList.orElseGet(ListaTodoEntity::new), todoDTO);
        ListaTodoEntity todoLista = new ListaTodoEntity();
        todoLista.setId(TodoList.orElseGet(ListaTodoEntity::new).getId());
        todoLista.setName(TodoList.orElseGet(ListaTodoEntity::new).getName());
        todoLista.setListaTodoModel(TodoList.orElseGet(ListaTodoEntity::new).getListaTodoModel());
        listaTodoRepository.save(todoLista);
        todoDTO.setGroupListId(listId);
        return todoDTO;
    }

    public void removeTodoListById(Long id){
        var toDoList = listaTodoRepository.findById(id).orElseThrow();
        listaTodoRepository.delete(toDoList);
    }
    public void removeTodoById(Long id){
        var toDo = todoRepository.findById(id).orElseThrow();
        todoRepository.delete(toDo);
    }
    public Iterable  <ListaTodoEntity>  traerTodos (){
        return listaTodoRepository.findAll();
    }



    public TodoEntity save(TodoEntity todo) {
        return todoRepository.save(todo);
    }

    public void delete(Long id) {
        todoRepository.delete(get(id));
    }

    public TodoEntity get(Long id) {
        return todoRepository.findById(id).orElseThrow();
    }


}
