import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Invoice class contains a customer object, store object
 * and itemSold arraylist that represents all purchased items
 * from the customer
 *
 * @author Zhe Li (20167899)
 * @version December 8, 2021
 */
public class Invoice {
    private Customer customer;
    private Store store;
    private ArrayList<Item> itemSold;

    /**
     * Invoice class constructor
     * @param customer Customer object
     * @param store Store object
     */
    public Invoice (Customer customer, Store store){
        this.customer = customer;
        this.store = store;
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
     * Accessor method for customer. Returns the associated customer object
     * @return Customer object
     */
    public Customer getCustomer(){
        return customer;
    }

    /**
     * Mutator method for associated customer. Takes the customer object as a parameter
     * @param customer Customer object
     */
    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    /**
     * Accessor method for store. Returns the associated store object
     * @return Store object
     */
    public Store getStore(){
        return store;
    }

    /**
     * Mutator method for associated store. Takes the store object as a parameter
     * @param store Store object
     */
    public void setStore(Store store){
        this.store = store;
    }

    /**
     * Accessor method for sold items. Returns the arraylist of sold items
     * @return ItemSold arraylist
     */
    public ArrayList<Item> getItemSold(){
        return itemSold;
    }

    /**
     * Mutator method for sold items arraylist. Takes the arraylist of sold items as a parameter
     * @param itemSold ItemSold arraylist
     */
    public void setItemSold(ArrayList<Item> itemSold){
        this.itemSold = itemSold;
    }

    /**
     * This method returns the current date
     * @return Current date
     */
    public String getCurrentDate(){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        return dateFormat.format(currentDate);
    }

    /**
     * this method checks a taken item's quantity. If the quantity is
     * greater than 0, add it to the arraylist. Otherwise, throw an exception
     * @param item Item object
     */
    public void addItem (Item item) throws Exception{
        if (item.getQuantity() > 0){
            getItemSold().add(item);
            for (Item storeItem : store.getAvailableItems()){
                if (item.getModel().equals(storeItem.getModel())){
                    storeItem.setQuantity(storeItem.getQuantity() - 1);
                }
            }
        } else {
            throw new Exception();
        }
    }

    /**
     * this method goes through the itemSold arraylist, and calculates the
     * total price of all the sold items
     * @return total
     */
    public int getTotal(){
        int total = 0;
        for (Item item: itemSold) {
            total += item.getPrice();
        }
        return total;
    }

    /**
     * this method displays detailed information regarding all the items in
     * the itemSold arraylist.
     */
    public void displayItem(){
        for (Item item: itemSold){
            System.out.printf("%-10s", item.getManufacturer());
            System.out.printf("%-53s", item.getModel());
            System.out.printf("%d%n", item.getPrice());
        }
        System.out.println();
        lineGenerator();
        System.out.printf("Total%61d%n", getTotal());
        lineGenerator();
    }

    /**
     * This method displays information about the associated customer and
     * store: store name, customer name, email, phone number, purchase date
     * and also calls displayItem method to display all the sold items' info
     */
    public void displayInvoice(){
        lineGenerator();
        System.out.printf("Store Name: %s%n", store.getName());
        lineGenerator();
        System.out.printf("Name: %s, %s%n", customer.getFirstName(), customer.getLastName());
        System.out.printf("E-mail: %s%n", customer.getEmailAddress());
        System.out.printf("Phone: (%s) %s-%s%n", customer.getPhoneNumber().substring(0,3), customer.getPhoneNumber().substring(3,6), customer.getPhoneNumber().substring(6,10));
        System.out.printf("Purchase Date: %s%n", getCurrentDate());
        lineGenerator();
        System.out.println();
        displayItem();
    }
}
