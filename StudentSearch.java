/*
	Jacob Chapman
	17779407
	28/10/2014
*/

import io.*;
import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class StudentSearch
{

	public static void main( String[] args)
	{

		mainMenu();
		
		System.exit(0);
	}

	private static void mainMenu()
	{
		Student[] studentArray = new Student[10000];
		int selection = 0;
		int numOfStudents = 0;
		Scanner input;

		do
		{
			try
			{
				input = new Scanner(System.in);
				System.out.println("(1)\t - Load Students");
				System.out.println("(2)\t - Search for Single Student");
				System.out.println("(3)\t - Search for List of Students");
				System.out.println("(4)\t - Save Matches");
				System.out.println("(5)\t - Quit");
				System.out.print("Choice:>");
				selection = input.nextInt();

				if( selection < 1 || selection > 5)
				{
					System.out.println("Please choose function 1 to 5.");
				}
				switch( selection)
				{
					case 1:
						numOfStudents = FileUtils.loadFile( studentArray);
						break;
					case 2:
						SearchAndSort.searchSingleStudent( studentArray, numOfStudents);
						break;
					case 3:
						break;
					case 4:
						break;
				}
			}
			catch ( InputMismatchException e)
			{
				selection = 0;
				System.out.println("Please choose an integer option 1 to 5.");
			}
			
			
		} while (selection != 5);

	}

}