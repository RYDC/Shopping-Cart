public class Product {
    private String id;
    private double invPrice;
    private double sellPrice;
    private String description;

    public Product(String name, double basePrice, double storePrice,String descript){
        id = name;
        invPrice = basePrice;
        sellPrice = storePrice;
        description = descript;

    }

    public void setInvPrice(double price){invPrice = price;}
    public void setSellPrice(double price){sellPrice = price;}
    public double getInvPrice(){return invPrice;}
    public double getSellPrice(){return sellPrice;}
    public String getID(){return id;}
    public String getDescription(){return description;}

}
