package it.polito.tdp.borders;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.borders.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtAnno;

    @FXML
    private ComboBox<?> boxNazione;

    @FXML
    private TextArea txtResult;

    @FXML
    void doCalcolaConfini(ActionEvent event) {
    	this.txtResult.clear();
    	String txtAnno = this.txtAnno.getText();
    	int anno = -1;
    	if (txtAnno == null) {
    		this.txtResult.setText("Devi scrivere un anno a fianco!\n");
    		return;
    	}
    	try {
    		anno= Integer.parseInt(txtAnno);
    	}catch(NumberFormatException e) {
    		this.txtResult.setText("L'anno deve essere un numero intero valido!\n");
    	}
    	if (anno < 1816 || anno > 2006) {
    		this.txtResult.setText("Mi dispiace, non ci sono valori nel database per l'anno selezionato, "
    				+ "devi provare con un anno compreso tra il 1816 ed il 2006!\n");
    		return;
    	}
    	model.creaGrafo(anno);
    }

    @FXML
    void doSimula(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert txtAnno != null : "fx:id=\"txtAnno\" was not injected: check your FXML file 'Borders.fxml'.";
        assert boxNazione != null : "fx:id=\"boxNazione\" was not injected: check your FXML file 'Borders.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Borders.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model;
	}
}
