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
     * @param item Product variable of item to be added
     * @param quantity integer quantity of item to be added
     * invariant: added item remains the same
     * precondition: Valid product and quantity passed
     * postcondition: quantity is appended to stock and proudct is appended into items
     */
    public void add_item(Product item, int quantity){
        items.add(item);
        stock.add(quantity);
    }

    /**
     * @param index current integer index of item to be removed
     * precondition: valid index is passed
     * postcondition: item is removed from items, quantity is removed from stock
     */
    public void remove_item(int index){
        items.remove(index);
        stock.remove(index);
    }

    /**
     * @param index the integer index of the item to restock
     * @param amount the integer amount to be restocked
     * precondition: Valid index and amount passed
     * postcondition: stock is increased by amount
     */
    public void restock(int index, int amount){
        stock.set(index,stock.get(index)+amount);
    }

    /**
     * @param index the integer index of the item to sold from inventory
     * @param amount the integer amount to be restocked
     * precondition: Valid index and amount passed
     * postcondition: stock is either set to 0 if amount exceeds stock index or stock is decreased by amount
     * @return true or false
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
     * @param x the double for which cost will be set to
     * precondition: valid input
     * postcondition: cost is set to input
     */
    public void setCost(double x){
        cost = x;
    }

    /**
     * @param x the double for which revenue will be set to
     * precondition: valid input
     * postcondition: revenue is set to input
     */
    public void setRevenue(double x){
        revenue = x;
    }

    /**
     * invariant: cost remains unchanged
     * postcondition: @return cost is returned
     * @return cost
     */
    public double getCost(){
        return cost;
    }

    /**
     * invariant: revenue remains unchanged
     * postcondition: @return revenue is returned
     * @return revenue
     */
    public double getRevenue(){
        return revenue;
    }

    /**
     * @param index the integer index of the product inside items
     * invariant: items remains unchanged, product remains unchanged
     * precondition: valid input
     * postcondition: indexed product is returned
     * @return product at index
     */
    public Product getProduct(int index){
        return items.get(index);
    }

    /**
     * invariant: items remains unchanged
     * postcondition: @return items is returned
     * @return items
     */
    public ArrayList<Product> getList(){return items;}

    /**
     * invariant: stock remains unchanged
     * postcondition: @return stock is returned
     * @return stock
     */
    public ArrayList<Integer> getStockList(){return stock;}

    /**
     * @param index the integer index of the product inside items
     * invariant: stock remains unchanged, indexed stock remains unchanged
     * postcondition: @return stock index is returned
     * @return quantity at index
     */
    public int getStock(int index){
        return stock.get(index);
    }









}
