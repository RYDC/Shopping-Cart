import java.util.ArrayList;

public class Customer {
    private String username,password;
    private ArrayList<Product> wishlist;
    private Cart shoppingCart;



    public Customer(String u, String p) {
        username = u;
        password = p;
        shoppingCart = new Cart();
        wishlist = new ArrayList<Product>();

    }

    public void setUsername(String u){
        username = u;
    }
    public void setPassword(String p){
        password = p;
    }
    public String getUsername(){return username;}
    public String getPassword(){return password;}

}