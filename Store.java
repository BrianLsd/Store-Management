import java.util.ArrayList;

/**
 * Store class contains name of store and has an arraylist of Item associated with it
 *
 * @author Zhe Li (20167899)
 * @version December 8, 2021
 */
public class Store {
    private String name;
    private ArrayList<Item> availableItems;

    /**
     * Store class constructor
     * @param name Name of store
     */
    public Store(String name){
        this.name = name;
    }

    /**
     * Accessor method for name. Returns the name of the store
     * @return Name of store
     */
    public String getName(){
        return name;
    }

    /**
     * Mutator method for name. Takes name as a parameter
     * @param name Name of store
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Accessor method for inventory arraylist. Returns the store inventory list
     * @return Inventory arraylist
     */
    public ArrayList<Item> getAvailableItems(){
        return availableItems;
    }

    /**
     * Mutator method for inventory arraylist. Takes an Item arraylist as a parameter
     * @param availableItems Item arraylist
     */
    public void setItems(ArrayList<Item> availableItems){
        this.availableItems = availableItems;
    }

    /**
     * This method generate a line for cosmetic purposes
     */
    public void lineGenerator(){
        for (int i = 0; i < 66; i++){
            System.out.print("-");
        }
        System.out.println();
    }


    /**
     * This method is a combined inventory display method
     * if method receive 1, then display all the available
     * inventory(quantity>0); otherwise, display all the items
     * @param choice Integer
     */
    public void displayInventoryReference(int choice){
        lineGenerator();
        System.out.printf("Store Name: %s%n", getName());
        lineGenerator();
        System.out.println("Manufacturer      Model             Type        Qty         Price");
        lineGenerator();
        for (Item item: availableItems) {
            if (choice == 1){
                if (item.getQuantity() > 0){
                    System.out.printf("%-18s%-18s%-12s%-12s%-12s%n", item.getManufacturer(), item.getModel(), item.getType().getName(), item.getQuantity(), item.getPrice());
                    System.out.printf("   Location: %s%n", item.getType().getStoreLocation());
                }
            } else {
                System.out.printf("%-18s%-18s%-12s%-12s%-12s%n", item.getManufacturer(), item.getModel(), item.getType().getName(), item.getQuantity(), item.getPrice());
                System.out.printf("   Location: %s%n", item.getType().getStoreLocation());
            }
        }
    }

    /**
     * This method calls displayInventoryReference method, and provide
     * integer 0 to display all the inventory at the store.
     */
    public void displayInventory(){
        displayInventoryReference(0);
    }

    /**
     * This method calls displayInventoryReference method, and provide
     * integer 1 to display all the available inventory at the store.
     */
    public void displayAvailableInventory(){
        displayInventoryReference(1);
    }
}
