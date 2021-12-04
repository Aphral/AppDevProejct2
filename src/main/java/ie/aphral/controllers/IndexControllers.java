package ie.aphral.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexControllers {
    @GetMapping("/")
    public String index( Model model){
        return "index";
    }

    @GetMapping("/{firstname}")
    public String indexPath( Model model){
        return "index";
    }

    @PostMapping("/")
    public String indexPost(){
        return "index";
    }
}
