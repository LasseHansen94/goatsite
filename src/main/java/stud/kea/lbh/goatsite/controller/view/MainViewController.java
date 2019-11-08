package stud.kea.lbh.goatsite.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import stud.kea.lbh.goatsite.controller.api.GoatApiController;
import stud.kea.lbh.goatsite.repository.GoatRepository;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainViewController {
    @GetMapping(value = "/test")
    public String tryTheTestPath(Model model, @RequestParam(value = "name") String name){
        model.addAttribute("name",  name);


        List<String> qualities = Arrays.asList("Can dance", "can run", "can sing");

        model.addAttribute("qualities", qualities);

        return "test.html";
    }

    @GetMapping(value = "/myprofile")
    public String myProfile(){
        return "myprofile.html";
    }

    @GetMapping(value = "/mainmenu")
    public String mainMenu(){
        return "mainmenu.html";
    }
}
