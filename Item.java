/**
 * Item class contains manufacturer, model, price, quantity, type(enum)
 * and a store associated with it.
 *
 * @author Zhe Li (20167899)
 * @version December 8, 2021
 */
public class Item {
    private String manufacturer;
    private String model;
    private int price;
    private int quantity;
    private Type type;
    private Store store;

    /**
     * Item class constructor
     * @param manufacturer Manufacturer of item
     * @param model Model of item
     * @param price Price of item
     * @param quantity Quantity of item
     * @param store Store of item
     * @param type Type of item
     */
    public Item(String manufacturer, String model, int price, int quantity, Store store, Type type){
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
        this.store = store;
    }

    /**
     * Accessor method for manufacturer. Returns the manufacturer of the item
     * @return Manufacturer of item
     */
    public String getManufacturer(){
        return manufacturer;
    }

    /**
     * Mutator method for manufacturer. Takes the manufacturer as a parameter
     * @param manufacturer Manufacturer of item
     */
    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }

    /**
     * Accessor method for model. Returns the model of the item
     * @return Model of item
     */
    public String getModel(){
        return model;
    }

    /**
     * Mutator method for model. Takes the model as a parameter
     * @param model Model of item
     */
    public void setModel(String model){
        this.model = model;
    }

    /**
     * Accessor method for price. Returns the price of the item
     * @return Price of item
     */
    public int getPrice(){
        return price;
    }

    /**
     * Mutator method for price. Takes the price as a parameter
     * @param price Price of item
     */
    public void setPrice(int price){
        this.price = price;
    }

    /**
     * Accessor method for quantity. Returns the quantity of the item
     * @return Quantity of item
     */
    public int getQuantity(){
        return quantity;
    }

    /**
     * Mutator method for quantity. Takes the quantity as a parameter
     * @param quantity Quantity of item
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Accessor method for store. Returns the associated store
     * @return store
     */
    public Store getStore(){
        return store;
    }

    /**
     * Mutator method for store. Takes the store as a parameter
     * @param store Store
     */
    public void setStore(Store store){
        this.store = store;
    }

    /**
     * Accessor method for type. Returns the associated type
     * @return type
     */
    public Type getType (){
        return type;
    }

    /**
     * Mutator method for type. Takes the type as a parameter
     * @param type Type
     */
    public void setType(Type type){
        this.type = type;
    }

}

