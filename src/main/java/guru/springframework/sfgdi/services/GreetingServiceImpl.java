package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {
    public String sayGreeting() {
        return "Hello World!";
    }
}
