import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product>items;
    private ArrayList<Integer> stock;
    private int selected_item;

    public Inventory(){
        items = new ArrayList<Product>();
        stock = new ArrayList<Integer>();
        selected_item = 0;
    }

    public void add_item(Product item, int quantity){
        items.add(item);
        stock.add(quantity);
    }

    public void remove_item(int index){
        items.remove(index);
        stock.remove(index);
    }

    public void restock(int index, int amount){
        stock.set(index,stock.get(index)+amount);
    }

    public boolean sell(int index, int amount){
        if(stock.get(index)<amount){
            stock.set(index,0);
            return false;
        }else{
            stock.set(index,stock.get(index)-amount);
            return true;
        }
    }

    public Product getProduct(int index){
        return items.get(index);
    }
    public int getProductQuantity(int index){
        return stock.get(index);
    }
    public ArrayList<Product> getList(){return items;}
    public int getStock(int index){
        return stock.get(index);
    }








}
