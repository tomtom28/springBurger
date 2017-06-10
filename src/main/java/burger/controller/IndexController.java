package burger.controller;

import java.lang.*;
import java.sql.*;
import java.util.*;

import burger.model.Devourer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model) {

        // Connect to MySQL Database
        try {

          // Create Connection
          String url = "jdbc:mysql://localhost:3306/burgers_db";
          String userName = "root";
          String password = ""; // "root" on PC or "" on Mac
          Connection conn = DriverManager.getConnection (url, userName, password);


          // Execute SQL Query for Available Burgers
          Statement findAllReady = conn.createStatement();
          ResultSet readyBurgers = findAllReady.executeQuery("SELECT * FROM burgers WHERE devoured = false");
          
          // Loop over the Query ResultSet and Append to HashMap of Edible Burgers
          HashMap<Integer, String> edibleBurgers = new HashMap<Integer, String>();

          while ( readyBurgers.next() ) {
              
            // Get Fields of Current ResultSet Row
            int burgerId = readyBurgers.getInt("id");
            String burgerName = readyBurgers.getString("burgerName");
            
            // Print Fields
            String p = burgerId + " | " + burgerName;
            System.out.println(p);

            // Append Burger to Edible HashMap
            edibleBurgers.put(burgerId, burgerName);

          }

          // Append Edible Burgers to model
          model.addAttribute("edibleBurgers", edibleBurgers);


          // Execute SQL Query for Eaten Burgers
          Statement findAllEaten = conn.createStatement();
          ResultSet eatenBurgers = findAllEaten.executeQuery("SELECT * FROM burgers, devourers WHERE devourers.burgerId = burgers.id");

          // Loop over the Query ResultSet and Append to HashMap of Edible Burgers
          HashMap<Integer, String[]> consumedBurgers = new HashMap<Integer, String[]>();

          while ( eatenBurgers.next() ) {
              
            // Get Fields of Current ResultSet Row
            int burgerId2 = eatenBurgers.getInt("id");
            String burgerName2 = eatenBurgers.getString("burgerName");
            String devourerName2 = eatenBurgers.getString("devourerName");
            String[] burgerNameAndDevourerName = {burgerName2, devourerName2};
            
            // Print Fields
            String p2 = burgerId2 + " | " + burgerName2 + " | " + devourerName2;
            System.out.println(p2);

            // Append Burger to Edible HashMap
            consumedBurgers.put(burgerId2, burgerNameAndDevourerName);

          }

          // Append Edible Burgers to model
          model.addAttribute("consumedBurgers", consumedBurgers);


          // Close MySQL Connection
          conn.close();

        }
        catch (SQLException err) {
          System.out.println(err);
        }
        



        return "index";
    }

    @RequestMapping("/devour/{burgerId}")
    public String devour(@PathVariable(value = "burgerId") int burgerId, @RequestParam(value="burgerEater", required=true) String burgerEater) {

        // Print Fields: Burger Id comes from URL Path Variable and Burger Devourer Name from Request Parameter
        System.out.println("Yummy!");
        System.out.println("Burger Id: " + "\"" + burgerId + "\"" + " and " + "Devourer Name: " + "\"" + burgerEater + "\"");

        // If no name is given, default to Anonymous
        if (burgerEater == "") {
            burgerEater = "Anonymous";
        }


        // Create new Devourer class using Burger Id and Devourer Name (this is more for practice than anything else)
        Devourer newBurgerEater = new Devourer(burgerEater, burgerId);


        // Connect to MySQL Database
        try {

            // Create Connection
            String url = "jdbc:mysql://localhost:3306/burgers_db";
            String userName = "root";
            String password = ""; // "root" on PC or "" on Mac
            Connection conn = DriverManager.getConnection(url, userName, password);


            // Update selected burger to devoured
            Statement updateDevouredBurger = conn.createStatement();
            updateDevouredBurger.executeUpdate("UPDATE burgers SET devoured=true WHERE id = " + burgerId);


            // Insert a new devourer
            PreparedStatement preparedStmt = conn.prepareStatement("INSERT INTO devourers(devourerName, burgerId) VALUES (?, ?)");
            preparedStmt.setString (1, newBurgerEater.getDevourerName() );
            preparedStmt.setString (2, Integer.toString( newBurgerEater.getBurgerId() ) );
            preparedStmt.execute();


            // Close MySQL Connection
            conn.close();

        }
        catch (SQLException err) {
            System.out.println(err);
        }




        return "redirect:/";

    }

}