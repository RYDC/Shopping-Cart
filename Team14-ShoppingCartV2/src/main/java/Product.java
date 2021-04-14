public class Product {
    private String id;
    private double invPrice;
    private double sellPrice;

    public Product(String name, double basePrice, double storePrice){
        id = name;
        invPrice = basePrice;
        sellPrice = storePrice;
    }

    public void setInvPrice(double price){invPrice = price;}
    public void setSellPrice(double price){sellPrice = price;}
    public double getInvPrice(){return invPrice;}
    public double getSellPrice(){return sellPrice;}
    public String getID(){return id;}

}
