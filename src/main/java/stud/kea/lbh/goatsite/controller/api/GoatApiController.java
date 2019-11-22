package stud.kea.lbh.goatsite.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stud.kea.lbh.goatsite.model.Gender;
import stud.kea.lbh.goatsite.model.Goat;
import stud.kea.lbh.goatsite.repository.GoatRepository;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class GoatApiController {

    @Autowired
    private GoatRepository goatRepository;
    
    @GetMapping("/goats")
    public Iterable<Goat> viewGoatList(){
        return goatRepository.findAll();
    }

    @PostMapping("/goats")
    public Goat createGoat(@Valid @RequestBody Goat goat){
        return goatRepository.save(goat);
    }

    @GetMapping("goats/findbyname")
    public Goat getGoatsByName(@RequestParam(value = "name") String name){
        return goatRepository.findByName(name);
    }

    @GetMapping("goats/findIdByUserName")
    public int findIdByUserName(@RequestParam(value = "username") String username) {
        return goatRepository.findIdByUsername(username);}

    @GetMapping("goats/findbygender")
    public Iterable<Goat> getGoatByGender(@RequestParam(value = "gender") Gender gender){
        return goatRepository.findByGender(gender);
    }

    @GetMapping("/goats/{id}")
    public Goat findGoat(@PathVariable long id){
        /*
        Optional goatOrNull = goatRepository.findById(id);
        if(goatOrNull.isPresent()){
            return goatOrNull.get();
        }
        return "404 - goat not found";
        */

        return goatRepository.findById(id).orElse(null);
    }

    // todo jeg vil gerne sende en ? til alle med id under ?
    @GetMapping("/goats/oldtimers")
    public Iterable<Goat> getOldTimers(){
        return goatRepository.findTheOldTimers();
    }


}
