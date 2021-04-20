package DataObjects;

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

    /**
     * invariant: username remains unchanged
     * postcondition: username is returned
     */
    public String getUsername(){return username;}

    /**
     * invariant: password remains unchanged
     * postcondition: password is returned
     */
    public String getPassword(){return password;}

    /**
     * precondition: valid index and inventory provided
     * postcondition: product is added into shoppingCart
     */
    public void addToCart(int index,Inventory inventory){
        shoppingCart.add(index,inventory);
    }

    /**
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
     * postcondition: wishlist is returned
     */
    public ArrayList<Product> getWishlist(){
        return wishlist;
    }

    /**
     * invariant: shoppingCart remains unchanged
     * postcondition: shoppingCart is returned
     */
    public Cart getCart(){return shoppingCart;}

}
