import java.util.ArrayList;
import java.security.SecureRandom;
import java.util.List;

/**
 * Testing method for the term project
 *
 * @author Zhe Li (20167899)
 * @version December 8, 2021
 */
public class StoreTest {
    /**
     * This method is used in step 5 of testing. The method goes through
     * the duplicateCheck array and compares all the numbers with the
     * provided current random number. If the current has been generated
     * previously then return true and break the loop. Otherwise, return false
     *
     * @param duplicateCheck Duplicate number array
     * @param random Random number
     * @return duplicate
     */
    public static boolean duplicateCheck(int[] duplicateCheck, int random){
        boolean duplicate = false;
        for (int n: duplicateCheck){
            if (n == random) {
                duplicate = true;
                break;
            }
        }
        return duplicate;
    }

    /**
     * Main method creates items and tests methods
     * @param args Command line arguments
     */
    public static void main(String[] args){
        // step 1
        Store myFirstStore = new Store("My First Store");
        Store mySecondStore = new Store("My Second Store");

        // step 2
        Item store1Item1 = new Item("Nintendo","Switch", 379, 20, myFirstStore,Type.CONSOLE);
        Item store1Item2 = new Item("SONY", "PS5", 629, 11, myFirstStore, Type.CONSOLE);
        Item store1Item3 = new Item("SONY","PS4", 369, 24, myFirstStore, Type.CONSOLE);
        Item store1Item4 = new Item("ILCA", "Pokemon Diamond", 79, 40, myFirstStore, Type.GAME);
        Item store1Item5 = new Item("Nintendo", "Zelda botw", 79, 52, myFirstStore, Type.GAME);
        Item store1Item6 = new Item("ASUS", "Strix G15DK", 1999, 13, myFirstStore, Type.CONSOLE);
        Item store1Item7 = new Item("Acer", "Orion 3000", 1899, 15, myFirstStore, Type.CONSOLE);
        Item store1Item8 = new Item("Nintendo", "Switch OLED", 599, 11, myFirstStore, Type.CONSOLE);
        Item store1Item9 = new Item("CDPR", "CyberPunk 2077", 39, 46, myFirstStore,Type.GAME);
        Item store1Item10 = new Item("ElecArts","FIFA22", 49, 30, myFirstStore, Type.GAME);
        ArrayList<Item> storeOneItems = new ArrayList<>(List.of(store1Item1,store1Item2,store1Item3,store1Item4,store1Item5,store1Item6,store1Item7,store1Item8,store1Item9,store1Item10));
        myFirstStore.setItems(storeOneItems);

        Item store2Item1 = new Item("MircoSoft", "XBOX Series S", 379, 21, mySecondStore, Type.CONSOLE);
        Item store2Item2 = new Item("MircoSoft", "XBOX Series X", 599, 12, mySecondStore, Type.CONSOLE);
        Item store2Item3 = new Item("VC", "NBA 2k22", 59, 80, mySecondStore, Type.GAME);
        Item store2Item4 = new Item("XBox studio", "Halo Infinite", 79, 23, mySecondStore, Type.GAME);
        Item store2Item5 = new Item("Ubisoft", "Far Cry 6", 79, 17, mySecondStore, Type.GAME);
        Item store2Item6 = new Item("ASUS", "Zephyrus", 1649, 19, mySecondStore, Type.CONSOLE);
        Item store2Item7 = new Item("Dell", "G15", 1099, 27, mySecondStore, Type.CONSOLE);
        Item store2Item8 = new Item("HP", "Pavilion", 900, 23, mySecondStore, Type.CONSOLE);
        Item store2Item9 = new Item("SONY", "Spider-man", 58, 16, mySecondStore, Type.GAME);
        Item store2Item10 = new Item("Nintendo", "Smash Bros", 80, 18, mySecondStore, Type.GAME);
        ArrayList<Item> storeTwoItems = new ArrayList<>(List.of(store2Item1,store2Item2,store2Item3,store2Item4,store2Item5,store2Item6,store2Item7,store2Item8,store2Item9,store2Item10));
        mySecondStore.setItems(storeTwoItems);

        // step 3
        myFirstStore.displayInventory();
        mySecondStore.displayInventory();
        System.out.println(); // separator

        // step 4
        Customer firstCustomer = new Customer("Bill", "Gates", "billgates@ms.com", "7091234567");
        Customer secondCustomer = new Customer("Elon", "Musk", "elonmusk@spacex.com", "7098765432");
        ArrayList<Invoice> firstCustomerInvoices = new ArrayList<>(); // initialize first customer's invoice history
        firstCustomer.setInvoices(firstCustomerInvoices);
        ArrayList<Invoice> secondCustomerInvoices = new ArrayList<>(); // initialize second customer's invoice history
        firstCustomer.setInvoices(secondCustomerInvoices);
        firstCustomer.setStore(myFirstStore);
        secondCustomer.setStore(mySecondStore);

        // step 5
        SecureRandom random = new SecureRandom();
        Invoice firstInvoice = new Invoice(firstCustomer, myFirstStore);
        ArrayList<Item> storeOneItemSold = new ArrayList<>();
        firstInvoice.setItemSold(storeOneItemSold); // items being sold array at store 1
        int[] duplicateCheck = new int[5]; // make sure no duplicated items added in
        int randomNumber = 0;
        int counter = 0;
        while (firstInvoice.getItemSold().size() < 5){
            randomNumber = random.nextInt(10); // 0-9
            Item purchasedItem = myFirstStore.getAvailableItems().get(randomNumber);
            try {
                if (duplicateCheck(duplicateCheck, randomNumber)){
                    continue;
                } else {
                    firstInvoice.addItem(purchasedItem);
                }
            } catch (Exception e){
                System.out.println("Quantity of items should be greater than 0");
            }
            duplicateCheck[counter] = randomNumber;
            counter++;
        }
        firstCustomer.addInvoice(firstInvoice); // when an order went through, push the invoice into that customer

        // step 6
        firstInvoice.displayInvoice();

        // step 7
        Invoice secondInvoice = new Invoice(secondCustomer, mySecondStore); // create second invoice
        ArrayList<Item> storeTwoItemSold = new ArrayList<>();
        secondInvoice.setItemSold(storeTwoItemSold); // items being sold array at store 2
        try{
            secondInvoice.addItem(store2Item1); // add one item to second customer
        } catch (Exception e){
            System.out.println("Quantity of items should be greater than 0");
        }

        // step 8
        System.out.println(); // separator
        firstCustomer.displayProfile();

        // step 9
        Item newItem = new Item("Mojang","Minecraft", 18, 0, mySecondStore,Type.GAME); // 0 quantity item
        storeTwoItems.add(newItem);
        mySecondStore.setItems(storeTwoItems); // add new item to the second store array

        // step 10
        mySecondStore.displayAvailableInventory();

        // step 11
        System.out.println(); // separator
        Invoice thirdInvoice = new Invoice(secondCustomer, mySecondStore);
        ArrayList<Item> thirdInvoiceArray = new ArrayList<>();
        thirdInvoice.setItemSold(thirdInvoiceArray);
        for (Item item: storeTwoItems){ // add all the items at second store to the third invoice
            try{
                thirdInvoice.addItem(item);
            } catch (Exception e){
                System.out.println("Quantity of items should be greater than 0");
            }
        }
    }
}


