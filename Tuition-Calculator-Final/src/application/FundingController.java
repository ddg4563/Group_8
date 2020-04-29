/**
 * The fundingController class provides methods for the funding.fxml
 * gui objects
 */

package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class FundingController {
	
	@FXML
    private AnchorPane fundingPane;

    @FXML
    private WebView myView;

    @FXML
    private Button button1;
    
    private WebEngine engine;
    
    @FXML
    private Button button2;
    
    // loads the url into the WebView
    public void init() {
    	this.engine = this.myView.getEngine();
    	this.engine.load("https://www.google.com/search?q=tuition+funding+sources&rlz=1C1CHBF_enUS894US894&oq=tuition+funding+&aqs=chrome.0.0j69i57j0l4.7012j0j4&sourceid=chrome&ie=UTF-8");
    	this.myView.setZoom(0.8);
    }
    
    // go to main page 
    @FXML
    void handleClickMain(ActionEvent event) throws IOException {
    	fundingPane = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(fundingPane);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }


}
