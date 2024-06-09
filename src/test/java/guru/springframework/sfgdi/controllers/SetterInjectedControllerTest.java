package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetterInjectedControllerTest {
    SetterInjectedController setterInjectedController;

    @BeforeEach
    void setUp () {
        setterInjectedController = new SetterInjectedController();
        //setter injection without spring
        setterInjectedController.setGreetingService(new GreetingServiceImpl());
    }

    @Test
    void sayGreeting() {
        System.out.println(setterInjectedController.sayGreeting());
    }
}