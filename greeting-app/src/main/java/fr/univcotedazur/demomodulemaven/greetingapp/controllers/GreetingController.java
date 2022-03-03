package fr.univcotedazur.demomodulemaven.greetingapp.controllers;

import fr.univcotedazur.demomodulemaven.greetingapp.interfaces.Greeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    private Greeter greeter;

    @GetMapping(path = "/")
    public ResponseEntity<String> greetVisitor() {
        return ResponseEntity.ok(greeter.greet("world"));
    }
}
