/**
 *  The CoursesController class provides methods for the Courses.fxml
 *  gui objects
 */

package application;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CoursesController implements Initializable {
	
	@FXML
    private AnchorPane coursePane;

    @FXML // fx:id="courseField1"
    private TextField courseField1; // Value injected by FXMLLoader

    @FXML // fx:id="courseField2"
    private TextField courseField2; // Value injected by FXMLLoader

    @FXML // fx:id="courseField3"
    private TextField courseField3; // Value injected by FXMLLoader

    @FXML // fx:id="courseField4"
    private TextField courseField4; // Value injected by FXMLLoader

    @FXML // fx:id="gradeBox1"
    private ChoiceBox<String> gradeBox1; // Value injected by FXMLLoader

    @FXML // fx:id="gradeBox2"
    private ChoiceBox<String> gradeBox2; // Value injected by FXMLLoader

    @FXML // fx:id="gradeBox3"
    private ChoiceBox<String> gradeBox3; // Value injected by FXMLLoader

    @FXML // fx:id="gradeBox4"
    private ChoiceBox<String> gradeBox4; // Value injected by FXMLLoader

    @FXML // fx:id="creditField1"
    private TextField creditField1; // Value injected by FXMLLoader

    @FXML // fx:id="creditField2"
    private TextField creditField2; // Value injected by FXMLLoader

    @FXML // fx:id="creditField3"
    private TextField creditField3; // Value injected by FXMLLoader

    @FXML // fx:id="creditField4"
    private TextField creditField4; // Value injected by FXMLLoader

    @FXML // fx:id="saveButton"
    private Button saveButton; // Value injected by FXMLLoader
    
    @FXML
    private Button btnMain;
    
    // save the course information that was entered
    @FXML
    public void saveInfo() throws Exception {
    	
    	if(!courseField1.getText().equals("")) {
    		TuitionModel.saveInfo(courseField1.getText(), gradeBox1.getValue(), creditField1.getText());
    	}
    	
    	if(!courseField2.getText().equals("")) {
    		TuitionModel.saveInfo(courseField2.getText(), gradeBox2.getValue(), creditField2.getText());
    	}
    	
    	if(!courseField3.getText().equals("")) {
    		TuitionModel.saveInfo(courseField3.getText(), gradeBox3.getValue(), creditField3.getText());
    	}
    	
    	if(!courseField4.getText().equals("")) {
    		TuitionModel.saveInfo(courseField4.getText(), gradeBox4.getValue(), creditField4.getText());
    		
    	}
    	
		
		courseField1.clear();
		courseField2.clear();
		courseField3.clear();
		courseField4.clear();
		
		creditField1.clear();
		creditField2.clear();
		creditField3.clear();
		creditField4.clear();
		
		gradeBox1.getSelectionModel().clearSelection();
		gradeBox2.getSelectionModel().clearSelection();
		gradeBox3.getSelectionModel().clearSelection();
		gradeBox4.getSelectionModel().clearSelection();
		
    	
    }
    
    // go to the page main
    @FXML
    void handleClickMain(ActionEvent event) throws IOException {
    	coursePane = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(coursePane);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	List<String> list = new ArrayList<String>();
    	list.add("A");
    	list.add("B");
    	list.add("C");
    	list.add("F");
    	
		gradeBox1.getItems().addAll(list);
		gradeBox2.getItems().addAll(list);
		gradeBox3.getItems().addAll(list);
		gradeBox4.getItems().addAll(list);
		
	}
     
 
}
