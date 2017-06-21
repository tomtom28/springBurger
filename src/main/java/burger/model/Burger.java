package burger.model;

public class Burger {

    private int burgerId;
    private String burgerName;
    private boolean devoured;

    // Constructor for New Burger
    public Burger(String burgerName) {
        this.burgerId = 0; // default to 0; MySQL will automatically assign an ID
        this.burgerName = burgerName;
        this.devoured = false;
    }

    // Constructor for Existing Burger
    public Burger(int burgerId, String burgerName, boolean devoured) {
        this.burgerId = burgerId;
        this.burgerName = burgerName;
        this.devoured = devoured;
    }

    // Getter for Burger Id
    public int getBurgerId() {
        return burgerId;
    }

    // Getter for Burger Name
    public String getBurgerName() {
        return burgerName;
    }

    // Getter for Burger Status
    public boolean getDevoured() {
        return devoured;
    }

}
