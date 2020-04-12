/*
 * File name: FileReader.java
 *Programmer: Christina Overton
 * ULID: caovert
 * 
 *Date: Apr 10, 2020
 *
 *Class: IT 168
 *Lecture Section: 22
 *Lecture Instructor: Kevin Schaefer
 *Lab Section: 23
 *Lab Instructor: Saurah Bansal
 */
package IT226;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * IT 168
 *
 * @author Christina Overton
 *
 */
public class FileReader
{
	public static void main (String[] args) {
	String fileName = "D:/Project2/src/IT226/relationships.csv";
	File file = new File(fileName);
	try {
	
		Scanner inputStream = new Scanner(file );
		while (inputStream.hasNext())
		{
			String data= inputStream.next();
			ArrayList<String> arrayValues = new ArrayList<String>();
			String[] valuesInCvs= data.split(",");
			if (valuesInCvs.length ==2) {
				//arrayValues.add(new String(valuesInCvs[0]));
				//need to make constructors to add values in correct format
				System.out.print("o");
			}
			else if(valuesInCvs.length == 4) {
				// add data to relationships
				System.out.print("a");
			}
			
		}
		inputStream.close();
	}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}
}
	}
