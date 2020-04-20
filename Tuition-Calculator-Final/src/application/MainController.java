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
    	double total = 0;
    	double interest = 0;
    	XYChart.Series<String,Integer> data = new XYChart.Series<String, Integer>();
    	
    	for(int j = 0; j < tuitionChart.getData().size(); j++) {
    		tuitionChart.getData().clear();
    	}
    	
    	for(int i = 0; i < semesters; i++) {
    		if(((i)/2) == 0)
    		{
    			//interest = total * rate;
    			tuition = tuition + (tuition * rate);
    			System.out.println(tuition);
    		}
    		total += tuition;
    		
    		
    		data.getData().add(new XYChart.Data<String, Integer>("Semester " + Integer.toString(i + 1), (int) total));
    		
    		data.setName("Semester " + (i +1));
    	}
    	
    	
    	//data.setName("All Semesters");
    	tuitionChart.layout();
    	tuitionChart.getData().addAll(data);
    	tuitionChart.setLegendVisible(false);
    	textTuition.setText(String.format("$%.2f",total));
    	textRate.setText(Double.toString((rate * 100)) + "%");
    	textLeft.setText(String.format("$%.2f",(total - amountPaid)));
    	
    	
    	
    	
    }
    
    
    @FXML
    public void handleClear(ActionEvent event) {
    	textField1.clear();
    	textField2.clear();
    	textField3.clear();
    	textField4.clear();
    	for(int j = 0; j < tuitionChart.getData().size(); j++) {
    		tuitionChart.getData().clear();
    	}
    	
    	textTuition.setText("$00.00");
    	textLeft.setText("$00.00");
    	textRate.setText("0.0%");
    	textGpa.setText("0.00");
    	
    	
    }
    

}
