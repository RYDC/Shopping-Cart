package DataObjects;

import java.io.Serializable;

/**
 * @author Ryan Jbaili
 */
public class Seller implements Serializable {
    private String username,password;

    public Seller(String u, String p) {
        username = u;
        password = p;
    }

    /**
     * invariant: username remains unchanged
     * postcondition: @return username is returned
     * @return username
     */
    public String getUsername(){return username;}

    /**
     * invariant: password remains unchanged
     * postcondition: @return password is returned
     * @return password
     */
    public String getPassword(){return password;}

}
