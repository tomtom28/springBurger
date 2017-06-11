package burger.model;

public class MyDatabaseConnection {

    private String userName;
    private String password;
    private String dataBaseURL;
    
    // Constructor
    public MyDatabaseConnection(String JAWSDB_MARIA_URL) {

        // Localhost
        if (JAWSDB_MARIA_URL == null) {
            System.out.println("Connecting to localhost...");
            dataBaseURL = "jdbc:mysql://localhost:3306/burgers_db";
            userName = "root";
            password = ""; // "root" on PC or "" on Mac

            System.out.println(dataBaseURL + "\n" + userName + "\n" + password);
        }
        // Heroku
        else {
            System.out.println("Connecting to AWS...");
            dataBaseURL = "jdbc:mysql://" + JAWSDB_MARIA_URL.split("@")[1].split("/")[0];
            userName = JAWSDB_MARIA_URL.split(":")[1].split("//")[1];
            password = JAWSDB_MARIA_URL.split(":")[2].split("@")[0];

            System.out.println(dataBaseURL + "\n" + userName + "\n" + password);
        }

        // Set Variables
        this.dataBaseURL = dataBaseURL;
        this.userName = userName;
        this.password = password;

    }

    // Getter for database URL
    public String getDatabaseURL() {
        return dataBaseURL;
    }

    // Getter for username
    public String getUsername() {
        return userName;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

}
