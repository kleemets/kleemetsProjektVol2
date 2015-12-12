package HinnaKalkulatsioon;

import java.sql.*;
import java.util.HashMap;

/**
 * Created by Leemets on 12.12.2015.
 */
public class Andmebaas {
    Connection conn = null;

    public Andmebaas() {
        looYhendus();
        looTabel();
    }

    // Et andmebaasi kasutada peame sellega esiteks ühenduse looma
    private void looYhendus() {
        try {
            Class.forName("org.sqlite.JDBC");                          // Lae draiver sqlite.jar failist
            conn = DriverManager.getConnection("jdbc:sqlite:test.db"); // loo ühendus andmebaasi failiga
        } catch ( Exception e ) {                                      // püüa kinni võimalikud errorid
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        System.out.println("Opened database successfully");            // lihtsalt meie enda jaoks teade
    }

    // Et andmebaasist kasu oleks, loome uue tabeli. See on nagu uus 'sheet' excelis.
    public void looTabel() {
        // Käsk ise on CREATE TABLE ja sulgude vahel on kõik tulbad, mida tahan, et tabel hoiaks.
        String sql = "CREATE TABLE IF NOT EXISTS HISTORY(ID INT AUTO_INCREMENT, COUNTRY TEXT, ZONE TEXT, WEIGHT TEXT, PRICE TEXT);";
        teostaAndmebaasiMuudatus(sql);
    }

    // Andmebaasi muudatused ei tagasta väärtusi (erinevalt
    // päringutest) ja on lihtne eraldi meetodi tuua.
    private void teostaAndmebaasiMuudatus(String sql) {
        try {
            // Statement objekt on vajalik, et SQL_Login käsku käivitada
            Statement stat = conn.createStatement();
            stat.executeUpdate(sql);
            stat.close(); // Statement tuleb samuti kinni panna nagu ka Connection.
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveHistory(String country, String zone, String weight, String price) {
        String sql = "INSERT INTO HISTORY (COUNTRY, ZONE, WEIGHT, PRICE) VALUES ('"+country+"','"+zone +"','"+weight+"','"+price +"')";
        teostaAndmebaasiMuudatus(sql);

    }

    // Kui programmis avad ainult ühendusi ja ühtegi ei sulge siis see kulutab arvuti (serveri) ressursse.
    // Üsna kiiresti võib masina kokku jooksutada.
    public void sulgeYhendus() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Ühendus suletud");
    }



    // Kasutaja andmete päring.
    public HashMap getHistory() {
        HashMap andmed = new HashMap();
        try {
            Statement stat = conn.createStatement();
            String sql = "SELECT * FROM HISTORY LIMIT 1;"; // LIMIT piirab tulemuste arvu.

            ResultSet rs = stat.executeQuery(sql);
            // Kui stat.executeQuery() toob tagasi tühja tulemuse, siis rs'i kasutada ei saa.

            // Kui oleks mitu rida andmeid, peaks tsükliga lahendama while (rs.next()) {}

            // Nopin käsitsi andmed ühelt realt välja
            andmed.put("country", rs.getString("country"));
            andmed.put("zone", rs.getString("zone"));
            andmed.put("weight", rs.getString("weight"));
            andmed.put("price", rs.getString("price"));

            rs.close();
            stat.close();
            return andmed;

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return andmed;
    }

    public void uuendaKasutajaAndmeid(HashMap<String, String> andmed) {
        String country = andmed.get("country");
        String zone = andmed.get("zone");
        String weight = andmed.get("weight");
        String price = andmed.get("price");


        try {
            Statement stat = conn.createStatement();
            // Andmete uuendamise käsi on UPDATE. SET ütleb, et nüüd tulevad need uued andmed sisse. WHERE ütleb mis ridu uuendada.
            String sql = String.format("UPDATE HISTORY SET COUNTRY = '%s', PASSWORD = '%s', ZONE = '%s', WEIGHT = '%s', PRICE = '%s'", country, zone, weight, price);
            stat.executeUpdate(sql);
            stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

}

