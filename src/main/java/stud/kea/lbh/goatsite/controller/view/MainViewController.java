package stud.kea.lbh.goatsite.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainViewController {
    @GetMapping(value = "/test")
    public String tryTheThestPath(Model model, @RequestParam(value = "name") String name){
        model.addAttribute("name",  name);


        List<String> qualities = Arrays.asList("Can dance", "can run", "can sing");

        model.addAttribute("qualities", qualities);

        return "test.html";
    }

    @GetMapping(value = "/mainmenu")
    public String mainMenu(){
        return "mainmenu.html";
    }
}
