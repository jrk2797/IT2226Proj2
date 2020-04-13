import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author dranz
 *
 */
public class DataIntegration {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = null;
		int c = 1;
		Scanner keyboard = new Scanner(System.in);
		ArrayList<String> Terms = new ArrayList<String>();
		ArrayList<String> Relationships = new ArrayList<String>();
		ArrayList<String> Files = new ArrayList<String>();
		while(c > 0)
		{
			System.out.println(Menu());
			x = keyboard.nextLine();
			switch(x)
			{
				case "A":
					System.out.println("What is the name of the file you would like to add(inlcude extension");
					String t = keyboard.nextLine();
					File file = new File(t);
					int i = 0;
					try {
						Scanner out = new Scanner(file);
						
						while( out.hasNextLine())
						{
							
							String add = out.nextLine();
							System.out.println(add);
							//System.out.println("We have read " + i + " lines from the file");
						}
						
						} 
					catch (FileNotFoundException e) {
					System.out.println("This file cannot be found");
						}
					System.out.println("We have read " + i + " lines from the file");
					break;
				case "a":
					break;
				case "R":
					break;
				case "r":
					break;
				case "e":
					break;
				case "E":
					c = 0;
					break;
				default:
					System.out.println("Invalid command");
			}
		}
		
	}
	public static String Menu()
	{
		return "Add Data('a' or 'A')\nSave data for a relationship('R' or 'r')\nSave data for a medical terms('T' or 't')\nExit the program('e' or 'E')";
		
	}

}
