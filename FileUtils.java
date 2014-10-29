import io.*;
import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class FileUtils
{

	//Method for choosing option 1. returns number of students read.
	public static int loadFile( Student[] studentArray)
	{
		boolean tryAgain;
		int numRead = 0;
		String inputFile;		
		do
		{
			Scanner stringInput = new Scanner(System.in);
			System.out.print("Enter input file name:>");
			inputFile = stringInput.nextLine();
			tryAgain = false;
			try
			{
				numRead = fillFromFile( studentArray, inputFile);
				SearchAndSort.mergeSort( studentArray, numRead);
			}
			catch( IllegalArgumentException e)
			{
				int selection = 0;
				do
				{
					try
					{
						Scanner intInput = new Scanner(System.in);
						System.out.println("1\t- Try Again");
						System.out.println("2\t- Back to Main Menu");
						System.out.print("Choice:>");
						selection = intInput.nextInt();
						if( selection == 1)
						{
							tryAgain = true;
						}
					}
					catch( InputMismatchException e1)
					{
						System.out.println("Please choose integer option 1 or 2");
					}
				} while( selection != 1 && selection != 2);
			}
		} while (tryAgain);
		return numRead;
	}

	//opens and loops through file, fills array of students, returns number read
	//reference lecture 2, slide 25
	private static int fillFromFile( Student[] studentArray, String inputFile)
	{
		FileInputStream fileStrm = null;
		InputStreamReader rdr;
		BufferedReader bufRdr;
		int num;
		String line;
		num = 0;
		try
		{
			fileStrm = new FileInputStream( inputFile);
			rdr = new InputStreamReader( fileStrm);
			bufRdr = new BufferedReader(rdr);

			line = bufRdr.readLine();
			while( line != null)
			{
				num++;
				studentArray[num - 1] = new Student( line);
				line = bufRdr.readLine();
			}
			fileStrm.close();
		}
		catch( IOException e)
		{
			if(fileStrm != null)
			{
				try
				{
					fileStrm.close();
				}
				catch (IOException e2)
				{}
			}
			System.out.println("Error in processing file: " + e.getMessage());
			throw new IllegalArgumentException("INVALID FILE NAME");
		}
		return num;
	}

}