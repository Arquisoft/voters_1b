package hello;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//controlador para la parte por Consola

@RestController
public class Controller {

    
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public UserInfo update(@RequestBody UserInfo car) {

        if (car != null) {
          //aqui mediante el objeto car busco en la base si existe
        	
        }

        return car;
    }	
}
