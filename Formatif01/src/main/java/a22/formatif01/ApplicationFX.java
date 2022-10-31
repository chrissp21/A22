package a22.formatif01;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class ApplicationFX extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox left = new VBox();
        VBox right = new VBox();
        HBox root = new HBox();

        HBox boxMax = new HBox();
        HBox boxMin = new HBox();
        HBox boxResul = new HBox();
        HBox boxRecherche = new HBox();
        HBox boxList = new HBox();


        TextField tfMinimum = new TextField();
        tfMinimum.setMinWidth(30);
        TextField  tfMaximum = new TextField();
        tfMaximum.setMinWidth(30);
        TextField tfResultat = new TextField();
        tfResultat.setMinWidth(30);
        tfResultat.setDisable(true);

        Label labelMin = new Label("minimum");
        labelMin.setMinWidth(80);
        Label labelMax = new Label("maximum");
        labelMax.setMinWidth(80);
        Label labeResul = new Label("résultats");
        labeResul.setMinWidth(80);

        ListView listView = new ListView();
        listView.setMinSize(100, 100);

        Button butRecherche = new Button("rechercher");
        butRecherche.setMinWidth(60);

        File file = new File("C:\\Users\\Chris\\School\\A22\\Prog\\git\\.formatif\\Formatif01\\src\\main\\Ressources\\math.jpeg");
        String localUrl = file.toURI().toURL().toString();
        Image math = new Image(localUrl);

        ImageView mathIMG = new ImageView();
        mathIMG.setImage(math);

        boxList.getChildren().add(listView);

        boxRecherche.getChildren().add(butRecherche);
        boxRecherche.setAlignment(Pos.CENTER);

        boxMax.getChildren().addAll(labelMax, tfMaximum);


        boxMin.getChildren().addAll(labelMin, tfMinimum);


        boxResul.getChildren().addAll(labeResul, tfResultat);

        left.setSpacing(30);
        right.setSpacing(30);
        root.setSpacing(30);

        left.setPadding(new Insets(30, 0, 30, 30));
        right.setPadding(new Insets(30, 30, 30, 30));



        boxList.setHgrow(listView, Priority.ALWAYS);
        right.setVgrow(listView, Priority.ALWAYS);

        left.getChildren().addAll(boxMin, boxMax, boxRecherche, mathIMG);
        right.getChildren().addAll(boxResul, boxList);



        AnchorPane anchorPane = new AnchorPane();
        AnchorPane.setBottomAnchor(right, 10.0);
        AnchorPane.setRightAnchor(right, 10.0);
        anchorPane.getChildren().addAll(right);



        root.getChildren().addAll(left, right);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Chercheur de nombres premiers");
        primaryStage.show();
    }

    public static void main(String[] args) {
        ApplicationFX.launch();
    }
}
