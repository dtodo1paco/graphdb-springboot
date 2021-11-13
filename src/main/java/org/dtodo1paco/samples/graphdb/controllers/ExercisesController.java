package org.dtodo1paco.samples.graphdb.controllers;

import org.dtodo1paco.samples.graphdb.model.projections.Person3rdGradeContacts;
import org.dtodo1paco.samples.graphdb.services.DatabaseService;
import org.dtodo1paco.samples.graphdb.services.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

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

}
