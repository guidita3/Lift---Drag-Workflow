package Logic;

/**
 * Data structure to store the info related with the user.
 * @author Joan Francesc
 * @author Miguel Angel Grimaldos 
 * @author Margarida Pereira
 * @author Marta Vitores
 */
public class compUser {
    private String username;
    private String password;
    private String salt;
    
    /**
     * Standard constructor
     */
    public compUser(){
        username = null;
        password = null;
        salt = null;
    }
    
    /**
     * Alternative constructor. It is created with the data given as parameters.
     * @param username Nickname picked by the user
     * @param password User password
     * @param salt Salt for making more secure the password storage
     */
    public compUser(String username, String password, String salt){
        this.username = username;
        this.password = password;
        this.salt = salt;
    }
    
    public String getSalt(){
        return salt;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
}
