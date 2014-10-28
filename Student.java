import io.*;
import java.io.*;

public class Student
{

	//class fields
	private int studentNo;
	private String name;

	//default constructor
	public Student()
	{
		studentNo = -1;
		name = null;
	}

	//alt constructor
	public Student( int studentNo, String name)
	{
		this.studentNo = studentNo;
		setName( name);
	}

	//alt constructor taking a row from csv file
	public Student( String row)
	{

		String rowValues[] = row.split(",");
		studentNo = Integer.parseInt(rowValues[0]);
		setName( rowValues[1]);

	}

	//name setter
	public void setName( String name)
	{
		if(name == null || name.equals(""))
		{
			throw new IllegalArgumentException("Name must not be blank!");
		}
		else
		{
			this.name = name;
		}
	}

}