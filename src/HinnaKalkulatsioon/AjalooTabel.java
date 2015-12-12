package HinnaKalkulatsioon;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;




/**
 * Created by Leemets on 12.12.2015.
 */
public class AjalooTabel {
    public Stage lava2;
    public Scene stseen1;
    public TableView tabel = new TableView();

    public AjalooTabel(){
        looTabel();
    }

    public void looTabel() {


        lava2 = new Stage ();
        stseen1 = new Scene(new Group());
        lava2.setTitle("Viimati saadetud saadetised");
        lava2.setWidth(400);
        lava2.setHeight(500);

        final Label nimi = new Label("Saadetised");
        nimi.setFont(new Font("Arial", 20));

        tabel.setEditable(true);

        TableColumn pakiSihtkoht = new TableColumn("Riik");
        TableColumn tsoon = new TableColumn("Tsoon");
        TableColumn kaal = new TableColumn("Paki kaal");
        TableColumn hind = new TableColumn("Hind");


        tabel.getColumns().addAll(pakiSihtkoht,tsoon,kaal,hind);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10,0,0,10));
        vbox.getChildren().addAll(nimi,tabel);

        ((Group)stseen1.getRoot()).getChildren().addAll(vbox);

        lava2.setScene(stseen1);
        lava2.show();


    }
}
