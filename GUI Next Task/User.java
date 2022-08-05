import java.lang.*;
import java.awt.event.*;


public class User{
    
    //attributes
    private String username;
    private String password;

    //parameterized constructor initializing
    public User(String username,
                String password){
                    this.username=username;
                    this.password=password;
    }

    //get methods
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }



}
