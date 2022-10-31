package a22.climoilou.sim.encours;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ApplicationFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();
        VBox bouttonVbox = new VBox();

        bouttonVbox.getChildren().add(root);

        root.setSpacing(25);
        Button boutton = new Button("adam aime les bites");
        Button bouttonFif = new Button("adam aime les fif");
        Button bouttonJsp = new Button("adam aime kNFLDSNF");

        Label label = new Label("pcq yer fif");


        root.setPadding(new Insets(50));
        root.setAlignment(Pos.CENTER);
        bouttonVbox.setAlignment(Pos.CENTER);
        boutton.setPadding(new Insets(5));
        boutton.setMinSize(100,40);
        bouttonFif.setMinSize(100,40);
        bouttonJsp.setMinSize(100,40);
        root.getChildren().addAll(bouttonVbox, label);
        bouttonVbox.getChildren().addAll(bouttonFif,bouttonJsp);

        Scene scene = new Scene(bouttonVbox);


        primaryStage.setScene(scene);

        primaryStage.setMinHeight(150);
        primaryStage.setMinWidth(150);
        primaryStage.show();

    }

    public static void main(String[] args) {
        ApplicationFX.launch();
    }
}
