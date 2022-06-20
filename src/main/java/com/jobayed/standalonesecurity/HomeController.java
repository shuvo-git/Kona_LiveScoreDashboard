package com.jobayed.standalonesecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/home")
    public String getHome(){
        return "This is Home";
    }

    @GetMapping("/admin")
    public String getAdmin(){
        return "This is Admin";
    }
}
