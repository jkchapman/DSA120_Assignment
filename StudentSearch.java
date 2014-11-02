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
		BinarySearchTree searchTree = null;
		Student[] studentArray = null;
		int selection = 0;
		int numOfStudents = 0;
		Scanner input;
		LinkedList results;

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

				switch( selection)
				{
					case 1:
						searchTree = new BinarySearchTree();
						studentArray = new Student[10000];
						numOfStudents = FileUtils.loadFile( studentArray, searchTree);
						break;
					case 2:
						results = new LinkedList();
						SearchAndSort.searchSingleStudent( studentArray, numOfStudents, results);
						break;
					case 3:
						results = new LinkedList();
						SearchAndSort.searchListOfStudents( searchTree, results);
						break;
					case 4:
						break;
					case 5:
						break;
					default:
						System.out.println("Please choose function 1 to 5.");
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