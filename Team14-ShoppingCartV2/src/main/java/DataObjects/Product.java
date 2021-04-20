package DataObjects;

/**
 * @author Ryan Jbaili
 */
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

    /**
     * invariant: sellPrice remains unchanged
     * postcondition: sellPrice is returned
     */
    public double getSellPrice(){return sellPrice;}

    /**
     * invariant: sellPrice remains unchanged
     * postcondition: sellPrice is returned
     */
    public double getInvPrice(){return invPrice;}

    /**
     * invariant: id remains unchanged
     * postcondition: id is returned
     */
    public String getID(){return id;}

    /**
     * invariant: description remains unchanged
     * postcondition: description is returned
     */
    public String getDescription(){return description;}

}
