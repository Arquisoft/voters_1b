package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class UserInfo {
	
	private static final Logger log = LoggerFactory.getLogger(UserInfo.class);

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String login;
    private String pass;
    private String name;
    private String nif;
    private Integer pollingStationCode;

    public UserInfo(){
    	
    }
    
    public UserInfo(String email, String pass, String name, String nif, Integer pollingStationCode) {
    	log.info("Creating user " + email + ". pass: " + pass);
        this.login= email;
        this.pass = pass;
        this.name=name;
        this.nif=nif;
        this.pollingStationCode=pollingStationCode;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }
    
    public static Logger getLog() {
		return log;
	}

	public String getName() {
		return name;
	}

	public String getNif() {
		return nif;
	}

	public Integer getPollingStationCode() {
		return pollingStationCode;
	}

	public void changePassword(String pass){
    	this.pass=pass;
    }

	@Override
	public String toString() {
		return "UserInfo [login=" + login + ", pass=" + pass + ", name=" + name + ", nif=" + nif
				+ ", pollingStationCode=" + pollingStationCode + "]";
	}
	
	
}