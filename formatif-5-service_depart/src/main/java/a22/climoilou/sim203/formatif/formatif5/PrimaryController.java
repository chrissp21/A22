package a22.climoilou.sim203.formatif.formatif5;

import a22.climoilou.sim203.formatif.formatif5.services.FichierEcritureService;
import a22.climoilou.sim203.formatif.formatif5.services.FichierLectureService;
import a22.climoilou.sim203.formatif.formatif5.services.SlowHelper;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class PrimaryController {

    private FichierEcritureService fichierEcritureService = new FichierEcritureService();
    private FichierLectureService fichierLectureService = new FichierLectureService();
    @FXML
    private Button EcritFichierButton;

    @FXML
    private Button litFichierButton;

    @FXML
    private Button EcritFichier;

    @FXML
    private TextField fichierTextField;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label messageFichierLabel;

    @FXML
    void ecritFichier(ActionEvent event) {
        String task = fichierTextField.getText();
        fichierEcritureService.setMessage(task);

//		if (fichierEcritureService.getState() != Worker.State.READY)
//			fichierEcritureService.reset();
//
//		fichierEcritureService.start();

        fichierEcritureService.setOnSucceeded((e) -> {
            fichierEcritureService.getValue();
            enableUI();
//            SlowHelper.slow(3000);
//            progressBar.setProgress(0);
//            messageFichierLabel.setText("Progrès Fichier");
        });

        fichierEcritureService.setOnCancelled((e) -> {
            enableUI();
        });

        fichierEcritureService.setOnFailed((e) -> {
            enableUI();
        });

        fichierEcritureService.progressProperty().addListener((a, o, n) -> {
            if (n != null) {
                progressBar.setProgress(n.doubleValue());
            }
        });

        fichierEcritureService.messageProperty().addListener((a, o, n) -> {
            if (n != null) {
                messageFichierLabel.setText(n);
            }
        });

        fichierEcritureService.restart();
        disableUI();
    }

    @FXML
    void litFichier(ActionEvent event) {

        fichierLectureService.setOnSucceeded(e -> {
            enableUI();
            fichierTextField.textProperty().unbind();
            fichierTextField.setText(fichierLectureService.getValue());
        });
        fichierLectureService.setOnCancelled(e -> enableUI());
        fichierLectureService.setOnFailed(e -> {
            enableUI();
        }
        );

        fichierTextField.textProperty().bind(fichierLectureService.messageProperty());
        progressBar.progressProperty().bind(fichierLectureService.progressProperty());

        fichierLectureService.restart();
        disableUI();
    }

    private void disableUI() {
        // il faut désactiver le boutons parce que les service ne sont pas multithreads
        litFichierButton.setDisable(true);
        EcritFichierButton.setDisable(true);
    }

    private void enableUI() {
        // il faut désactiver le boutons parce que les service ne sont pas multithreads
        litFichierButton.setDisable(false);
        EcritFichierButton.setDisable(false);
    }

    @FXML
    void annule(ActionEvent event) {
        fichierEcritureService.cancel();
    }

}
