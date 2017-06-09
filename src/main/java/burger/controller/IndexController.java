package burger.controller;

import java.lang.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(@RequestParam(value="name", required=false, defaultValue="Burger") String name, Model model) {
        
        model.addAttribute("name", name);

        // Connect to MySQL Database
        try {

          // Create Connection
          String url = "jdbc:mysql://localhost:3306/burgers_db";
          String userName = "root";
          String password = "";
          Connection conn = DriverManager.getConnection (url, userName, password);


          // Execute SQL Query for Available Burgers
          Statement findAllReady = conn.createStatement();
          ResultSet readyBurgers = findAllReady.executeQuery("SELECT * FROM burgers WHERE devoured = false");
          
          // Loop over the Query ResultSet
          while ( readyBurgers.next() ) {
              
            // Get Fields of Current ResultSet Row
            int id = readyBurgers.getInt("id");
            String burgerName = readyBurgers.getString("burgerName");
            Boolean devoured = readyBurgers.getBoolean("devoured");
            
            // Print Fields
            String p = id + " | " + burgerName + " | " + String.valueOf(devoured);
            System.out.println(p);

          }


          // Execute SQL Query for Eaten Burgers
          Statement findAllEaten = conn.createStatement();
          ResultSet eatenBurgers = findAllEaten.executeQuery("SELECT * FROM burgers, devourers WHERE devourers.burgerId = burgers.id");
          
          // Loop over the Query ResultSet
          while ( eatenBurgers.next() ) {
              
            // Get Fields of Current ResultSet Row
            String burgerName2 = eatenBurgers.getString("burgerName");
            String devourerName2 = eatenBurgers.getString("devourerName");
            
            // Print Fields
            String p2 = burgerName2 + " | " + devourerName2;
            System.out.println(p2);

          }


        }
        catch (SQLException err) {
          System.out.println(err);
        }
        



        return "index";
    }

}