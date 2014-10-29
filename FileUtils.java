import io.*;
import java.io.*;
import java.util.Scanner;

public class FileUtils
{

	//Method for choosing option 1. returns number of students read.
	public static int loadFile( Student[] studentArray)
	{
		Scanner input = new Scanner(System.in);
		int numRead;
		String inputFile;
		System.out.print("Enter input file name:>");
		inputFile = input.nextLine();
		numRead = fillFromFile( studentArray, inputFile);
		SearchAndSort.mergeSort( studentArray, numRead);
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
		catch(IOException e)
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
		}

		return num;

	}

}