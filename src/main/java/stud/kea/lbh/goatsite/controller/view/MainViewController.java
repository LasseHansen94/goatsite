package stud.kea.lbh.goatsite.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import stud.kea.lbh.goatsite.repository.GoatRepository;

import java.util.Arrays;
import java.util.List;

@Controller
public class MainViewController {

    @Autowired
    GoatRepository goatRepository;

    @GetMapping(value = "/test")
    public String tryTheTestPath(Model model, @RequestParam(value = "name") String name){
        model.addAttribute("name",  name);


        List<String> qualities = Arrays.asList("Can dance", "can run", "can sing");

        model.addAttribute("qualities", qualities);

        return "test.html";
    }

    @GetMapping(value = "/")
    public String mainMenu(){
        return "mainmenu.html";
    }

    @GetMapping(value = "/profile")
    public String getProfile(Model model, @RequestParam(value = "id") long id){
        model.addAttribute("name", goatRepository.findById(id).get().getName());
        model.addAttribute("city", goatRepository.findById(id).get().getCity());
        model.addAttribute("dob", goatRepository.findById(id).get().getDob());
        model.addAttribute("address", goatRepository.findById(id).get().getAddress());
        model.addAttribute("postnumber", goatRepository.findById(id).get().getPostnumber());
        model.addAttribute("gender", goatRepository.findById(id).get().getGender());
        model.addAttribute("username", goatRepository.findById(id).get().getUsername());
        model.addAttribute("shortdesc", goatRepository.findById(id).get().getShortDescription());
        model.addAttribute("longdesc", goatRepository.findById(id).get().getLongDescription());

        return "profile.html";
    }

    @GetMapping(value = "/match")
    public String getMatch(){
        return "match.html";
    }
}
