package com.example.coffee;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
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



class Droid {

    public String id, description;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return id;
    }
    public void setDescription(String description) {
        this.description = description;
    }


}


@RestController
@RequestMapping("/droid")
class DroidController
{
    private final Droid droid;

    public DroidController(Droid droid) {
        this.droid = droid;
    }

    @GetMapping
    Droid getDroid(){
        return droid;
    }

}
