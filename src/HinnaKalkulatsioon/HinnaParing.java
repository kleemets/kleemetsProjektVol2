package HinnaKalkulatsioon;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.regex.Pattern;

/**
 * Created by Leemets on 2.12.2015.
 */
public class HinnaParing {
    public TextField kaal;
    public  static String sisestatudKaal;
    double reaalKaal;
    public Button ok;
    public static Stage lava3;
    public static VBox vb;
    public static Scene stseen3;

    //Eelnevast klassist on kaasa antud vastav riik ja tsoon
    public HinnaParing(String a, String t){
        kaaluKysimine();
        //riigi ja tsooni edastamine antud meetodisse
        pealeSisestamist(a, t);

    }
    public void kaaluKysimine() {

        lava3 = new Stage();
        vb =  new VBox();
        vb.setSpacing(7);
        Label l = new  Label ("Sisesta paki kaal");
        kaal = new TextField();
        kaal.setPromptText ("Palun sisestage kaal vahemikus 0-1000");
        kaal.setFocusTraversable(false);

        lava3.setTitle("Hinnakalkulaator");
        lava3.getIcons().add(new Image("unnamed.png"));
        ok = new Button("OK");
        vb.setStyle("-fx-background-color: #FFFFFF;");

        vb.setSpacing(10);
        vb.getChildren().addAll(l,kaal,ok);

        stseen3 = new Scene(vb,300,125);
        lava3.setScene(stseen3);
        lava3.show();

    }

    public void pealeSisestamist(String s, String r){

        //Kaalu sisestamine ja ok nupu vajutamine
        ok.setOnAction(event -> {
            sisestatudKaal = new String();
            sisestatudKaal = kaal.getText();

            //Sisestatud kaalu kontrollimine,kas on jäetud tühjaks
            if (kaal.getText().trim().isEmpty()) {
                Stage  viga = new Stage();
                Pane pane1 = new Pane();
                pane1.setPrefSize(300,100);
                Label veaTeade = new Label("Palun sisesta kaal!!");
                veaTeade.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                viga.setTitle("Viga!");
                veaTeade.setTranslateY(40);
                veaTeade.setTranslateX(65);

                pane1.setStyle("-fx-background-color: #fa0205;");
                Scene stseen = new Scene(pane1);
                pane1.getChildren().addAll(veaTeade);
                viga.setScene(stseen);
                viga.show();

            //Sisestatud kaalu kontrollimine, kas on sisestatud täht või sõnad
            }else if (sisestatudKaal.matches("[a-zA-Z\\_]+"))  {
                Stage  viga = new Stage();
                Pane pane1 = new Pane();
                pane1.setPrefSize(300,100);
                Scene stseen = new Scene(pane1);
                Label veaTeade = new Label("Palun sisesta kaal numbrites!!");
                veaTeade.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                viga.setTitle("Viga!");

                pane1.setStyle("-fx-background-color: #fa0205;");

                veaTeade.setTranslateY(40);
                veaTeade.setTranslateX(30);
                pane1.getChildren().addAll(veaTeade);
                viga.setScene(stseen);
                viga.show();

            //Sisestatud kaalu kontrollimine, kas on sisestatud muid märke "," või "-"
            }else if (sisestatudKaal.contains(",") || sisestatudKaal.contains("-")) {
                Stage  viga = new Stage();
                Pane pane1 = new Pane();
                pane1.setPrefSize(300,100);
                Label veaTeade = new Label("Palun sisesta kaal formaadis 0.0!");
                veaTeade.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                viga.setTitle("Viga!");
                veaTeade.setTranslateY(40);
                veaTeade.setTranslateX(40);

                pane1.setStyle("-fx-background-color: #fa0205;");
                Scene stseen = new Scene(pane1);
                pane1.getChildren().addAll(veaTeade);
                viga.setScene(stseen);
                viga.show();


                //Kui kõik sisestatud andmed on õiged, siis teisendab saadud tulemuse Double-ks
            }else {

                reaalKaal=Double.parseDouble(sisestatudKaal);
                //Kontrollib, kas sisestatud kaal jääb vahemikku 0-1000kg
                if (reaalKaal> 1000){
                    Stage  viga = new Stage();
                    Pane pane1 = new Pane();
                    pane1.setPrefSize(300,100);
                    Label veaTeade = new Label("Palun sisesta kaal vahemikus 0-1000!");
                    veaTeade.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                    viga.setTitle("Viga!");
                    veaTeade.setTranslateY(40);
                    veaTeade.setTranslateX(20);

                    pane1.setStyle("-fx-background-color: #fa0205;");
                    Scene stseen = new Scene(pane1);
                    pane1.getChildren().addAll(veaTeade);
                    viga.setScene(stseen);
                    viga.show();
                }else {
                importJson j = null;
                try {
                    j = new importJson();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
                try {
                    //Eelnevalt salvestatud kaalu, riigi ja tsooni edastamine importJson klassi ja seal olevasse jsnonistKysimine meetodisse.
                    j.jsonistKysimine(reaalKaal, s, r);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                j.uusAken2();
            }
            }
        });



    }
}
