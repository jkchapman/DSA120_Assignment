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
		Scanner input;
		int selection;

		input = new Scanner(System.in);

		System.out.println("(1)\t - Load Students");
		System.out.println("(2)\t - Search for Single Student");
		System.out.println("(3)\t - Search for List of Students");
		System.out.println("(4)\t - Save Matches");
		System.out.println("(5)\t - Quit");
		System.out.print("Choice:>");

		selection = Integer.parseInt(input.nextLine());
		System.out.printf("%d\n", selection);

		System.exit(0);
	}
}