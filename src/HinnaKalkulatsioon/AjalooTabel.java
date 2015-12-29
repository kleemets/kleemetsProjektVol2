package HinnaKalkulatsioon;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    public TableView<History> tabel = new TableView<>();
    static ObservableList <History> data = FXCollections.observableArrayList();

    //Klassi AjalooTabeli koostamisel võtsin näidiseks Oracle lehelt aadressilt https://docs.oracle.com/javafx/2/ui_controls/table-view.htm ja aluseks võtsin näidise 12-6
    public AjalooTabel() {

        looTabel();
    }

    public void looTabel() {

        lava2 = new Stage();
        stseen1 = new Scene(new Group());
        lava2.setTitle("Viimati saadetud saadetised");
        lava2.setWidth(400);
        lava2.setHeight(500);

        final Label nimi = new Label("Saadetised");
        nimi.setFont(new Font("Arial", 20));

        tabel.setEditable(true);

        Andmebaas a = new Andmebaas();
        data = a.getHistory();

        tabel.setItems(data);

        TableColumn pakiSihtkoht = new TableColumn("Riik");
        pakiSihtkoht.setCellValueFactory(new PropertyValueFactory<History,String>("riik"));
        pakiSihtkoht.setMinWidth(75);
        TableColumn tsoon = new TableColumn("Tsoon");
        tsoon.setCellValueFactory(new PropertyValueFactory<History,String>("tsoon"));
        tsoon.setMinWidth(75);
        TableColumn kaal = new TableColumn("Paki kaal");
        kaal.setCellValueFactory(new PropertyValueFactory<History,String>("pakiKaal"));
        kaal.setMinWidth(75);
        TableColumn hind = new TableColumn("Hind");
        hind.setCellValueFactory(new PropertyValueFactory<History, String>("hind"));
        hind.setMinWidth(75);


        final TextField addRiik = new TextField();
        addRiik.setPromptText("Riik");
        addRiik.setMaxWidth(pakiSihtkoht.getPrefWidth());
        final TextField addtsoon = new TextField();
        addtsoon.setMaxWidth(tsoon.getPrefWidth());
        addtsoon.setPromptText("Tsoon");
        final TextField addKaal = new TextField();
        addKaal.setMaxWidth(kaal.getPrefWidth());
        addKaal.setPromptText("Paki kaal");
        final TextField addHind = new TextField();
        addHind.setMaxWidth(hind.getPrefWidth());
        addHind.setPromptText("Hind");

        final Button kustuta = new Button("Kustuta andmed");
        kustuta.setTranslateY(8);
        kustuta.setTranslateX(250);
        kustuta.setOnAction(event -> {
            data.removeAll(data);
            a.kustutaAjalooTabel();
            a.sulgeYhendus();

        });

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(nimi, tabel);

        ((Group) stseen1.getRoot()).getChildren().addAll(vbox,kustuta);

        tabel.getColumns().addAll(pakiSihtkoht, tsoon, kaal, hind);

        lava2.setScene(stseen1);
        lava2.show();


    }

    public static class History {

        private final SimpleStringProperty riik;
        private final SimpleStringProperty tsoon;
        private final SimpleStringProperty pakiKaal;
        private final SimpleStringProperty hind;

        public History (String riik1, String tsoon1, String pakiKaal1, String hind){
            this.riik = new SimpleStringProperty(riik1);
            this.tsoon = new SimpleStringProperty(tsoon1);
            this.pakiKaal = new SimpleStringProperty(pakiKaal1);
            this.hind = new SimpleStringProperty(hind);
        }
        public String getRiik(){
            return riik.get();
        }
        public void setRiik (String riik1){
            riik.set(riik1);
        }

        public String getTsoon(){
            return tsoon.get();
        }
        public void setTsoon(String tsoon1){
            tsoon.set(tsoon1);
        }
        public String getPakiKaal(){
            return pakiKaal.get();
        }
        public void setPakiKaal(String pakiKaal1){
            pakiKaal.set(pakiKaal1);
        }
        public String getHind(){
            return hind.get();
        }

        public void setHind(String hind1) {
            hind.set(hind1);

        }
    }

    }
