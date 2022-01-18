import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Customer class contains first name, last name, email address,
 * phone number, an arraylist of invoices, and an associated store
 *
 * @author Zhe Li (20167899)
 * @version December 8, 2021
 */
public class Customer {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private ArrayList<Invoice> invoicesHistory;
    private Store store;

    /**
     * Customer class constructor
     * @param firstName First name of customer
     * @param lastName  Last name of customer
     * @param emailAddress Email address of customer
     * @param phoneNumber Phone number of customer
     */
    public Customer(String firstName, String lastName, String emailAddress, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Accessor method for first name. Returns the first name of the customer
     * @return First name of customer
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * Mutator method for first name. Takes the first name as a parameter
     * @param firstName First name of customer
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    /**
     * Accessor method for last name. Returns the last name of the customer
     * @return Last name of customer
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * Mutator method for last name. Takes the last name as a parameter
     * @param lastName last name of customer
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    /**
     * Accessor method for email address. Returns the email address of the customer
     * @return Email address of customer
     */
    public String getEmailAddress(){
        return emailAddress;
    }

    /**
     * Mutator method for email address. Takes the email address as a parameter
     * @param emailAddress Email address of customer
     */
    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }

    /**
     * Accessor method for phone number. Returns the phone number of the customer
     * @return Phone number of customer
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * Mutator method for phone number. Takes the phone number as a parameter
     * @param phoneNumber Phone number of customer
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    /**
     * Accessor method for invoice history arraylist. Returns the invoice history arraylist of the customer
     * @return invoice history arraylist
     */
    public ArrayList<Invoice> getInvoices(){
        return invoicesHistory;
    }

    /**
     * Mutator method for invoice history arraylist. Takes the invoice history arraylist as a parameter
     * @param invoicesHistory Invoice history arraylist
     */
    public void setInvoices(ArrayList<Invoice> invoicesHistory){
        this.invoicesHistory = invoicesHistory;
    }

    /**
     * Accessor method for phone number. Returns the phone number of the customer
     * @return Phone number of customer
     */
    public Store getStore(){
        return store;
    }

    /**
     * Mutator method for associated store with the customer. Takes the store  as a parameter
     * @param store Store
     */
    public void setStore(Store store){
        this.store = store;
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
     * This method adds an invoice object into the invoiceHistory arraylist
     * @param invoice Invoice object
     */
    public void addInvoice(Invoice invoice){
        getInvoices().add(invoice);
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
     * this method calculates the total sales for a customer,
     * it loops through the every invoice in invoiceHistory
     * Arraylist to retrieve the total amount
     *
     * @return totalSales
     */
    public int getTotalSales(){
        int totalSales = 0;
        for (Invoice invoice : getInvoices()){
            totalSales += invoice.getTotal();
        }
        return totalSales;
    }

    /**
     * This method displays the related values of the customer:
     * name, total sales, email, associated store, phone number,
     * and detailed information of invoiceHistory of the customer
     */
    public void displayProfile(){
        lineGenerator();
        System.out.printf("Name: %s, %-30s", getFirstName(), getLastName());
        System.out.printf("Total Sales: %d%n", getTotalSales());
        System.out.printf("E-mail: %-10s", getEmailAddress());
        System.out.printf("                  Store: %s%n", store.getName());
        System.out.printf("Phone: (%s) %s-%s%n", getPhoneNumber().substring(0,3), getPhoneNumber().substring(3,6), getPhoneNumber().substring(6,10));
        lineGenerator();
        for(int i = 0; i < getInvoices().size();i++) {
            System.out.println("Invoice " + (i + 1));
            System.out.printf("Purchase Date: %s%n", getCurrentDate());
            System.out.println("Items Purchased");
            getInvoices().get(i).displayItem();
        }
    }

}
