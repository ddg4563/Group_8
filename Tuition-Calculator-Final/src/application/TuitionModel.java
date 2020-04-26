/*
*	
*	The TuitionModel class provides methods for use in
*	Controller classes
*
*
*/

package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

public class TuitionModel {
	
	// save info from strings passed into the method 
	// to a HashMap and a file
	public static void saveInfo(String str1, String str2, String str3) throws Exception {
		boolean append = true;
    	String line;
		HashMap<String, String> map = Courses.getCoursesMap();
		BufferedWriter out = new BufferedWriter(new FileWriter("logs.txt", append));
		
		map.put(str1, str2);
		line = str1 + "," + str2 + "," + str3 + "\n";
		out.write(line);
		
		
		// update the HashMap collection and inventory file
		// and close BufferedWriter
		Courses.setCoursesMap(map);
		out.close();
		    	
		
	}
	
	// calculate data passed in to the method
	// load it into a BarChart
	public static double calculate(double d1, int num1, double d2, double d3, BarChart<String, Integer> tuitionChart) {
		double total = 0;
    	XYChart.Series<String,Integer> data = new XYChart.Series<String, Integer>();
    	
    	for(int j = 0; j < tuitionChart.getData().size(); j++) {
    		tuitionChart.getData().clear();
    	}
    	
    	for(int i = 0; i < num1; i++) {
    		if(((i)/2) == 0)
    		{
    			d1 = d1 + (d1 * d3);
    		}
    		total += d1;
    		
    		
    		data.getData().add(new XYChart.Data<String, Integer>("Semester " + Integer.toString(i + 1), (int) total));
    		
    		data.setName("Semester " + (i +1));
    	}
    	
    	tuitionChart.layout();
    	tuitionChart.getData().addAll(data);
    	tuitionChart.setLegendVisible(false);
    	
    	return total;
    	
	}
	
	
	
}
