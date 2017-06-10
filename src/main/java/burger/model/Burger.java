package burger.model;

public class Burger {

    private String burgerName;
    private boolean devoured;

    // Constructor
    public Burger(String burgerName) {
        this.burgerName = burgerName;
        this.devoured = false;
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
