package burger.model;

public class Devourer {

    private String devourerName;
    private int burgerId;

    // Constructor
    public Devourer(String devourerName, int burgerId) {
        this.devourerName = devourerName;
        this.burgerId = burgerId;
    }

    // Getter for Devourer Name
    public String getDevourerName() {
        return devourerName;
    }

    // Getter for Devoured Burger Id
    public int getBurgerId() {
        return burgerId;
    }
}