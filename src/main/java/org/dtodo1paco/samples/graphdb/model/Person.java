package org.dtodo1paco.samples.graphdb.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@Node
public class Person {
  @Id @GeneratedValue
  private Long id;

  private String name;
  private Integer born;

  public Person(String name, Integer born) {
    this.born = born;
    this.name = name;
  }
}
