package org.dtodo1paco.samples.graphdb.controllers;

import org.dtodo1paco.samples.graphdb.model.Person;
import org.dtodo1paco.samples.graphdb.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController()
@RequestMapping("person")
public class PersonController {

  @Autowired
  private PersonService service;

  public PersonController(PersonService service) {
    this.service = service;
  }

  @GetMapping("/")
  public Collection<Person> find(@RequestParam(value = "name", defaultValue = "") String name) {
    return service.find(name);
  }

}
