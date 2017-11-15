package com.simpleSqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con =
          DriverManager.getConnection("jdbc:mysql://localhost:3306/hats", "root", "root");
      Statement stmt = con.createStatement();
      // // code to add to database
      // stmt.executeUpdate(
      // String.format("insert into hat (hat_name, hat_color, hat_size) values ('%s','%s','%d')",
      // "ballcap", "blue", 5));
      ResultSet rs = stmt.executeQuery("select * from hat");
      Set<Hat> hats = new LinkedHashSet<>();
      while (rs.next()) {
        Hat hat =
            new Hat(rs.getString("hat_name"), rs.getString("hat_color"), rs.getInt("hat_size"));
        /*
         * be sure you know what data type is coming in (e.g. a MySql id int comes in as a long)
         * because ResultSet may ignore the column label parameter and give you a different column
         * value that matches your data type. If unsure, bring data in as a String and convert. The
         * line below grabbed the size column value when I tried bringing it in as an int.
         */
        hat.setId(rs.getLong("hat_id"));
        hats.add(hat);
      }
      con.close();
      for (Hat hat : hats) {
        System.out.println("Id: " + hat.getId());
        System.out.println("Name: " + hat.getName());
        System.out.println("Color: " + hat.getColor());
        System.out.println("Size: " + hat.getSize());
        System.out.println();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
