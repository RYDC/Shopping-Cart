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

    public void add_item(Product x, int y){
        items.add(x);
        stock.add(y);
    }

    public void remove_item(int index){
        items.remove(index);
        stock.remove(index);
    }

    public void restock(int index, int amount){
        stock.set(index,amount);
    }

    public void sell(int index, int amount){
        if(stock.get(index)<amount){
            stock.set(index,0);
        }else{
            stock.set(index,stock.get(index)-amount);
        }
    }

    public Product getProduct(int index){
        return items.get(index);
    }








}
