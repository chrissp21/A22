package formatif2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Formatif2 extends Application {

    private Button bouton1 = new Button("un");
    private Button bouton2 = new Button("deux");
    private Button bouton3 = new Button("trois");
    private Button bouton4 = new Button("quatre");
    private Button bouton5 = new Button("cinq");

    private String titre = "Fonctionnalité";

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Création des boutons

        bouton1.setPrefSize(50, 50);
        bouton1.setMinSize(25, 25);
        bouton1.setMaxSize(200, 200);

//		bouton2.setGraphic(loadImageView("trefle.png", 50, 50));
        bouton2.setPrefSize(50, 50);
        bouton2.setMinSize(25, 25);
        bouton2.setMaxSize(200, 200);

//		bouton3.setGraphic(loadImageView("coeur.png", 50, 100));
        bouton3.setPrefSize(50, 100);
        bouton3.setMinSize(25, 25);
        bouton3.setMaxSize(200, 200);

//		bouton4.setGraphic(loadImageView("carre.png", 100, 50));
        bouton4.setPrefSize(100, 50);
        bouton4.setMinSize(25, 25);
        bouton4.setMaxSize(200, 200);

//		bouton5.setGraphic(loadImageView("quatre.png", 100, 50));
        bouton5.setPrefSize(100, 100);
        bouton5.setMinSize(25, 25);
        bouton5.setMaxSize(200, 200);


        // Choix de la scene initiale
        primaryStage.setScene(setGridScene());


        // On crée des closure pour mettre les scènes
        CreationScene vhScene = new CreationScene() {
            @Override
            public Scene setScene() {
                return setVHScene();
            }
        };
        CreationScene borderScene = () -> setBorderScene();
        CreationScene gridScene = this::setGridScene;

        // On peut appeler directement la reference


        // Association des comportements (Action)


        this.primaryStage = primaryStage;
        primaryStage.setTitle(titre);
        primaryStage.show();
        associeDialogAuxBoutons(bouton1, bouton2, bouton3, bouton4, bouton5);
        associeDialogAnonymous(bouton4, bouton5);

        associeDialogClosure(bouton3, vhScene);
        associeDialogClosure(bouton4, borderScene);
        associeDialogClosure(bouton5, gridScene);

        showAlert("Fonctionnalité", "Foncitonnalité à venir anonymous");
    }

    private void associeDialogClosure(Button bouton, CreationScene scene) {
        bouton.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(scene.setScene());
        });
    }

    private void associeDialogAnonymous(Button... boutons) {
        String headerText = "Fonctionnalité à venir anonymous";

        for (int i = 0; i < boutons.length; i++) {
            boutons[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    showAlert(titre, headerText);
                }
            });
        }
    }

    private void associeDialogAuxBoutons(Button... boutons) {

        for (int i = 0; i < boutons.length; i++)
            boutons[i].setOnAction(new InnerAction());
    }

    private Scene setGridScene() {
        GridPane grid = new GridPane();
        grid.add(bouton1, 0, 0);
        grid.add(bouton2, 1, 0);
        grid.add(bouton3, 0, 1, 2, 1);
        grid.add(bouton4, 2, 0, 1, 2);
        grid.add(bouton5, 0, 3, 3, 1);

        return new Scene(grid, 400, 400);
    }

    private Scene setBorderScene() {
        BorderPane borderPane = new BorderPane();

        borderPane.setRight(bouton1);
        borderPane.setBottom(bouton2);
        borderPane.setTop(bouton3);
        borderPane.setLeft(bouton4);
        borderPane.setCenter(bouton5);

        BorderPane.setAlignment(bouton1, Pos.CENTER);
        BorderPane.setAlignment(bouton2, Pos.CENTER);
        BorderPane.setAlignment(bouton3, Pos.CENTER);
        BorderPane.setAlignment(bouton4, Pos.CENTER);
        BorderPane.setAlignment(bouton5, Pos.CENTER);

        return new Scene(borderPane, 400, 400);

    }

    private Scene setVHScene() {
        HBox hpane = new HBox();
        VBox vpane = new VBox();
        Label label = new Label("V H pane");


        vpane.getChildren().addAll(label, hpane);
        hpane.getChildren().addAll(bouton1, bouton2, bouton3, bouton4, bouton5);

        hpane.setHgrow(bouton1, Priority.ALWAYS);
        hpane.setHgrow(bouton2, Priority.NEVER);
        hpane.setHgrow(bouton3, Priority.ALWAYS);
        hpane.setHgrow(bouton4, Priority.SOMETIMES);
        hpane.setHgrow(bouton5, Priority.ALWAYS);

        vpane.setAlignment(Pos.TOP_CENTER);

        return new Scene(vpane, 400, 300);

    }


    public static void main(String[] args) {
        launch(args);
    }

    private ImageView loadImage(String nom, double height, double width) {
        ImageView retImageView = new ImageView(
                new Image(this.getClass().getResourceAsStream(nom), width, height, false, true));
        return retImageView;
    }

    private void showAlert(String titre, String headerText) {
        //On affiche un dialog simple avec seulement un bouton OK
        Alert simpleDialog = new Alert(Alert.AlertType.INFORMATION);
        simpleDialog.setTitle(titre);
        simpleDialog.setHeaderText(headerText);
        simpleDialog.setContentText("La fonctionnalité sera implementé dans une version ultérieure");
        simpleDialog.show();
    }

    //On programme une classe interne non statique pour gérer l'événement
    public class InnerAction implements EventHandler<ActionEvent> {

        private String headerText = "Fonctionnalité à venir inner class";


        @Override
        public void handle(ActionEvent event) {
            showAlert(titre, headerText);
        }
    }

    public interface CreationScene {
        public Scene setScene();
    }
}
