package fr.univcotedazur.demomodulemaven.greetingapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping(path = "/")
    public ResponseEntity<String> greetVisitor() {
        return ResponseEntity.ok("Hello world !");
    }
}
