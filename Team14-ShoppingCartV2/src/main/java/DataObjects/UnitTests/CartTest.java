package DataObjects.UnitTests;

import DataObjects.Cart;
import DataObjects.Inventory;
import DataObjects.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Ryan Jbaili
 */
class CartTest {

    @Test
    @DisplayName("Add to Cart")
    void add() {
        Inventory inventory = new Inventory();
        Product banana = new Product("banana",25,50,"Yellow Banana");
        inventory.add_item(banana,5);
        Cart myCart = new Cart();
        myCart.add(0,inventory);
        assertEquals(inventory.getProduct(0),myCart.getProductList().get(0));
        assertEquals(50,myCart.getTotalCost());
        assertEquals(25,myCart.getTotalInv());
    }

    @Test
    @DisplayName("Remove From Cart")
    void remove() {
        Inventory inventory = new Inventory();
        Product banana = new Product("banana",50,50,"Yellow Banana");
        inventory.add_item(banana,5);
        Cart myCart = new Cart();
        myCart.add(0,inventory);
        myCart.remove(0,inventory);
        assertTrue(myCart.getProductList().isEmpty());
        assertEquals(0,myCart.getTotalCost());
        assertEquals(0,myCart.getTotalCost());
    }

    @Test
    @DisplayName("Clear Cart")
    void clearCart() {
        Inventory inventory = new Inventory();
        Product banana = new Product("banana",25,50,"Yellow Banana");
        inventory.add_item(banana,5);
        Product phone = new Product("phone",100,300,"IPhone10");
        inventory.add_item(phone,5);
        Cart myCart = new Cart();
        myCart.add(0,inventory);
        myCart.add(1,inventory);
        myCart.clearCart();
        assertTrue(myCart.getProductList().isEmpty());
        assertEquals(0,myCart.getTotalCost());
        assertEquals(0,myCart.getTotalCost());
    }
}