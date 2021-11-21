package spring.tp4.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.tp4.dao.IPeopleDAO;
import spring.tp4.model.People;

import java.util.List;

@RestController
@CrossOrigin
public class PeopleController {

    private final IPeopleDAO dao;

    @Autowired
    public PeopleController(IPeopleDAO dao) {
        this.dao = dao;
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
