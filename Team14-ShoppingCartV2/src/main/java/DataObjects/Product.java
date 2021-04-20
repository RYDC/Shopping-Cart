package DataObjects;

import java.io.Serializable;

/**
 * @author Ryan Jbaili
 */
public class Product implements Serializable {
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
     * postcondition: @return sellPrice is returned
     * @return sellPrice
     */
    public double getSellPrice(){return sellPrice;}

    /**
     * invariant: sellPrice remains unchanged
     * postcondition: @return sellPrice is returned
     * @return invPrice
     */
    public double getInvPrice(){return invPrice;}

    /**
     * invariant: id remains unchanged
     * postcondition: @return id is returned
     * @return id
     */
    public String getID(){return id;}

    /**
     * invariant: description remains unchanged
     * postcondition: @return description is returned
     * @return description
     */
    public String getDescription(){return description;}

}
