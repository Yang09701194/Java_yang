package com.example.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {


    @Value("${greeting-name: Mirage}")
    private String name;
    @Value("${greeting-coffee: ${greeting-name} is drinking Cafe Ganador }")
    private String coffee;

    private Greeting greeting;

    public GreetingController(Greeting greeting) {
        this.greeting = greeting;
    }

    @GetMapping
    String getGreeting(){
        //return name;
        return greeting.getName();
    }

    @GetMapping("/coffee")
    String getCoffee(){
//        return coffee;
        return greeting.getCoffee();
    }

}

@ConfigurationProperties(prefix="greeting")
class Greeting{
    private String name;
    private String coffee;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getCoffee(){
        return coffee;
    }
    public void setCoffee(String coffee){
        this.coffee = coffee;
    }

}


@RestController
@RequestMapping("/droid")
class DroidController
{
    private final com.example.app.Droid droid;

    public DroidController(com.example.app.Droid droid) {
        this.droid = droid;
    }

    @GetMapping
    com.example.app.Droid getDroid(){
        return droid;
    }

}
