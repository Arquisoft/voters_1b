package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserInfo {
	
	private static final Logger log = LoggerFactory.getLogger(UserInfo.class);

    private String login;
    private String pass;

    public UserInfo(){
    	
    }
    
    public UserInfo(String email, String pass) {
    	log.info("Creating user " + email + ". pass: " + pass);
        this.login= email;
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }
}