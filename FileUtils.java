import io.*;
import java.io.*;
import java.util.Scanner;

public class FileUtils
{

	public static void loadFile( Student[] studentArray, Scanner input)
	{
		String inputFile;
		System.out.print("Enter input file name:>");
		inputFile = input.nextLine();
		fillFromFile( studentArray, inputFile);
	}


	//opens and loops through file, fills array of students, returns number read
	//reference lecture 2, slide 25
	public static int fillFromFile( Student[] studentArray, String inputFile)
	{
		FileInputStream fileStrm = null;
		InputStreamReader rdr;
		BufferedReader bufRdr;
		Student thisStudent;
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
				thisStudent = new Student( line);
				studentArray[num - 1] = thisStudent;
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