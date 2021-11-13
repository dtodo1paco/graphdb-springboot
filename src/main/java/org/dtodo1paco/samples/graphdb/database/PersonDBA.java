package org.dtodo1paco.samples.graphdb.database;

import lombok.Getter;
import org.dtodo1paco.samples.graphdb.database.repositories.PersonRepository;
import org.dtodo1paco.samples.graphdb.model.projections.Person3rdGradeContacts;
import org.neo4j.driver.Record;
import org.neo4j.driver.types.TypeSystem;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Objects;

@Component
public class PersonDBA {

  @Getter
  private PersonRepository repository;
  private final Neo4jClient client;

  public PersonDBA(PersonRepository repository, Neo4jClient client) {
    this.repository = repository;
    this.client = client;
  }

  public Collection<Person3rdGradeContacts> find3rdGradeContacts(String personNameToStart, Integer limit) {
    boolean filterByName = !Objects.isNull(personNameToStart) && !personNameToStart.isEmpty();
    String query = "MATCH (p1:Person"+(filterByName ? "{name: $name}" : "") + ")-[:HAS_CONTACT]->(p2)-[:HAS_CONTACT]->(p3) RETURN "+
                     "p1.name as p1Name, " +
                     "collect(p2.name)[0] as p2Name, " +
                     "collect(p3.name)[0] as p3Name " +
                     "LIMIT $limit";

    Neo4jClient.RunnableSpecTightToDatabase res = client.query(query);
    if (filterByName) {
      res = res.bind(personNameToStart).to("name");
    }
    res = res.bind(limit).to("limit");
    return res.fetchAs(Person3rdGradeContacts.class)
      .mappedBy((TypeSystem t, Record record) -> {
        String p1Name = record.get("p1Name").asString();
        String p2Name = record.get("p2Name").asString();
        String p3Name = record.get("p3Name").asString();
        return new Person3rdGradeContacts(p1Name, p2Name, p3Name);
      })
      .all();
  }


}
