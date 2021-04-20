package DataObjects.UnitTests;

import DataObjects.Inventory;
import DataObjects.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Ryan Jbaili
 */
class InventoryTest {

    @Test
    @DisplayName("Add Item to Inventory")
    void add_item() {
        Inventory inventory = new Inventory();
        Product banana = new Product("banana",50,50,"Yellow Banana");
        inventory.add_item(banana,5);
        assertEquals(inventory.getProduct(0),banana);
        assertEquals(inventory.getStock(0),5);

    }

    @Test
    @DisplayName("Remove an Item from Inventory")
    void remove_item() {
        Inventory inventory = new Inventory();
        Product banana = new Product("banana",50,50,"Yellow Banana");
        inventory.add_item(banana,5);
        inventory.remove_item(0);
        assertTrue(inventory.getList().isEmpty());
        assertTrue(inventory.getStockList().isEmpty());
    }

    @Test
    @DisplayName("Restock an Item in Inventory")
    void restock() {
        Inventory inventory = new Inventory();
        Product banana = new Product("banana",50,50,"Yellow Banana");
        inventory.add_item(banana,4);
        inventory.restock(0,1);
        assertEquals(inventory.getProduct(0),banana);
        assertEquals(inventory.getStock(0),5);
    }
}


