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
    public void addToCart(int index,Inventory inventory){
        shoppingCart.add(index,inventory);
    }
    public int getTotalCost(){
        return shoppingCart.getTotalCost();
    }
    public void addToWishlist(Product item){
        wishlist.add(item);
        System.out.println("Added " + item.getID() + " to wishlist!");
    }
    public ArrayList<Product> getWishlist(){
        return wishlist;
    }

}
