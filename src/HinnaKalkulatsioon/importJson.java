package HinnaKalkulatsioon;

import com.google.gson.Gson;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Leemets on 2.12.2015.
 */
public class importJson {
    public double hind;
    public static String kaal;

    public importJson() throws FileNotFoundException, IllegalAccessException, NoSuchFieldException {

    }

    public void uusAken2(){
        //Hinna kuvamine samale Stage-ile, kus oli hinna pärimine.
        Label vastus2 = new Label();
        vastus2.setText("Teie paki maksumus on " + hind + "€");

        vastus2.setFont(Font.font("Arial", FontWeight.BOLD,16));
        HinnaParing.vb.getChildren().addAll(vastus2);


        HinnaParing.lava3.setScene(HinnaParing.stseen3);
        HinnaParing.lava3.show();
        HinnaParing.lava3.setOnCloseRequest(event -> {
            new Aken();
        });

        //Hinna teisendamine String-iks, et seda saaks salvestada Andmebaasi
        Double vastus = hind;
        kaal = Double.toString(vastus);

        //Vastavalt valitud riigile tsooni salvestamine
        String tsoon = new String("");
        if( Aken.riik.equals("Eesti")){
            tsoon = Estonia.viimatiValitudtsoon;
        }else if (Aken.riik.equals("Läti")){
            tsoon = Latvia.viimatiValitudtsoon;
        }else if (Aken.riik.equals("Leedu")){
            tsoon = Lithuania.viimatiValitudtsoon;
        }

        Andmebaas a = new Andmebaas();
        //Andmebaasi salvestamine
        a.saveHistory( Aken.riik, tsoon , HinnaParing.sisestatudKaal, importJson.kaal);
        a.sulgeYhendus();

    }


    public void jsonistKysimine(double s, String r, String y) throws FileNotFoundException, NoSuchFieldException, IllegalAccessException {

        //Json faili avamine
        FileReader reader = new FileReader("/Users/Leemets/Desktop/dpd.json");
        Gson gson = new Gson();

        KaaluObjekt[] andmed = gson.fromJson(reader, KaaluObjekt[].class);

        String riik = r;
        String tsoon = y;

        //Sisestatud kaalu kontrollimine, vastavalt kuhu vahemikku antud saadetis jääb. Tsükli algne näidis on saadud Krister Viirsaarelt.
        if (s <= 0.5) {
            for (int i = 0; i < andmed.length; i++) {
                if (andmed[i].kg == 0.5 ) {
                    Object riigiAndmed = andmed[i].getClass().getDeclaredField(riik).get(andmed[i]);
                    Object tsooniAndmed = riigiAndmed.getClass().getDeclaredField(tsoon).get(riigiAndmed);
                    hind = (double) tsooniAndmed;
                }
            }
        }else if (s <= 3){
            for (int i = 0; i < andmed.length; i++) {
                if (andmed[i].kg == 3 ) {
                    Object riigiAndmed = andmed[i].getClass().getDeclaredField(riik).get(andmed[i]);
                    Object tsooniAndmed = riigiAndmed.getClass().getDeclaredField(tsoon).get(riigiAndmed);
                    hind = (double) tsooniAndmed;
                }
            }
        }else if (s <= 5){
            for (int i = 0; i < andmed.length; i++) {
                if (andmed[i].kg == 5 ) {
                    Object riigiAndmed = andmed[i].getClass().getDeclaredField(riik).get(andmed[i]);
                    Object tsooniAndmed = riigiAndmed.getClass().getDeclaredField(tsoon).get(riigiAndmed);
                    hind = (double) tsooniAndmed;
                }
            }
        }else if (s <= 10){
            for (int i = 0; i < andmed.length; i++) {
                if (andmed[i].kg == 10 ) {
                    Object riigiAndmed = andmed[i].getClass().getDeclaredField(riik).get(andmed[i]);
                    Object tsooniAndmed = riigiAndmed.getClass().getDeclaredField(tsoon).get(riigiAndmed);
                    hind = (double) tsooniAndmed;
                }
            }
        }else if (s <= 15){
            for (int i = 0; i < andmed.length; i++) {
                if (andmed[i].kg == 15 ) {
                    Object riigiAndmed = andmed[i].getClass().getDeclaredField(riik).get(andmed[i]);
                    Object tsooniAndmed = riigiAndmed.getClass().getDeclaredField(tsoon).get(riigiAndmed);
                    hind = (double) tsooniAndmed;
                }
            }
        }else if (s <= 20){
            for (int i = 0; i < andmed.length; i++) {
                if (andmed[i].kg == 20 ) {
                    Object riigiAndmed = andmed[i].getClass().getDeclaredField(riik).get(andmed[i]);
                    Object tsooniAndmed = riigiAndmed.getClass().getDeclaredField(tsoon).get(riigiAndmed);
                    hind = (double) tsooniAndmed;
                }
            }
        }else if (s <= 25){
            for (int i = 0; i < andmed.length; i++) {
                if (andmed[i].kg == 25 ) {
                    Object riigiAndmed = andmed[i].getClass().getDeclaredField(riik).get(andmed[i]);
                    Object tsooniAndmed = riigiAndmed.getClass().getDeclaredField(tsoon).get(riigiAndmed);
                    hind = (double) tsooniAndmed;
                }
            }
        }else if (s <= 31.5){
            for (int i = 0; i < andmed.length; i++) {
                if (andmed[i].kg == 31.5 ) {
                    Object riigiAndmed = andmed[i].getClass().getDeclaredField(riik).get(andmed[i]);
                    Object tsooniAndmed = riigiAndmed.getClass().getDeclaredField(tsoon).get(riigiAndmed);
                    hind = (double) tsooniAndmed;
                }
            }
        }else if (s <= 50){
            for (int i = 0; i < andmed.length; i++) {
                if (andmed[i].kg == 50 ) {
                    Object riigiAndmed = andmed[i].getClass().getDeclaredField(riik).get(andmed[i]);
                    Object tsooniAndmed = riigiAndmed.getClass().getDeclaredField(tsoon).get(riigiAndmed);
                    hind = (double) tsooniAndmed;
                }
            }
        }else if (s <= 75){
            for (int i = 0; i < andmed.length; i++) {
                if (andmed[i].kg == 75 ) {
                    Object riigiAndmed = andmed[i].getClass().getDeclaredField(riik).get(andmed[i]);
                    Object tsooniAndmed = riigiAndmed.getClass().getDeclaredField(tsoon).get(riigiAndmed);
                    hind = (double) tsooniAndmed;
                }
            }
        }else if (s <= 100){
            for (int i = 0; i < andmed.length; i++) {
                if (andmed[i].kg == 100) {
                    Object riigiAndmed = andmed[i].getClass().getDeclaredField(riik).get(andmed[i]);
                    Object tsooniAndmed = riigiAndmed.getClass().getDeclaredField(tsoon).get(riigiAndmed);
                    hind = (double) tsooniAndmed;
                }
            }
        }else if (s <= 150){
            for (int i = 0; i < andmed.length; i++) {
                if (andmed[i].kg == 150 ) {
                    Object riigiAndmed = andmed[i].getClass().getDeclaredField(riik).get(andmed[i]);
                    Object tsooniAndmed = riigiAndmed.getClass().getDeclaredField(tsoon).get(riigiAndmed);
                    hind = (double) tsooniAndmed;
                }
            }
        }else if (s <= 200){
            for (int i = 0; i < andmed.length; i++) {
                if (andmed[i].kg == 200 ) {
                    Object riigiAndmed = andmed[i].getClass().getDeclaredField(riik).get(andmed[i]);
                    Object tsooniAndmed = riigiAndmed.getClass().getDeclaredField(tsoon).get(riigiAndmed);
                    hind = (double) tsooniAndmed;
                }
            }
        }else if (s <= 300){
            for (int i = 0; i < andmed.length; i++) {
                if (andmed[i].kg == 300 ) {
                    Object riigiAndmed = andmed[i].getClass().getDeclaredField(riik).get(andmed[i]);
                    Object tsooniAndmed = riigiAndmed.getClass().getDeclaredField(tsoon).get(riigiAndmed);
                    hind = (double) tsooniAndmed;
                }
            }
        }else if (s <= 400){
            for (int i = 0; i < andmed.length; i++) {
                if (andmed[i].kg == 400 ) {
                    Object riigiAndmed = andmed[i].getClass().getDeclaredField(riik).get(andmed[i]);
                    Object tsooniAndmed = riigiAndmed.getClass().getDeclaredField(tsoon).get(riigiAndmed);
                    hind = (double) tsooniAndmed;
                }
            }
        }else if (s <= 500){
            for (int i = 0; i < andmed.length; i++) {
                if (andmed[i].kg == 500 ) {
                    Object riigiAndmed = andmed[i].getClass().getDeclaredField(riik).get(andmed[i]);
                    Object tsooniAndmed = riigiAndmed.getClass().getDeclaredField(tsoon).get(riigiAndmed);
                    hind = (double) tsooniAndmed;
                }
            }
        }else if (s <= 600){
            for (int i = 0; i < andmed.length; i++) {
                if (andmed[i].kg == 600 ) {
                    Object riigiAndmed = andmed[i].getClass().getDeclaredField(riik).get(andmed[i]);
                    Object tsooniAndmed = riigiAndmed.getClass().getDeclaredField(tsoon).get(riigiAndmed);
                    hind = (double) tsooniAndmed;
                }
            }
        }else if (s <= 700){
            for (int i = 0; i < andmed.length; i++) {
                if (andmed[i].kg == 700 ) {
                    Object riigiAndmed = andmed[i].getClass().getDeclaredField(riik).get(andmed[i]);
                    Object tsooniAndmed = riigiAndmed.getClass().getDeclaredField(tsoon).get(riigiAndmed);
                    hind = (double) tsooniAndmed;
                }
            }
        }else if (s <= 800){
            for (int i = 0; i < andmed.length; i++) {
                if (andmed[i].kg == 800 ) {
                    Object riigiAndmed = andmed[i].getClass().getDeclaredField(riik).get(andmed[i]);
                    Object tsooniAndmed = riigiAndmed.getClass().getDeclaredField(tsoon).get(riigiAndmed);
                    hind = (double) tsooniAndmed;
                }
            }
        }else if (s <= 900){
            for (int i = 0; i < andmed.length; i++) {
                if (andmed[i].kg == 900 ) {
                    Object riigiAndmed = andmed[i].getClass().getDeclaredField(riik).get(andmed[i]);
                    Object tsooniAndmed = riigiAndmed.getClass().getDeclaredField(tsoon).get(riigiAndmed);
                    hind = (double) tsooniAndmed;
                }
            }
        }else if (s <= 1000){
            for (int i = 0; i < andmed.length; i++) {
                if (andmed[i].kg == 1000 ) {
                    Object riigiAndmed = andmed[i].getClass().getDeclaredField(riik).get(andmed[i]);
                    Object tsooniAndmed = riigiAndmed.getClass().getDeclaredField(tsoon).get(riigiAndmed);
                    hind = (double) tsooniAndmed;
                }
            }
        }

    }
}
class KaaluObjekt {
    double kg;
    Tsoonid estonia;
    Tsoonid latvia;
    Tsoonid lithuania;

}class Tsoonid {
    double zone1;
    double zone2;
    double zone3;
    double zone4;
}
