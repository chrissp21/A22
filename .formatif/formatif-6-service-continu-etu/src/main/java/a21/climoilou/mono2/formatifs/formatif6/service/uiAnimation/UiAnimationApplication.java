package a21.climoilou.mono2.formatifs.formatif6.service.uiAnimation;

import a21.climoilou.mono2.formatifs.formatif6.service.flasher.FlasherAnimationService;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class UiAnimationApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();
        root.setPrefWidth(300);
        root.setAlignment(Pos.CENTER);

        Button bouton = new Button("Va et ne reviens plus !");
        TextField xTextField = new TextField("200");
        TextField yTextField = new TextField("200");
        TextField largeurTextField = new TextField("200");
        TextField longueurTextField = new TextField("200");


        //service
        WindowAnimationService windowAnimationService =  new WindowAnimationService();

        try {
            windowAnimationService.setSouhaitee(new WindowAnimationService.LocationTaille(Double.parseDouble(xTextField.getText()), Double.parseDouble(yTextField.getText()), Double.parseDouble(largeurTextField.getText()), Double.parseDouble(longueurTextField.getText())));
        } catch (Exception e){
            System.out.println("Une des valeurs est invalide");
        }

        windowAnimationService.setActuelle(new WindowAnimationService.LocationTaille(primaryStage.getX(), primaryStage.getY(), primaryStage.getWidth(), primaryStage.getHeight()));

        bouton.setOnAction(event -> {
            windowAnimationService.setPeriod(new Duration(30));


            windowAnimationService.valueProperty().addListener((a, o, n) -> {
                windowAnimationService.setActuelle(n);
            });

            windowAnimationService.restart();
        });


        root.getChildren().addAll(bouton,
                xTextField,
                yTextField,
                largeurTextField,
                longueurTextField);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch();
    }
}
