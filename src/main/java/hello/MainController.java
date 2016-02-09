package hello;


import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bd.DBManager;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class MainController {
	
	UserInfo user;

    @RequestMapping("/user")
    public UserInfo user() {
    	user=new UserInfo("pepe@gmail.com","0000", "pepe", "50505050Y", 2535);
        return user;
    }

 
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String greetingForm(Model model) {
    	user=new UserInfo("bla","000", "bla", "24252627W", 2535);
        model.addAttribute("greeting", user);
        return "greeting";
    }
    
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute UserInfo greeting, Model model) {
  
    	model.addAttribute("greeting", greeting);
        return "result";
    }

}