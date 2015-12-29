package HinnaKalkulatsioon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.HashMap;

/**
 * Created by Leemets on 12.12.2015.
 */
public class Andmebaas {
    Connection conn = null;

    //Klassi Andmebaasi koostamisel võtsin aluseks Krister Viirsaare näidise SQL Andmebaaside loomine
    public Andmebaas() {
        looYhendus();
        looTabel();
    }

    private void looYhendus() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    public void looTabel() {
        String sql = "CREATE TABLE IF NOT EXISTS HISTORY(ID INT AUTO_INCREMENT, COUNTRY TEXT, ZONE TEXT, WEIGHT TEXT, PRICE TEXT);";
        teostaAndmebaasiMuudatus(sql);
    }

    private void teostaAndmebaasiMuudatus(String sql) {
        try {
            Statement stat = conn.createStatement();
            stat.executeUpdate(sql);
            stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveHistory(String country, String zone, String weight, String price) {
        String sql = "INSERT INTO HISTORY (COUNTRY, ZONE, WEIGHT, PRICE) VALUES ('"+country+"','"+zone +"','"+weight+"','"+price +"')";
        teostaAndmebaasiMuudatus(sql);
    }

    public void sulgeYhendus() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ObservableList getHistory() {
        ObservableList <AjalooTabel.History> andmed = FXCollections.observableArrayList();
        try {
            Statement stat = conn.createStatement();
            String sql = "SELECT * FROM HISTORY;";

            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                andmed.add(new AjalooTabel.History(rs.getString("country"), rs.getString("zone"), rs.getString("weight"), rs.getString("price")));
            }

            rs.close();
            stat.close();
            return andmed;

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return andmed;
    }

   public void kustutaAjalooTabel (){
       try {
           Statement stat = conn.createStatement();
           String sql = String.format ("DELETE FROM HISTORY;");
           stat.executeUpdate(sql);
           stat.close();

       }catch (SQLException e){
           e.printStackTrace();
           System.exit(0);
       }
   }

}

