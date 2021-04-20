package DataObjects;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * @author Ryan Jbaili
 */
public class Customer implements Serializable {
    private String username,password;
    private ArrayList<Product> wishlist;
    private Cart shoppingCart;



    public Customer(String u, String p) {
        username = u;
        password = p;
        shoppingCart = new Cart();
        wishlist = new ArrayList<Product>();

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

    /**
     * @param index the index of the item to add from inventory
     * @param inventory inventory object
     * precondition: valid index and inventory provided
     * postcondition: product is added into shoppingCart
     */
    public void addToCart(int index,Inventory inventory){
        shoppingCart.add(index,inventory);
    }

    /**
     * @param item Product object of the product to be added
     * invariant: product remains unchanged
     * precondition: valid product inputted
     * postcondition: product is added to wishlist
     */
    public void addToWishlist(Product item){
        wishlist.add(item);
        System.out.println("Added " + item.getID() + " to wishlist!");
    }

    /**
     * invariant: wishlist remains unchanged
     * postcondition: @return wishlist is returned
     * @return wishlist
     */
    public ArrayList<Product> getWishlist(){
        return wishlist;
    }

    /**
     * invariant: shoppingCart remains unchanged
     * postcondition: @return shoppingCart is returned
     * @return shoppingCart
     */
    public Cart getCart(){return shoppingCart;}

}
