package DataObjects.UnitTests;

import DataObjects.Customer;
import DataObjects.Inventory;
import DataObjects.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Ryan Jbaili
 */
class CustomerTest {

    @Test
    void addToCart() {
        Customer customer = new Customer("username","password");
        Inventory inventory = new Inventory();
        Product banana = new Product("banana",50,50,"Yellow Banana");
        inventory.add_item(banana,5);
        customer.addToCart(0,inventory);
        assertEquals(banana,customer.getCart().getProductList().get(0));
    }

    @Test
    void addToWishlist() {
        Customer customer = new Customer("username","password");
        Product banana = new Product("banana",50,50,"Yellow Banana");
        customer.addToWishlist(banana);
        assertEquals(banana,customer.getWishlist().get(0));
    }
}