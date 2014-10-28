/*
	Jacob Chapman
	17779407
	28/10/2014
*/

import io.*;
import java.io.*;
import java.util.Scanner;

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
		Scanner input;
		input = new Scanner(System.in);

		do
		{
			System.out.println("(1)\t - Load Students");
			System.out.println("(2)\t - Search for Single Student");
			System.out.println("(3)\t - Search for List of Students");
			System.out.println("(4)\t - Save Matches");
			System.out.println("(5)\t - Quit");
			System.out.print("Choice:>");
			selection = Integer.parseInt(input.nextLine());
			if( selection < 1 || selection > 5)
			{
				System.out.println("Please choose function 1 to 5.");
			}
			switch( selection)
			{
				case 1:
					FileUtils.loadFile( studentArray, input);
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
			}
		} while (selection != 5);

	}

}