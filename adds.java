

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class adds
{
    public static void main(String args[])
    {

        try{
               // Load the MySQL JDBC driver
               Class.forName("com.mysql.cj.jdbc.Driver");


               
            // Establish the connection to the database
            String url = "jdbc:mysql://localhost:3306/java_class";
            String user = "root"; // Your MySQL username
            String password = ""; // Your MySQL password
            Connection con = DriverManager.getConnection(url, user, password);

            // Create a scanner for user input
            Scanner scanner = new Scanner(System.in);

                  // Prompt the user for input
                  System.out.println("Enter the name to insert: ");
                  String name = scanner.nextLine();

      // Create a statement
      Statement stmt = con.createStatement();

      // Insert data into the table
      String insertQuery = "INSERT INTO users (name) VALUES ('" + name + "')";
      int rowsInserted = stmt.executeUpdate(insertQuery);

      if (rowsInserted > 0) {
          System.out.println("Data inserted successfully!");
      }
             
                  // Execute a query and get the result set
            String readQuery = "SELECT * FROM users";
            ResultSet rs = stmt.executeQuery(readQuery);

            // Iterate through the result set
            while (rs.next()) {
              
                System.out.println("Name: " + rs.getString("name"));
             
                System.out.println("------------------------------");
            }





        con.close();   
        scanner.close();       

        } 

    catch (Exception e) {
        e.printStackTrace();
    }


    }
}