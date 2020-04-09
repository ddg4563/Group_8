package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class SampleController {

    @FXML
    private Button button2;

    @FXML
    private WebView myView;
    @FXML
    private Button button1;
    
    private WebEngine engine;
    
    public void init() {
    	System.out.println("fired");
    	this.engine = this.myView.getEngine();
    	this.engine.load("https://www.google.com/search?rlz=1C1CHFX_enUS894&ei=2haBXqCiJtLEsAXb7ZLYBQ&q=utsa+student+loans+and+scholarships&oq=utsa+student+loans+and+sc&gs_lcp=CgZwc3ktYWIQAxgAMgUIIRCgATIFCCEQoAE6BAgAEEc6BggAEBYQHjoFCAAQzQI6BQghEKsCUMkcWNEvYJ0-aABwAngAgAFFiAGkA5IBATeYAQCgAQGqAQdnd3Mtd2l6&sclient=psy-ab");
    	this.myView.setZoom(0.4);
//    	myView.getEngine().load("yahoo.com");
    }

}
