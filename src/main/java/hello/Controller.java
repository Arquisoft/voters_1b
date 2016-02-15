package hello;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//controlador para la parte por Consola

@RestController
public class Controller {
	
	
	@Autowired
    DBManager repository;
    
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public UserInfo update(@RequestBody UserInfo car) {
    	
    	
    	Integer pollingStationCode;

        if (car != null) {
          //aqui mediante el objeto car busco en la base si existe
        	try{
        	List<UserInfo> users=repository.findByLogin(car.getLogin());
        	
        	if (users!=null){
        		UserInfo usuario=users.get(0);
        		if(usuario.getPass().equals(car.getPass())){
        			pollingStationCode=usuario.getPollingStationCode();
        			car=usuario;
        			System.out.print(pollingStationCode);
        			return car;
        			
        		}else{
        			return null;
        		}
        	}
        	}catch(IndexOutOfBoundsException e){
        		
        	}
        	
        }
        return null;
       
    }	
}
