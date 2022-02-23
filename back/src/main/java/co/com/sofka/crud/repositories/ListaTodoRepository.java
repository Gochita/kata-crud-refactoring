package co.com.sofka.crud.repositories;

import co.com.sofka.crud.entities.ListaTodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ListaTodoRepository extends CrudRepository<ListaTodoEntity, Long> {
}
