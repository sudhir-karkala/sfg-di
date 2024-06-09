package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.controllers.ConstructorInjectedController;
import guru.springframework.sfgdi.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConstructorInjectedControllerTest {
    ConstructorInjectedController constructorInjectedController;

    @BeforeEach
    void setUp () {
        //constructor injection without spring
        constructorInjectedController = new ConstructorInjectedController(new GreetingServiceImpl());
    }

    @Test
    void sayGreeting() {
        System.out.println(constructorInjectedController.sayGreeting());
    }
}
