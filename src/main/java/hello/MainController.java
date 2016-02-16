package hello;


import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Controller
public class MainController {
	
	UserInfo user;
	@Autowired
    DBManager repository;
 
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String greetingForm(Model model) {
    	//user=new UserInfo("bla","000", "bla", "24252627W", 2535);
        model.addAttribute("userinfo", new UserInfo());
        return "greeting";
    }
    
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute UserInfo greeting, Model model, HttpSession sesion) {
  
    	model.addAttribute("userinfo", greeting);
    	
    	try{
    		List<UserInfo> users=repository.findByLogin(greeting.getLogin());
        	
        	if (users!=null){
        		UserInfo usuario=users.get(0);
        		if(usuario.getPass().equals(greeting.getPass())){
        			sesion.setAttribute("login", greeting.getLogin());
        			return "result";
        			
        		}else{
        	        throw new HTTP404Exception();  
        		}
        	}
        	}catch(IndexOutOfBoundsException e){
                throw new HTTP404Exception();  
        	}
    	
        return "result";
    }
    
    @RequestMapping(value="/cambiar-clave", method=RequestMethod.GET)
    public String cambiarClave(Model model) {
    	model.addAttribute("cambiarClave", new CambiarClave());
    	return "cambiar-clave";
    }
    
    @RequestMapping(value="/cambiar-clave", method=RequestMethod.POST)
    public String cambiarClaveSubmit(@Valid @ModelAttribute CambiarClave cambiarClave, BindingResult br, HttpSession sesion) {
    	
    	if (br.hasErrors()) {
    		return "cambiar-clave";
    	}
    	else {
    		
    		String login = (String)sesion.getAttribute("login");
    		br.addError(new FieldError("cambiarClave", "claveAnterior", "Clave anterior mal"));
    		System.out.println(login + " " + cambiarClave.getClaveAnterior() + " " + cambiarClave.getClaveNueva() + " " + cambiarClave.getConfirmacionClave());
	    	return "redirect:/";
    	}
    }

}