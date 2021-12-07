package spring.people.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;
import spring.people.dao.IPeopleDAO;
import spring.people.model.People;

import java.util.List;

@RestController
@CrossOrigin
public class PeopleController {

    @Value("${me}")
    private String me;

    private final IPeopleDAO dao;

    @Autowired
    public PeopleController(IPeopleDAO dao) {
        this.dao = dao;
    }

    @GetMapping(value = "/cestqui")
    public String getName(){
        System.out.println("coucou");
        return me;
    }

    @GetMapping(value="/people")
    public List<People> getPeople() {
        return dao.findAll();
    }

    @GetMapping(value="/people/{id}")
    public People getOnePeople(@PathVariable int id) {
        return dao.findBy_id(id);
    }

    @PutMapping(value="/people")
    public void putOnePeople(@RequestBody People people) {
         dao.save(people);
    }

    @PostMapping(value = "/people")
    public void postOnePeople(@RequestBody People people){
        dao.save(people);
    }

    @DeleteMapping(value = "/people/{id}")
    public void deleteOnePeople(@PathVariable int id) {
        dao.deleteBy_id(id);
    }


}

