import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
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
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String x = null;
		int c = 1;
		Scanner keyboard = new Scanner(System.in);
		ArrayList<String> TermsCUI = new ArrayList<String>();
		ArrayList<String> TermsSTR = new ArrayList<String>();
		ArrayList<String> CUI = new ArrayList<String>();
		ArrayList<String> RELA = new ArrayList<String>();
		ArrayList<String> CUI2 = new ArrayList<String>();
		ArrayList<String> STR2 = new ArrayList<String>();
		ArrayList<String> Files = new ArrayList<String>();
		String[] cui = null;
		String[] str = null;
		String[] cui1 = null;
		String[] rela = null;
		String[] cui2 = null;
		String[] str2 = null;
		while(c > 0)
		{
			System.out.println(Menu());
			x = keyboard.nextLine();
			int n = 0;
			switch(x)
			{
				case "a":
				case "A":
					System.out.println("What is the name of the file you would like to add include extension");
					String t = keyboard.nextLine();
					if (Files.contains(t) == false)
					{
					Files.add(t);
					File file = new File(t);
					try {
						Scanner out = new Scanner(file);
						int i = 0;
						while( out.hasNextLine())
						{
							
							String add = out.nextLine();
							StringTokenizer tokens = new StringTokenizer(add,",");
							
							if (t.equals("Terms.csv"))
							{
								while (tokens.hasMoreTokens())
								{
									TermsCUI.add(tokens.nextToken());
									TermsSTR.add(tokens.nextToken());
								}
								
							}
							else
							{
								while (tokens.hasMoreTokens())
								{
									CUI.add(tokens.nextToken());
									RELA.add(tokens.nextToken());
									CUI2.add(tokens.nextToken());
									STR2.add(tokens.nextToken());
								}
								
							}
							i++;
							//System.out.println(add);
							//System.out.println("We have read " + i + " lines from the file");
						}
						if (n == 0)
						{
							if(t.equals("Terms.csv"))
							{
								 cui = TermsCUI.toArray(new String[0]);
								 str = TermsSTR.toArray(new String[0]);
								 n = 1;
							}
							
						}
						if (t.equals("Terms.csv") == false)
						{
							cui1 = CUI.toArray(new String[0]);
							cui2 = CUI2.toArray(new String[0]);
							rela = RELA.toArray(new String[0]);
							str2 = STR2.toArray(new String[0]);
						}
						
						
						System.out.println("We have read " + i + " lines from the file\n");

						} 
					catch (FileNotFoundException e) {
					System.out.println("This file cannot be found\n");
						}
					}
					else
					{
						System.out.println("File already added\n");
					}
					break;
				case "R":
				case "r":
					System.out.println("What relationship are you trying to save?");
					String input = keyboard.nextLine();
					System.out.println("");
					File file = new File("C:\\Users\\dranz\\Downloads\\omg.csv");
					PrintWriter pw = new PrintWriter(file);
					StringBuilder sb = new StringBuilder();
					for (int i = 0; i < rela.length;i++)
					{
						String output = "";
						if (rela[i].equals(input))
						{
							for (int g = 0; g < cui.length; g++)
							{
								if(cui[g].equals(cui1[i]))
								{
									//System.out.print(str[g] + ",");
									output += str[g] + ",";
								}
//								output += rela[i] + ",";
//								output += str2[i] + "";
//								File file = new File("C:\\Users\\dranz\\Downloads\\news3.csv");
//								PrintWriter pw = new PrintWriter(file);
//								StringBuilder sb = new StringBuilder();
//								sb.append(output);
//								pw.write(sb.toString());
//								pw.close();
							}
							output += rela[i] + ",";
							output += str2[i] + "";
							sb.append(output);
							sb.append("\n");
//							pw.write(sb.toString());
//							pw.close();
						//	System.out.println(output);
						}
					}
					pw.write(sb.toString());
					pw.close();
					
					break;
				case "T":
				case "t":
					System.out.println("What medical term are you trying to save?");
					String name = keyboard.nextLine();
					String code = null;
					File file2 = new File("C:\\Users\\dranz\\Downloads\\omg.csv");
					PrintWriter dw = new PrintWriter(file2);
					StringBuilder ab = new StringBuilder();
					//System.out.println("");
					for(int i = 0; i < cui.length; i++)
					{
						
						if(str[i].equals(name))
						{
							code = cui[i];
							//output2 += name + ",";
							
						}
					}
					for (int g = 0; g < rela.length; g++)
					{
						if (cui1[g].equals(code))
						{
							String output2 = "";
							output2 += name + ",";
							output2 += rela[g] + ",";
							output2 += str2[g] + "";
							System.out.println(output2);
							ab.append(output2);
							ab.append("\n");
							
						}
						if (cui2[g].equals(code))
						{
							String output2 = "";
							output2 += name + ",";
							output2 += rela[g] + ",";
							output2 += str2[g] + "";
							System.out.println(output2);
							ab.append(output2);
							ab.append("\n");
						}
					}
					dw.write(ab.toString());
					dw.close();
				//	System.out.println("output2 = :" + output2);
					//System.out.println(output2);
					break;
				case "e":
					c = 0;
					System.out.println("\nDone");
					break;
				case "E":
					c = 0;
					System.out.println("\nDone");
					break;
				default:
					System.out.println("Invalid command");
			}
		}
		keyboard.close();
	}
	public static String Menu()
	{
		return "Add Data('a' or 'A')\nSave data for a relationship('R' or 'r')\nSave data for a medical terms('T' or 't')\nExit the program('e' or 'E')";
		
	}

}
