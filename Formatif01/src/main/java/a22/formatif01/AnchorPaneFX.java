// 420-202-H22 – TP5 – POO (2022-09-04)
// Par : Aubé, Robert (1234567) & Fortin Denis (7654321)
package a22.formatif01;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
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

public class AnchorPaneFX extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();


        VBox left = new VBox();
        HBox rightH = new HBox();

        VBox rightV = new VBox();


        HBox boxMin = new HBox();
        HBox boxMax = new HBox();

        TextField txtMin = new TextField();
        TextField txtMax = new TextField();
        TextField txtResul = new TextField();

        txtMin.setMinWidth(30);
        txtMax.setMinWidth(30);
        txtResul.setMinWidth(30);

        txtResul.setDisable(true);

        Label labelMin = new Label("minimum");
        Label labelMax = new Label("maximum");
        Label labelResul = new Label("résultat");

        labelMin.setMinWidth(80);
        labelMax.setMinWidth(80);
        labelResul.setMinWidth(80);


        File file = new File("C:\\Users\\Chris\\School\\A22\\Prog\\git\\.formatif\\Formatif01\\src\\main\\Ressources\\math.jpeg");
        String localUrl = file.toURI().toURL().toString();
        Image math = new Image(localUrl);

        ImageView mathIMG = new ImageView();
        mathIMG.setImage(math);


        ListView listView = new ListView();
        listView.setMinSize(100, 100);

        Button butRe = new Button("rechercher");

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Temps (sec)");
        yAxis.setLabel("Temperature (deg C)");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

        XYChart.Series series = new XYChart.Series();
        series.setName("Variation de la temperature");

        series.getData().add(new XYChart.Data<>(1, 35));
        series.getData().add(new XYChart.Data<>(2, 32));
        series.getData().add(new XYChart.Data<>(3, 30));
        series.getData().add(new XYChart.Data<>(4, 25));

        lineChart.getData().add(series);



        AnchorPane.setTopAnchor(left,10.0);
        AnchorPane.setTopAnchor(rightH, 10.0);
        AnchorPane.setRightAnchor(rightH, 10.0);
        AnchorPane.setLeftAnchor(left, 10.0);
        AnchorPane.setLeftAnchor(rightH, 550.0);
        AnchorPane.setBottomAnchor(rightH, 10.0);

        boxMin.getChildren().addAll(labelMin, txtMin);
        boxMax.getChildren().addAll(labelMax, txtMax);

        boxMin.setSpacing(10);
        boxMax.setSpacing(10);

        left.getChildren().addAll(boxMin, boxMax, butRe, mathIMG, lineChart);
        left.setSpacing(30);

        rightV.getChildren().addAll(txtResul, listView);
        rightV.setVgrow(listView, Priority.ALWAYS);

        rightH.getChildren().addAll(labelResul, rightV);
        rightH.setHgrow(rightV, Priority.ALWAYS);



        root.getChildren().addAll(left, rightH);
        root.setPadding(new Insets(30, 30, 30, 30));



        Scene scene = new Scene(root);
        primaryStage.setMinWidth(900.0);
        primaryStage.setMinHeight(900.0);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Chercheur de nombres premiers");
        primaryStage.show();
    }
}
