package HinnaKalkulatsioon;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * Created by Leemets on 2.12.2015.
 */
public class Aken {
    public Stage lava1;
    public Pane pane;
    public Scene stseen1;
    public ChoiceBox riigivalik;
    public static String riik;


    public Aken (){
        avaAken();
        valikuTegemine();

    }

    public void avaAken() {
        //Ava akna seadistamine ja pildi lisamine
        lava1 = new Stage();
        pane = new Pane();
        stseen1 = new Scene(pane, 300, 300);
        lava1.setTitle("Hinnakalkulaator");
        lava1.getIcons().add(new Image("unnamed.png"));

        pane.setStyle("-fx-background-color: #FFFFFF;");
        ImageView pilt = new ImageView("DPD.png");
        pilt.setFitHeight(50);
        pilt.setFitWidth(120);
        pilt.setX(175);


        pane.getChildren().addAll(pilt);

        lava1.setScene(stseen1);
        lava1.show();

        Button ajalugu = new Button("Näita saadetiste ajalugu");
        ajalugu.setTranslateX(150);
        ajalugu.setTranslateY(250);

        //Kui kasutaja vajutab ajaloo nuppu, siis kuvab kasutajale info, milliseid pakke on ta varem saatnud.
        ajalugu.setOnAction(event -> {
            new AjalooTabel();
        });

        Label vali = new Label("Vali saadetise sihtriik");
        vali.setFont(new Font("Arial", 15));
        vali.setTranslateY(40);
        vali.setTranslateX(3);

        riigivalik = new ChoiceBox(FXCollections.observableArrayList("Eesti", "Läti", "Leedu"));
        riigivalik.setTranslateY(60);
        riigivalik.setTranslateX(5);

        pane.getChildren().addAll(riigivalik,ajalugu,vali);
    }
    public void valikuTegemine() {

        //Kasutaja saab valida kolme riigi vahel, kuhu ta soovib pakki saata.
        riigivalik.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue.equals("Eesti")){
                    lava1.close();

                    // Kui valik tehtud, siis salvestab programm selle Stringina ära, et seda pärast kasutada andmebaasi salvestamisel
                    riik= riigivalik.getValue().toString();
                    new Estonia();

                }else if (newValue.equals("Läti")){
                    lava1.close();
                    riik= riigivalik.getValue().toString();
                    new Latvia();
                    
                }else if (newValue.equals("Leedu")){
                    lava1.close();
                    riik= riigivalik.getValue().toString();
                    new Lithuania();
                }

            }
        });


    }

}
