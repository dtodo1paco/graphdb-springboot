package org.dtodo1paco.samples.graphdb.services;

import org.dtodo1paco.samples.graphdb.database.PersonDBA;
import org.dtodo1paco.samples.graphdb.model.Person;
import org.dtodo1paco.samples.graphdb.model.projections.Person3rdGradeContacts;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class PersonService {

  private final PersonDBA db;

  public PersonService(PersonDBA db) {
    this.db = db;
  }

  public Collection<Person> find (String name) {
    return db.getRepository().findByNameLike(name);
  }

  public Collection<Person3rdGradeContacts> find3rdGradeContacts(String personNameToStart, Integer limit) {
    return db.find3rdGradeContacts(personNameToStart, limit);
  }

  @Transactional
  public List<Person> saveSomeSamples() {
    Person emil = new Person("Emil", 1987);
    Person gerrit = new Person("Gerrit", 1945);
    Person michael = new Person("Michael", 1965);
    return db.getRepository().saveAll(Arrays.asList(emil, gerrit, michael));
  }

}
