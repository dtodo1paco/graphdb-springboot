package org.dtodo1paco.samples.graphdb.controllers;

import org.dtodo1paco.samples.graphdb.services.DatabaseService;
import org.dtodo1paco.samples.graphdb.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("database")
public class DatabaseController {

  @Autowired
  private DatabaseService service;

  public DatabaseController(DatabaseService service) {
    this.service = service;
  }

  @GetMapping("/drop")
  public ResponseEntity<Object> drop() {
    service.drop();
    return new ResponseEntity<>(HttpStatus.OK);
  }
  @GetMapping("/create")
  public ResponseEntity<Object> create() {
    service.create();
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

}
