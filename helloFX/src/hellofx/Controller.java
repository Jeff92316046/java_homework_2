package hellofx;
import java.net.URL;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.fxml.Initializable;

public class Controller implements Initializable{

    @FXML
    private Label label;
    @FXML
    private TextField textfield;
    @FXML
    private Button button;
    @Override


    public void initialize(URL location, ResourceBundle resources) {

        // TODO (don't really need to do anything here).

    }
    public String get_text(){
        return textfield.getText();
    }
    public void press_button(ActionEvent event){
        label.setText(get_text());
    }
    
}

//public class 