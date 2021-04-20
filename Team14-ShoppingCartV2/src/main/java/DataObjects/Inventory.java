package DataObjects;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * @author Ryan Jbaili
 */
public class Inventory implements Serializable {
    private ArrayList<Product>items;
    private ArrayList<Integer> stock;
    private double cost;
    private double revenue;

    public Inventory(){
        items = new ArrayList<Product>();
        stock = new ArrayList<Integer>();
        cost = 0;
        revenue = 0;
    }

    /**
     * invariant: added item remains the same
     * precondition: Valid product and quantity passed
     * postcondition: quantity is appended to stock and proudct is appended into items
     */
    public void add_item(Product item, int quantity){
        items.add(item);
        stock.add(quantity);
    }

    /**
     * precondition: valid index is passed
     * postcondition: item is removed from items, quantity is removed from stock
     */
    public void remove_item(int index){
        items.remove(index);
        stock.remove(index);
    }

    /**
     * precondition: Valid index and amount passed
     * postcondition: stock is increased by amount
     */
    public void restock(int index, int amount){
        stock.set(index,stock.get(index)+amount);
    }

    /**
     * precondition: Valid index and amount passed
     * postcondition: stock is either set to 0 if amount exceeds stock index or stock is decreased by amount
     */
    public boolean sell(int index, int amount){
        if(stock.get(index)<amount){
            stock.set(index,0);
            return false;
        }else{
            stock.set(index,stock.get(index)-amount);
            return true;
        }
    }

    /**
     * precondition: valid input
     * postcondition: cost is set to input
     */
    public void setCost(double x){
        cost = x;
    }

    /**
     * precondition: valid input
     * postcondition: revenue is set to input
     */
    public void setRevenue(double x){
        revenue = x;
    }

    /**
     * invariant: cost remains unchanged
     * postcondition: cost is returned
     */
    public double getCost(){
        return cost;
    }

    /**
     * invariant: revenue remains unchanged
     * postcondition: revenue is returned
     */
    public double getRevenue(){
        return revenue;
    }

    /**
     * invariant: items remains unchanged, product remains unchanged
     * precondition: valid input
     * postcondition: indexed product is returned
     */
    public Product getProduct(int index){
        return items.get(index);
    }

    /**
     * invariant: items remains unchanged
     * postcondition: items is returned
     */
    public ArrayList<Product> getList(){return items;}

    /**
     * invariant: stock remains unchanged
     * postcondition: stock is returned
     */
    public ArrayList<Integer> getStockList(){return stock;}

    /**
     * invariant: stock remains unchanged, indexed stock remains unchanged
     * postcondition: stock index is returned
     */
    public int getStock(int index){
        return stock.get(index);
    }









}
