/**
 * this enum contains two constants: CONSOLE and GAME
 * every constant has two field: name and storeLocation
 */
public enum Type {
    CONSOLE("console", "Section A"),
    GAME("game", "Section B");

    private final String name;
    private final String storeLocation;

    /**
     * enum constructor
     * @param name Name of constant
     * @param storeLocation Store location of constant
     */
    Type(String name, String storeLocation){
        this.name = name;
        this.storeLocation = storeLocation;
    }

    /**
     * enum accessor, returns the name of the constant
     * @return Name of constant
     */
    public String getName(){
        return name;
    }

    /**
     * enum accessor, returns the store location of the constant
     * @return Store location of constant
     */
    public String getStoreLocation(){
        return storeLocation;
    }
}
