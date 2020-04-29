/*
*	
*	The Courses class provides a static HashMap
*	collection and methods to update 
*	that collection
*
*/

package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class Courses {
	
	// a HashMap variable
	private static HashMap<String, String> coursesMap = new HashMap<String, String>();

	public Courses() {
		
	}
	
	// this method loads courses from a file 
	// into the HashMap collection
	public static void loadCourses() throws Exception {
		
		File file = new File("logs.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		BufferedReader in = new BufferedReader(new FileReader(file));
		String[] tokens;
		String line;
		boolean next = true;
		
		// go through each line in a file
		// and put each course into the HashMap
		while(next)
		{
			line = in.readLine();
			
			if(line != null) {
				
				tokens = line.split(",");
				Courses.coursesMap.put(tokens[0].trim(), tokens[1].trim());
				
			}
			else {
				
				next = false;
				
			}
			
		}
		
		in.close();
	}
	
	// calculate the gpa from the courses in
	// the HashMap
	public static String gpaCalculate() {
		 double gpa = 0;
		 double count = 0;
		 
		 for(String value : Courses.coursesMap.values()) {
			 if(value.equals("A")) {
				 gpa += 4.00;
			 }
			 else if(value.equals("B")) {
				 gpa += 3.00;
			 }
			 else if(value.equals("C")) {
				 gpa += 2.00;
			 }
			 else {
				 gpa += 1.00;
			 }
			 count++;
		 }
		 
		 
		 
		 
		return String.format("%.2f", (gpa/count));
	}
	
	// calculate the number of semesters
	// from courses saved in a file
	public static int countSemesters() throws Exception {
		File file = new File("logs.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line = "";
		int count = 0;
		boolean next = true;
		
		// go through each line in a file
		while(next)
		{
			line = in.readLine();
			
			if(line != null) {
				
				count++;
				
			}
			else {
				
				next = false;
				
			}
			
		}
		
		int semesters = (int) Math.ceil(count / 4);
		
		in.close();
		
		return semesters;
		
	}

	// getter for cousesMap
	public static HashMap<String, String> getCoursesMap() {
		return Courses.coursesMap;
	}

	// setter for coursesMap
	public static void setCoursesMap(HashMap<String, String> coursesMap) {
		Courses.coursesMap = coursesMap;
	}
	
	
}
