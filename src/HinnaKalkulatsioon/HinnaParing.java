package HinnaKalkulatsioon;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

/**
 * Created by Leemets on 2.12.2015.
 */
public class HinnaParing {
    public TextField kaal;
    public  static String sisestatudKaal;
    double reaalKaal;
    public Button ok;
    public Stage lava3;


    public HinnaParing(String a, String t){
        kaaluKysimine();
        pealeSisestamist(a, t);

    }
    public void kaaluKysimine() {

        lava3 = new Stage();
        VBox vb =  new VBox();
        Label l = new  Label ("Sisesta paki kaal");
        kaal = new TextField();
        ok = new Button("OK");

        vb.getChildren().addAll(l,kaal,ok);

        Scene stseen3 = new Scene(vb);
        lava3.setScene(stseen3);
        lava3.show();

    }

    public void pealeSisestamist(String s, String r){
        ok.setOnAction(event -> {
            sisestatudKaal = new String();
            sisestatudKaal = kaal.getText();
            reaalKaal = Double.parseDouble(sisestatudKaal);
            lava3.close();


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
                j.jsonistKysimine(reaalKaal, s, r);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            j.uusAken2();

        });



    }
}
