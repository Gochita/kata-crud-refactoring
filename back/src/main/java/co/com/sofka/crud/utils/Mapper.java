package co.com.sofka.crud.utils;

import co.com.sofka.crud.entities.ListaTodoEntity;
import co.com.sofka.crud.entities.TodoEntity;
import co.com.sofka.crud.models.ListaTodoDTO;
import co.com.sofka.crud.models.TodoDTO;

public class Mapper {

    public static TodoEntity mapTodoDTO_ToTodo(TodoDTO todoDTO) {
        TodoEntity todo = new TodoEntity();
        todo.setId(todoDTO.getId());
        todo.setName(todoDTO.getName());
        todo.setCompleted(todoDTO.isCompleted());
        return todo;

    }

    public static ListaTodoEntity mapListDTO_ToList(ListaTodoDTO listaTodoDTO) {
        ListaTodoEntity listaTodoEntity = new ListaTodoEntity();
        listaTodoEntity.setId(listaTodoDTO.getId());
        listaTodoEntity.setName(listaTodoDTO.getName());
        listaTodoEntity.setListaTodoModel(listaTodoDTO.getTodos());
        return listaTodoEntity;
    }

    public static TodoDTO mapTodo_To_TodoDTO(TodoEntity todoEntity) {
        TodoDTO todoDTO = new TodoDTO();
        todoDTO.setId(todoEntity.getId());
        todoDTO.setName(todoEntity.getName());
        todoDTO.setCompleted(todoEntity.isCompleted());
        return todoDTO;

    }

    public static ListaTodoDTO mapList_ToListDTO(ListaTodoEntity listaTodoEntity) {
        ListaTodoDTO listaTodoDTO = new ListaTodoDTO();
        listaTodoDTO.setId(listaTodoEntity.getId());
        listaTodoDTO.setName(listaTodoEntity.getName());
        listaTodoDTO.setTodos(listaTodoEntity.getListaTodoModel());
        return listaTodoDTO;

    }


}
