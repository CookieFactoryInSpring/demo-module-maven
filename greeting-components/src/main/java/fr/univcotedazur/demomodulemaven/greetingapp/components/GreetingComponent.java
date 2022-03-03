package fr.univcotedazur.demomodulemaven.greetingapp.components;

import fr.univcotedazur.demomodulemaven.greetingapp.interfaces.Greeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GreetingComponent implements Greeter {

    @Autowired
    DummyComponent dummyComponent;

    @Override
    public String greet(String visitor) {
        return String.format("Hello %s !", visitor);
    }
}
