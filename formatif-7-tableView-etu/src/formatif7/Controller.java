package formatif7;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import formatif7.cell.PersonneListCell;
import formatif7.model.Personne;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

public class Controller implements Initializable {

	@FXML
	private TableView<Personne> tableView;

	@FXML
	private TableColumn<Personne, String> nomColumn;

	@FXML
	private TableColumn<Personne, String> prenomColumn;

	@FXML
	private TableColumn<Personne, Integer> ageColumn;

	@FXML
	private ListView personneList;

	// L'interface Initilizable est une alternative à la méthode @FXML initialize()
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		createTableView();
		createListView();

	}

	@FXML
	void ajoute(ActionEvent event) {

	}

	@FXML
	void efface(ActionEvent event) {

	}

	@FXML
	void modifie(ActionEvent event) {


	}

	public void createTableView() {
		// TableColumn<Personne, String> nomColumn = (TableColumn<Personne, String>)
		// tableView.getColumns().get(0);// nom
		nomColumn.setCellValueFactory(new PropertyValueFactory<Personne, String>("nom"));
		ageColumn.setCellValueFactory(new PropertyValueFactory<Personne, Integer>("age"));
		prenomColumn.setCellValueFactory(new PropertyValueFactory<Personne, String>("prenom"));

		// Conversion de l'objet à la colonne
		tableView.getItems().add(new Personne(6, "Toto", "FFF"));
		tableView.getItems().add(new Personne(18, "Lidam", "Adam"));
		tableView.getItems().add(new Personne(22, "Turgeon", "Laurence"));

		// On ajoute 3 personne par défaut
		


	}

	private void createListView() {
		// on règle la fabrique de cellules.
		personneList.getItems().add(new Personne(18, "Lidam", "Adam"));
		personneList.setCellFactory((e) -> {
			try {
				return new PersonneListCell();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});
	}

}
