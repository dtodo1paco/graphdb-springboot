package org.dtodo1paco.samples.graphdb.controllers;

import org.dtodo1paco.samples.graphdb.model.projections.ItemProperties;
import org.dtodo1paco.samples.graphdb.model.projections.Person3rdGradeContacts;
import org.dtodo1paco.samples.graphdb.services.DatabaseService;
import org.dtodo1paco.samples.graphdb.services.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController()
@RequestMapping("exercises")
public class ExercisesController {

  private PersonService personService;
  private DatabaseService db;

  public ExercisesController(PersonService personService, DatabaseService dbService) {
    this.personService = personService;
    this.db = dbService;
  }

  @GetMapping("/section_03/exercise_01")
  public Collection<Person3rdGradeContacts> find3rdGradeContacts(
    @RequestParam(value = "limit", defaultValue = "3") Integer limit) {
    return personService.find3rdGradeContacts(null, limit);
  }
  @GetMapping("/section_03/exercise_01_addenda")
  public Collection<Person3rdGradeContacts> find3rdGradeContacts(
    @RequestParam(value = "personNameToStart", defaultValue = "") String personNameToStart,
    @RequestParam(value = "limit", defaultValue = "3") Integer limit) {
    return personService.find3rdGradeContacts(personNameToStart, limit);
  }

  @GetMapping("/section_03/exercise_02")
  public Collection<ItemProperties> findMoviesThatContactDirected(
    @RequestParam(value = "limit", defaultValue = "3") Integer limit) {
    String query = "MATCH (p1:Person)-[:HAS_CONTACT]-(p2) " +
      "OPTIONAL MATCH (p2)-[:DIRECTED]->(m)"+
       "RETURN p1.name as person, p2.name as director, m.title as movieTitle";
    return db.findItems(query, null, limit);
  }

  @GetMapping("/section_04/exercise_01")
  public Collection<ItemProperties> findTomHankContactsBornAfter1960AndEarntOver10MIn1Movie(
    @RequestParam(value = "limit", defaultValue = "3") Integer limit) {
    String query = "MATCH (tom:Person{name: 'Tom Hanks'}) "
      + "MATCH (tom)-[:HAS_CONTACT]->(contact:Person) "
      + "MATCH (contact)-[role:ACTED_IN]->(movie:Movie) "
      + "WHERE contact.born >= 1960 AND role.earnings > 10000000 "
      + "RETURN contact.name, contact.born, movie.title, role.earnings ";
    return db.findItems(query, null, limit);
  }

  @GetMapping("/section_04/exercise_01_addenda")
  public Collection<ItemProperties> findActorContactsBornAfterYearAndEarntOverAmountIn1Movie(
    @RequestParam(value = "name", defaultValue = "Tom Hanks") String name,
    @RequestParam(value = "year", defaultValue = "1960") Integer year,
    @RequestParam(value = "earnings", defaultValue = "10000000") Long earnings,
    @RequestParam(value = "limit", defaultValue = "3") Integer limit) {
    String query = "MATCH (actor:Person{name: $name}) "
                     + "MATCH (actor)-[:HAS_CONTACT]->(contact:Person) "
                     + "MATCH (contact)-[role:ACTED_IN]->(movie:Movie) "
                     + "WHERE contact.born >= $year AND role.earnings > $earnings "
                     + "RETURN contact.name, contact.born, movie.title, role.earnings ";
    Map<String, Object> params = new HashMap<>();
    params.put("name", name);
    params.put("year", year);
    params.put("earnings", earnings);
    return db.findItems(query, params, limit);
  }

}
