package fr.univcotedazur.demomodulemaven.greetingapp;

import fr.univcotedazur.demomodulemaven.greetingapp.interfaces.Greeter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.nio.charset.StandardCharsets;
import java.util.Random;

@SpringBootTest
@ContextConfiguration(classes = GreetingComponentConfiguration.class)
public class GreetingComponentTest {

    @Autowired
    private Greeter greeter;

    @Test
    public void greetARandomUserTest() {
        byte[] array = new byte[6];
        new Random().nextBytes(array);
        String randomVisitor = new String(array, StandardCharsets.UTF_8);
        System.out.println(String.format("Visitor is : %s", randomVisitor));
        assertEquals(String.format("Hello %s !", randomVisitor), greeter.greet(randomVisitor));
    }

}
