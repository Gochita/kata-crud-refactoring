package co.com.sofka.crud.repositories;

import co.com.sofka.crud.entities.ListaTodoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaTodoRepository extends CrudRepository<ListaTodoEntity, Long> {
    List<ListaTodoEntity> findAll();

}
