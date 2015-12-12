package HinnaKalkulatsioon;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
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
        lava1 = new Stage();
        pane = new Pane();
        stseen1 = new Scene(pane, 300, 300);
        lava1.setScene(stseen1);
        lava1.show();

        riigivalik = new ChoiceBox(FXCollections.observableArrayList("Estonia", "Latvia", "Lithuania"));

        pane.getChildren().addAll(riigivalik);
    }
    public void valikuTegemine() {

        riigivalik.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue.equals("Estonia")){
                    lava1.close();
                    riik= riigivalik.getValue().toString();
                    new Estonia();

                }else if (newValue.equals("Latvia")){
                    lava1.close();
                    riik= riigivalik.getValue().toString();
                    new Latvia();
                    
                }else if (newValue.equals("Lithuania")){
                    lava1.close();
                    riik= riigivalik.getValue().toString();
                    new Lithuania();
                }

            }
        });


    }

}
