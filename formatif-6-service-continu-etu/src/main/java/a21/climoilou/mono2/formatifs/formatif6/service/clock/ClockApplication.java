package a21.climoilou.mono2.formatifs.formatif6.service.clock;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.swing.text.DateFormatter;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;


public class ClockApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label root = new Label("00:00:00");
        root.setPrefWidth(150);
        root.setAlignment(Pos.CENTER);
        startClock(root);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }

    private void startClock(Label clockLabel) {
        ClockService clockService = new ClockService();

        clockService.valueProperty().addListener((a, o, n) -> {
            if (n != null) {
                String pattern = "dd:MM:YYYY" + " :) " + "HH:mm:ss";
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);

                clockLabel.setText(n.format(dateTimeFormatter));
            }
        });
        clockService.restart();
    }


    public static void main(String[] args) {
        launch();
    }
}
