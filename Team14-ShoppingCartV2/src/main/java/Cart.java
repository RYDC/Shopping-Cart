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

    public void remove(int index){
        totalCost-=items.get(index).getSellPrice();
        items.remove(index);
    }

    public int getTotalCost(){
        return totalCost;
    }


}
