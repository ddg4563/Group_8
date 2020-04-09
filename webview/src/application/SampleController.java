package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class SampleController {

    @FXML
    private WebView myView;

    @FXML
    private Button button1;
    
    private WebEngine engine;
    
    public void init() {
    	System.out.println("fired");
    	this.engine = this.myView.getEngine();
    	this.engine.load("https://www.google.com");
    	this.myView.setZoom(0.8);
    }


}
