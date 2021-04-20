import DataObjects.Inventory;
import DataObjects.Product;
import org.junit.jupiter.api.Test;


class InventoryTest {

    @Test
    void add_item() {
        Inventory inventory = new Inventory();
        inventory.add_item(new Product("banana",50,50,"Yellow Banana"),5);


    }

    @Test
    void restock() {
    }
}


