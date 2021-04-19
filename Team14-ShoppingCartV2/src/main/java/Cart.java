import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> items;
    private ArrayList<Integer> quantity;
    int selected_item;
    int totalCost;

    public Cart(){
        items = new ArrayList<Product>();
        quantity = new ArrayList<Integer>();
        selected_item = 0;
    }

    public void add(int index,Inventory available){
        if(available.sell(index,1)) {
            items.add(available.getProduct(index));
            totalCost += available.getProduct(index).getSellPrice();
            System.out.println("Added " + available.getProduct(index).getID() + " to cart!");
            System.out.println("Total cost: " + totalCost);
        }else{
            System.out.println("Out of Stock!");
        }
    }

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
    public void clearCart(){
        items = new ArrayList<Product>();
        quantity = new ArrayList<Integer>();
        totalCost = 0;
    }

    public int getTotalCost(){
        return totalCost;
    }
    public ArrayList<Product> getProductList(){
        return items;
    }
    public ArrayList<Integer> getQuantityList(){
        return quantity;
    }



}
