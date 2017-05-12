package burger.model;

public class Burger {

    private String burgerName;
    private boolean devoured;

    // Setter
    public void setDevoured(boolean devoured) {
        this.devoured = devoured;
    }

    // Constructor
    public Burger(String burgerName) {
        this.burgerName = burgerName;
        this.devoured = false;
    }

}
