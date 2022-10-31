package exercice;

import java.util.List;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class App1 extends Application {
	private VBox root;
	private HBox topHBox;
	private HBox bottomHBox;
	private Rectangle rect;
	private Circle circle;
	private Polygon poly;
	private ImageView img;
	private ImageView imgMenu;
	private MenuBar menuBar;
	private MenuItem menuItem1;
	private CheckMenuItem menuItem2;
	private CustomMenuItem menuItem3;
	private ContextMenu contextMenu;
	private Button bouton;
	private TextArea messagesArea;
	private Button boutonMenu;
	private Slider slider;

	@Override
	public void start(Stage primaryStage) throws Exception {

		createLayerPane();

		createMenus();
		createContent();
		createContextMenu();


		ajouteGetionnaireMenu();

		// prog des événements filtre



		EventHandler<MouseEvent> showTargetColor = (MouseEvent e) -> {
			
			
		};

		EventHandler<MouseEvent> oneHandler = (MouseEvent e) -> {
			
			
		};

		EventHandler<MouseEvent> whereHandler = (MouseEvent e) -> {
			
			
		};
		
		EventHandler<MouseEvent> showEventInfo = (MouseEvent e) -> {
<<<<<<< HEAD
			System.out.println("le bouton " + e.getButton() + " a été enfoncé sur la source class " + e.getSource().getClass() + " et sur la cible class " + e.getTarget().getClass());
=======
			
>>>>>>> c4b5f5915c23435eb622a9583a7b68e9c36f02b7
			
			// e.consume();
		};

<<<<<<< HEAD
		ajouteFiltreEvenement(showEventInfo, MouseEvent.MOUSE_PRESSED, root, topHBox, bottomHBox, circle, rect, img, poly);
=======
		//ajouteFiltreEvenement();
>>>>>>> c4b5f5915c23435eb622a9583a7b68e9c36f02b7
		//ajouteGestionnaireEvenement();


		createGestionnairesBouton();


		primaryStage.setScene(new Scene(root, 800, 600));
		primaryStage.show();
	}

	public void createGestionnairesBouton() {

		

	}
	
	private void ajouteGetionnaireMenu() {
	
	
	}
	
	

	private void createMenus() {
		// ressources nécessaires
		imgMenu = new ImageView(new Image(this.getClass().getResourceAsStream("quatre.png"), 20, 20, false, false));

		HBox menuBox = new HBox();
		boutonMenu = new Button("Menu Bouton1");
		Label label = new Label("pourcentage: ");
		slider = new Slider(0, 100, 50);
		menuBox.getChildren().addAll(boutonMenu, label, slider);
		
		
		
		
		
		
		
		

	}

	public void createContextMenu() {


	}


		private Button createContent() {
		rect = new Rectangle(100.0d, 100.0d, Color.BLUE);
		//rect.setUserData("blue");

		circle = new Circle(50, Color.INDIANRED);
		//circle.setUserData("indian red");

		poly = new Polygon(50, 0, 100, 50, 50, 100, 0, 50);
		poly.setFill(Color.LIGHTGREEN);
		//poly.setUserData("light green");

		img = new ImageView(new Image(this.getClass().getResourceAsStream("quatre.png"), 100, 100, false, false));
		//img.setUserData("black and red");

		messagesArea = new TextArea();
		messagesArea.setDisable(true);// L'utilisateur ne peut pas changer le text

		bouton = new Button("aucun");

		root.getChildren().addAll( topHBox, bottomHBox, bouton, messagesArea);
		topHBox.getChildren().addAll(rect, circle);
		bottomHBox.getChildren().addAll(poly, img);
		return bouton;
	}

	private void createLayerPane() {
		root = new VBox();
		topHBox = new HBox();
		bottomHBox = new HBox();

		root.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, null)));
		root.setUserData("light gray");

		topHBox.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, null)));
		topHBox.setUserData("black");

		bottomHBox.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, null)));
		bottomHBox.setUserData("gray");

		root.setAlignment(Pos.CENTER);
		bottomHBox.setAlignment(Pos.CENTER);
		topHBox.setAlignment(Pos.CENTER);

		topHBox.setSpacing(20);
		bottomHBox.setSpacing(20);
		root.setSpacing(20);
	}


	private void ajouteGestionnaireEvenement(EventHandler handler, EventType type, Node... targets) {
		// todo bubling

	}

	private void ajouteFiltreEvenement(EventHandler handler, EventType type, Node... targets) {
		// todo filtrage
<<<<<<< HEAD
		for (Node node : targets){
			node.addEventFilter(type, handler);
		}
=======

>>>>>>> c4b5f5915c23435eb622a9583a7b68e9c36f02b7
	}

	public static void main(String[] args) {
		launch();
	}

}
