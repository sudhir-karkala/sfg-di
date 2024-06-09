package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.controllers.PropertyInjectedController;
import guru.springframework.sfgdi.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyInjectedControllerTest {
    PropertyInjectedController propertyInjectedController;

    @BeforeEach
    void setUp() {
        propertyInjectedController = new PropertyInjectedController();
        //property injection without spring
        propertyInjectedController.greetingService = new GreetingServiceImpl();
    }

    @Test
    void sayGreeting() {
        System.out.println(propertyInjectedController.sayGreeting());
    }
}
