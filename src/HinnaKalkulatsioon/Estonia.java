package HinnaKalkulatsioon;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by Leemets on 2.12.2015.
 */
public class Estonia {
    public Stage lava2;
    public Scene stseen2;
    public GridPane linnad;
    public Button tsoon1;
    public Button tsoon2;
    public Button tsoon3;
    public Button tsoon4;
    public String riik = new String("estonia");
    public String tsoon;

    public Estonia() {
        uusAken();
        linnadePaigutus();
        nupuVajutus();
    }
    public void uusAken() {
        lava2 = new Stage();
        linnad = new GridPane();
        linnad.setGridLinesVisible(true);
        stseen2 = new Scene(linnad);
        lava2.setScene(stseen2);
        lava2.show();
    }
    public void linnadePaigutus() {
        String[] eestiLinnad1 = {"Tallinn 10000-19999"};
        String[] eestiLinnad2 = {"Jõhvi 41531-42599", "Jüri 75301", "Lagedi/Peetri/Rae 75303-75312", "Maardu 74102-74199", "Pärnu 80010-80401", "Rakvere 44301-44317", "Saku 75501", "Saue 76401", "Keila 76505-76601", "Tabasalu/Harku 76901-76902", "Tartu 50000-60102", "Tartumaa 60512-60545", "Tartumaa2 61400-61499", "Tartumaa3 61700-61999", "Tartumaa4 62100-62299", "Viimsi 74001-74002", "Viljandi 71001-71033"};
        String[] eestiLinnad3 = {"Elva 61501-61510", "Haapsalu 90401-90403", "Jõgeva 48302-48309", "Kärdla 92401-92429", "Kohtla-Järve 30102-30328", "Kuressaare 93801-93820", "Märjamaa 78301-78318", "Narva 20103-21020", "Otepaa 67401-67407", "Paide 72701-72720", "Põltsamaa 48102-48106", "Põlva 63302-63399", "Rapla 79502-79515", "Sillamäe 40201-40233", "Türi 72201-72215", "Valga 68201-68209", "Võru 65602-65620"};
        String[] eestiLinnad4 = {"Muu Eesti"};

        String[][] eestiLinnad = {eestiLinnad1,eestiLinnad2,eestiLinnad3,eestiLinnad4};

        tsoon1 = new Button("Tsoon 1");
        tsoon2 = new Button("Tsoon 2");
        tsoon3 = new Button("Tsoon 3");
        tsoon4 = new Button("Tsoon 4");

        linnad.add(tsoon1,1,0);
        linnad.add(tsoon2,2,0);
        linnad.add(tsoon3,3,0);
        linnad.add(tsoon4,4,0);

        for (int j = 0; j < eestiLinnad.length; j++) {
            for (int i = 0; i < eestiLinnad[j].length; i++) {
                linnad.add(new Label(eestiLinnad[j][i]), j + 1, i + 1);
            }
        }

    }
    public void nupuVajutus() {
        tsoon1.setOnAction(event -> {
            lava2.close();
            tsoon = new String("zone1");
            new HinnaParing(riik, tsoon);

        });

        tsoon2.setOnAction(event -> {
            lava2.close();
            tsoon = new String("zone2");
            new HinnaParing(riik,tsoon);

        });
        tsoon3.setOnAction(event -> {
            lava2.close();
            tsoon= new String("zone3");
            new HinnaParing(riik,tsoon);
        });

        tsoon4.setOnAction(event -> {
            lava2.close();
            tsoon = new String("zone4");
            new HinnaParing(riik,tsoon);
        });
    }
}
