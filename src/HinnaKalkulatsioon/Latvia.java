package HinnaKalkulatsioon;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by Leemets on 12.12.2015.
 */
public class Latvia {
    public Stage lava2;
    public GridPane linnad;
    public Scene stseen1;
    public Button tsoon1;
    public Button tsoon2;
    public Button tsoon3;
    public String riik = new String("latvia");
    public String tsoon;
    public static String viimatiValitudtsoon;


    public Latvia(){
        uusAken();
        linnadePaigutus();
        nupuVajutus();
    }

    private void nupuVajutus() {
            tsoon1.setOnAction(event -> {
                lava2.close();
                tsoon = new String("zone1");
                viimatiValitudtsoon = "Tsoon 1";
                new HinnaParing(riik, tsoon);

            });

            tsoon2.setOnAction(event -> {
                lava2.close();
                tsoon = new String("zone2");
                viimatiValitudtsoon="Tsoon 2";
                new HinnaParing(riik,tsoon);

            });
            tsoon3.setOnAction(event -> {
                lava2.close();
                tsoon= new String("zone3");
                viimatiValitudtsoon="Tsoon 3";
                new HinnaParing(riik,tsoon);
            });
    }

    private void linnadePaigutus() {
        String[] latvia1 = {"Riia 1000-1999"};
        String[] latvia2 = {"Riia regioon 2000-2133","Riia regioon 2135-2999","Daugavpils 5400-5422", "Jekapils 5200-5207", "Rezekne 4600-4605", "Gulbene 4400-4401", "Valmeira 4200-4202", "Cesis 4100-4103","Saldus 3800-3801", "Ventspils 3600-3606", "Liepaja 3400-3417", "Talsi 3200-3203", "Jelgava 3000-3035", };
        String[] latvia3 = {"Muu L�ti"};

        String[][] latvia = {latvia1,latvia2,latvia3};

        tsoon1 = new Button("Tsoon 1");
        tsoon2 = new Button("Tsoon 2");
        tsoon3 = new Button("Tsoon 3");

        linnad.add(tsoon1,1,0);
        linnad.add(tsoon2,2,0);
        linnad.add(tsoon3,3,0);


        for (int j = 0; j < latvia.length; j++) {
            for (int i = 0; i < latvia[j].length; i++) {
                linnad.add(new Label(latvia[j][i]), j + 1, i + 1);
            }
        }
    }


    private void uusAken() {
        lava2 = new Stage();
        linnad = new GridPane();
        linnad.setGridLinesVisible(true);
        stseen1 = new Scene(linnad);
        lava2.setScene(stseen1);
        lava2.show();

    }
}
