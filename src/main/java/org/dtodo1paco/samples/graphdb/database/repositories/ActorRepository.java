package org.dtodo1paco.samples.graphdb.database.repositories;

import org.dtodo1paco.samples.graphdb.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface ActorRepository extends PagingAndSortingRepository<Person, Long> {

  List<Person> findByName(@Param("name") String name);

}
