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
		Student[] studentArray = new Student[10000];
		String inputFile;
		Scanner input;
		int selection = 0;

		input = new Scanner(System.in);

		System.out.println("(1)\t - Load Students");
		System.out.println("(2)\t - Search for Single Student");
		System.out.println("(3)\t - Search for List of Students");
		System.out.println("(4)\t - Save Matches");
		System.out.println("(5)\t - Quit");

		do
		{
			System.out.print("Choice:>");
			selection = Integer.parseInt(input.nextLine());
			if( selection < 1 || selection > 5)
			{
				System.out.println("Please choose function 1 to 5.");
			}
		} while (selection < 1 || selection > 5);

		switch( selection)
		{
			case 1:
				System.out.print("Enter input file name:>");
				inputFile = input.nextLine();
				FileUtils.fillFromFile( studentArray, inputFile);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
		}

		System.exit(0);
	}
}