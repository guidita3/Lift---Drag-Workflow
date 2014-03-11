package Logic;

/**
 * Data structure to store the info related with the user.
 * @author Miguel Angel Grimaldos
 */
public class compUser {
    private int userId;
    private String username;
    private String password;
    
    /**
     * Standard constructor
     */
    public compUser(){
        userId = -1;
        username = null;
        password = null;
    }
    
    /**
     * Alternative constructor. It is created with the data given as parameters.
     * @param userId Number assigned to a user in order to identify him/her
     * @param username Nickname picked by the user
     * @param password User password
     */
    public compUser(int userId, String username, String password){
        this.userId = userId;
        this.username = username;
        this.password = password;
    }
    
    public double getUserId(){
        return userId;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
}
