package HinnaKalkulatsioon;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

/**
 * Created by Leemets on 12.12.2015.
 */
public class Lithuania {
    public Stage lava2;
    public GridPane linnad;
    public Scene stseen1;
    public Button tsoon1;
    public Button tsoon2;
    public Button tsoon3;
    public String riik = new String("lithuania");
    public String tsoon;
    public static String viimatiValitudtsoon;


    public Lithuania(){

        linnadePaigutus();
        nupuVajutus();
    }

    private void nupuVajutus() {
        tsoon1.setOnAction(event -> {
            lava2.close();
            tsoon = new String("zone1");
            viimatiValitudtsoon= "Tsoon 1";
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
        String[] leedu1 = {"Vilnius 01001-11599","Vilnius 27001-27199","Kaunas 44001-53370"};
        String[] leedu2 = {"Alytus 62001-63499","Kedainiai 57001-57005","Klaipeda 91001-93008", "Klaipeda 93146-95409", "Marijampole 68001-68505", "Mazeikiai 89001-89316", "Panevezys 35001-37499", "Plunge 90112-90183","Rokiskis 42001-42003", "Siauliai 76001-79299", "Siauliai 81486-81498", "Taurage 72001-72363", "Telsiai 87001-87427","Ukmerge 20001-20195", "Utena 28001-28503" };
        String[] leedu3 = {"Muu Leedu"};

        String[][] leedu = {leedu1,leedu2,leedu3};

        lava2 = new Stage();
        linnad = new GridPane();
        lava2.setTitle("Hinnakalkulaator");
        lava2.getIcons().add(new Image("unnamed.png"));
        linnad.setGridLinesVisible(false);

        tsoon1 = new Button("Tsoon 1");
        tsoon2 = new Button("Tsoon 2");
        tsoon3 = new Button("Tsoon 3");

        linnad.add(tsoon1,1,0);
        linnad.add(tsoon2,2,0);
        linnad.add(tsoon3,3,0);


        for (int j = 0; j < leedu.length; j++) {
            for (int i = 0; i < leedu[j].length; i++) {
                linnad.add(new Label(leedu[j][i]), j + 1, i + 1);
            }
        }
        linnad.setVgap(10);
        linnad.setHgap(10);

        linnad.setStyle("-fx-background-color: #FFFFFF;");

        stseen1 = new Scene(linnad);
        lava2.setScene(stseen1);
        lava2.show();
    }


}
