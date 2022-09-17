package com.example.app;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;
import java.util.Optional;
import java.util.UUID;



@Component
class DataLoader{
    private final CoffeeRepository coffeeRepository;
    public DataLoader(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @PostConstruct
    void loadData(){
        coffeeRepository.saveAll(List.of(new Coffee("Cereza"), new Coffee("Ganador"), new Coffee("Lareno"),new Coffee("Tres Pontas")));
    }

}


@RestController
@CrossOrigin(origins = "localhost:8080")
@RequestMapping("/coffees")
public class RestApiCoffeeController {


    //private List<Coffee> coffees = new ArrayList<>();
    private final CoffeeRepository coffeeRepository;

    public RestApiCoffeeController (CoffeeRepository coffeeRepository){
        this.coffeeRepository = coffeeRepository;
        //coffees.addAll(List.of(new Coffee("Cereza"), new Coffee("Ganador"), new Coffee("Lareno"),new Coffee("Tres Pontas")));
    }

    //@RequestMapping(value = "/coffees", method = RequestMethod.GET)
    //@GetMapping("/coffees")
    @GetMapping
    @CrossOrigin(origins = "localhost:8080")
    Iterable<Coffee> getCoffees(){
//        return coffees;
        return coffeeRepository.findAll();
    }

    //	@GetMapping("/coffees/{id}")
    @GetMapping("/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id){
//        for(Coffee c: coffees){
//            if(c.getId().equals(id)){
//                return Optional.of(c);
//            }
//        }
//        return Optional.empty();
        return coffeeRepository.findById(id);
    }

    //@PostMapping("/coffees")
    @PostMapping
    Coffee postCoffee(@RequestBody Coffee coffee){
//        coffees.add(coffee);
//        return coffee;
        return coffeeRepository.save(coffee);
    }

    //	@PutMapping("/coffees/{id}")
    @PutMapping("/{id}")
//	Coffee putCoffee(@PathVariable String id, @RequestBody Coffee coffee){
    ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee){
//        int coffeeIndex = -1;
//
//        for(Coffee c: coffees){
//            if(c.getId().equals(id)){
//                coffeeIndex = coffees.indexOf(c);
//                coffees.set(coffeeIndex, coffee);
//            }
//        }
////		return (coffeeIndex == -1) ? postCoffee(coffee) : coffee;
//        return (coffeeIndex == -1) ? new ResponseEntity<>(postCoffee(coffee), HttpStatus.CREATED)
//                : new ResponseEntity<>(coffee, HttpStatus.OK);

        return !coffeeRepository.existsById(id) ? new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.CREATED)
                : new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.OK);

    }

    //	@DeleteMapping("/coffees/{id}")
    @DeleteMapping("/{id}")
    void deleteCoffee(@PathVariable String id){
//        coffees.removeIf(c -> c.getId().equals(id));
        coffeeRepository.deleteById(id);
    }


}


interface CoffeeRepository extends CrudRepository<Coffee, String> {};

@Entity
class Coffee{
    @Id
    private String id;
    private String name;

    public Coffee() {
    }

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

