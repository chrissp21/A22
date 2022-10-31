package formatif7.cell;

import formatif7.model.Personne;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * La cellule custom est un contrôleur javaFX et une cellule de liste. Elle
 * utilise un fichier FXML
 * 
 * @author martin
 *
 */
//Une cellule de personne qui est aussi le contrôleur du fichier FXML
public class PersonneListCell extends ListCell<Personne>{

	// private Personne personne = null;

	@FXML
	private TextField nomTextField;

	@FXML
	private TextField prenomTextField;

	@FXML
	private TextField ageTextField;

	private Parent cellRoot;// pour recevoir la racine du fichier FXML

	public PersonneListCell() throws IOException {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../personne.fxml"));
		loader.setController(this);
		cellRoot = loader.load();

		ageTextField.setEditable(false);
		prenomTextField.setEditable(false);
		nomTextField.setEditable(false);

	}

	@Override
	public void updateItem(Personne personne, boolean empty) {
		super.updateItem(personne, empty);

		if (personne == null || empty){
			setItem(null);
			setGraphic(null);
		} else {
			nomTextField.setText(personne.getNom());
			prenomTextField.setText(personne.getPrenom());
			ageTextField.setText(Integer.toString(personne.getAge()));

			setGraphic(cellRoot);
		}

	}

}
