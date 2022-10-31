package formatif7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppFormatif7 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("formatif7.fxml"));
		primaryStage.setScene(new Scene(loader.load()));
		primaryStage.setMinHeight(600);
		primaryStage.setMinWidth(1000);

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
