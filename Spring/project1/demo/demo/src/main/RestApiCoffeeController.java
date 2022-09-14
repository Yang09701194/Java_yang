package com.example.coffee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "localhost:8080")
@RequestMapping("/coffees")
public class RestApiCoffeeController {
    private List<Coffee> coffees = new ArrayList<>();

    public RestApiCoffeeController (){
        coffees.addAll(List.of(new Coffee("Cereza"), new Coffee("Ganador"), new Coffee("Lareno"),new Coffee("Tres Pontas")));
    }

    //@RequestMapping(value = "/coffees", method = RequestMethod.GET)
    //@GetMapping("/coffees")
    @GetMapping
    @CrossOrigin(origins = "localhost:8080")
    Iterable<Coffee> getCoffees(){
        return coffees;
    }

    //	@GetMapping("/coffees/{id}")
    @GetMapping("/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id){
        for(Coffee c: coffees){
            if(c.getId().equals(id)){
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }

    //@PostMapping("/coffees")
    @PostMapping
    Coffee postCoffee(@RequestBody Coffee coffee){
        coffees.add(coffee);
        return coffee;
    }

    //	@PutMapping("/coffees/{id}")
    @PutMapping("/{id}")
//	Coffee putCoffee(@PathVariable String id, @RequestBody Coffee coffee){
    ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee){
        int coffeeIndex = -1;

        for(Coffee c: coffees){
            if(c.getId().equals(id)){
                coffeeIndex = coffees.indexOf(c);
                coffees.set(coffeeIndex, coffee);
            }
        }

//		return (coffeeIndex == -1) ? postCoffee(coffee) : coffee;
        return (coffeeIndex == -1) ? new ResponseEntity<>(postCoffee(coffee), HttpStatus.CREATED)
                : new ResponseEntity<>(coffee, HttpStatus.OK);
    }

    //	@DeleteMapping("/coffees/{id}")
    @DeleteMapping("/{id}")
    void deleteCoffee(@PathVariable String id){
        coffees.removeIf(c -> c.getId().equals(id));
    }


}


class Coffee{
    private final String id;
    private String name;

    public Coffee(String id, String name){
        this.id = id;
        this.name = name;
    }

    public Coffee(String name){
        this(UUID.randomUUID().toString(), name);
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}