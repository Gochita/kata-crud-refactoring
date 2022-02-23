package co.com.sofka.crud;

import model.TodoModel;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<TodoModel, Long> {
}
