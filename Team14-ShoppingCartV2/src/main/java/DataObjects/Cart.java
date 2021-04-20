package DataObjects;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Ryan Jbaili
 */
public class Cart implements Serializable {
    private ArrayList<Product> items;
    private ArrayList<Integer> quantity;
    int selected_item;
    int totalCost;
    double totalInv;

    public Cart(){
        items = new ArrayList<Product>();
        quantity = new ArrayList<Integer>();
        selected_item = 0;
    }

    /**
     * @param index the index of the item to add from inventory
     * @param available inventory object
     * precondition:  valid index and inventory provided
     * postcondition: item from inventory is added to cart and removed from inventory quantity, totalcost is updated accordingly
     */
    public void add(int index,Inventory available){
        if(available.sell(index,1)) {
            items.add(available.getProduct(index));
            totalCost += available.getProduct(index).getSellPrice();
            totalInv += available.getProduct(index).getInvPrice();
            System.out.println("Added " + available.getProduct(index).getID() + " to cart!");
            System.out.println("Total cost: " + totalCost);
        }else{
            System.out.println("Out of Stock!");
        }
    }

    /**
     * @param index the index of the item to add from inventory
     * @param inventory inventory object
     * precondition: valid index and inventory provided
     * postcondition: product is removed from cart and added back to inventory, updating the quantity of the product removed
     */
    public void remove(int index,Inventory inventory){
        totalCost-=items.get(index).getSellPrice();
        String restockID = items.get(index).getID();
        items.remove(index);
        boolean restocked = false;
        int i = 0;
        while(!restocked) {
            if(restockID.equals(inventory.getProduct(i).getID())) {
                inventory.restock(i, 1);
                restocked = true;
            }
            i++;
        }
    }

    /**
     * postcondition: items, quantity, and totalCost are all reset
     */
    public void clearCart(){
        items = new ArrayList<Product>();
        quantity = new ArrayList<Integer>();
        totalCost = 0;
    }

    /**
     * invariant: totalCost remains unchanged
     * postcondition: @return returns totalCost
     * @return totalCost;
     */
    public int getTotalCost(){
        return totalCost;
    }

    /**
     * invariant: totalInv remains unchanged
     * postcondition: @return returns totalInv
     * @return totalInv
     */
    public double getTotalInv() { return totalInv; }

    /**
     * invariant: items remains unchanged
     * postcondition: @return items is returned
     * @return items
     */
    public ArrayList<Product> getProductList(){
        return items;
    }

    /**
     * invariant: quantity remains unchanged
     * postcondition: @return quantity is returned
     * @return quantity
     */
    public ArrayList<Integer> getQuantityList(){
        return quantity;
    }



}
