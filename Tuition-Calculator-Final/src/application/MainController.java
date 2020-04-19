/**
 * Sample Skeleton for 'Main.fxml' Controller Class
 */

package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class MainController {
	
	@FXML // fx:id="mainPane"
    private AnchorPane mainPane;

    @FXML // fx:id="textTuition"
    private Text textTuition; // Value injected by FXMLLoader

    @FXML // fx:id="textField1"
    private TextField textField1; // Value injected by FXMLLoader handles text for tuition

    @FXML // fx:id="textField2"
    private TextField textField2; // Value injected by FXMLLoader handles text for semesters

    @FXML // fx:id="textField3"
    private TextField textField3; // Value injected by FXMLLoader handles text for amount paid

    @FXML // fx:id="button1"
    private Button button1; // Value injected by FXMLLoader handles calculate

    @FXML // fx:id="button2"
    private Button button2; // Value injected by FXMLLoader handles clear
    
    @FXML // fx:id="tuitionChart"
    private BarChart<String, Integer> tuitionChart; // Value injected by FXMLLoader

    @FXML // fx:id="textLeft"
    private Text textLeft; // Value injected by FXMLLoader 

    @FXML // fx:id="textRate"
    private Text textRate; // Value injected by FXMLLoader

    @FXML // fx:id="textGpa"
    private Text textGpa; // Value injected by FXMLLoader

    @FXML // fx:id="textField4"
    private TextField textField4; // Value injected by FXMLLoader handles text for inflation rate

    @FXML // fx:id="checkBox1"
    private CheckBox checkBox1; // Value injected by FXMLLoader

    @FXML // fx:id="button3"
    private Button button3; // Value injected by FXMLLoader handles going to course page
    
    
    @FXML
    public void handleCalculate(ActionEvent event) {
    	double tuition = Double.parseDouble(textField1.getText());
    	int semesters = Integer.parseInt(textField2.getText());
    	double amountPaid = Double.parseDouble(textField3.getText());
    	double rate = Double.parseDouble(textField4.getText()) * 0.01;
    	double total = tuition;
    	double interest = 0;
    	
    	
    	for(int i = 0; i < semesters; i++) {
    		interest = total * rate;
    		total += tuition + interest;
    		XYChart.Series<String,Integer> data = new XYChart.Series<String, Integer>();
    		data.getData().add(new XYChart.Data<String, Integer>("Semester " + Integer.toString(i + 1), (int) total));
    		tuitionChart.getData().add(data);
    		data.setName("Semester " + (i +1));
    	}
    	
    	
    	//data.setName("All Semesters");
    	
    	textTuition.setText(Double.toString(total));
    	textRate.setText(Double.toString(rate * 10) + "%");
    	textLeft.setText(Double.toString(total - amountPaid));
    	
    	
    	
    	
    }
    

}
