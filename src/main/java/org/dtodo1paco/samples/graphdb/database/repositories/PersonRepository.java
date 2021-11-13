package org.dtodo1paco.samples.graphdb.database.repositories;

import org.dtodo1paco.samples.graphdb.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long> {

  Collection<Person> findByNameLike(@Param("name") String name);

  @Query("MATCH (p:Person) WHERE p.name =~ '.*$name.*' RETURN p")
  Collection<Person> findAllByNameLike(@Param("name")String name);

  @Query(value = "MATCH (movie:Movie {title:{0}})<-[:ACTED_IN]-(p:Person) RETURN p SKIP $skip LIMIT $limit",
    countQuery= "MATCH (movie:Movie {title:{0}})<-[:ACTED_IN]-(p:Person) RETURN count(p)")
  Page<Person> getActorsThatActInAmoviesFromTitle(String movieTitle, Pageable pageable );

}
