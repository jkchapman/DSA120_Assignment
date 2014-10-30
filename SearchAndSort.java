import io.*;
import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class SearchAndSort
{

	public static void searchSingleStudent( Student[] sortedArray, int numOfStudents, LinkedList results)
	{
		int targetStudentNo;
		int matchIdx;
		try
		{
			Scanner input = new Scanner(System.in);
			System.out.print("Enter student number to find:>");
			targetStudentNo = input.nextInt();
			matchIdx = binarySearch( sortedArray, numOfStudents, targetStudentNo);
			if (matchIdx == -1)
			{
				System.out.println("Student not found!");
			}
			else
			{
                results.insertLast( sortedArray[matchIdx]);
				System.out.println( "" + sortedArray[matchIdx].getStudentNo() + "\t" + sortedArray[matchIdx].getName());
			}
		}
		catch ( InputMismatchException e)
		{
			System.out.println("Error: Must enter a integer number to search for. Try again.");
		}
	}

	//binary search. returns the index of matched student no. -1 if not found.
    private static int binarySearch( Student[] sortedArray, int numOfStudents, int targetStudentNo)
    {
    	boolean found = false;
    	int matchIdx = -1;
    	int lowerBd = 0;
    	int upperBd = numOfStudents;
    	int chckIdx;

    	while( !found && lowerBd <= upperBd)
    	{
    		chckIdx = ( lowerBd + upperBd) / 2;
    		if( sortedArray[chckIdx].getStudentNo() < targetStudentNo)
    		{
    			lowerBd = chckIdx + 1;
    		}
    		else if( sortedArray[chckIdx].getStudentNo() > targetStudentNo)
    		{
    			upperBd = chckIdx - 1;
    		}
    		else
    		{
    			matchIdx = chckIdx;
    			found = true;
    		}
    	}
    	return matchIdx;
    }

	// mergeSort - front-end for kick-starting the recursive algorithm - teken from lecture 6.
    public static void mergeSort(Student[] A, int numRead)
    {
        mergeSortRecurse( A, 0, numRead - 1);
    }//mergeSort()

    // recursive algorithm to split the array down into subarrays and sort.
    private static void mergeSortRecurse(Student[] A, int leftIdx, int rightIdx)
    {
        int midIdx;

        if(leftIdx < rightIdx)
        {
            midIdx = (leftIdx + rightIdx) / 2;

            mergeSortRecurse(A, leftIdx, midIdx);
            mergeSortRecurse(A, midIdx + 1, rightIdx);

            merge( A, leftIdx, midIdx, rightIdx);
        }
    }//mergeSortRecurse()

    // sorts each half of the given array into a temp array before copying back to the original.
    private static void merge(Student[] A, int leftIdx, int midIdx, int rightIdx)
    {
        int ii, jj, kk;
        Student[] tempArr = new Student[rightIdx - leftIdx + 1];
        ii = leftIdx;
        jj = midIdx + 1;
        kk = 0;

        while(ii <= midIdx && jj<= rightIdx)
        {
            if(A[ii].getStudentNo() <= A[jj].getStudentNo())
            {
                tempArr[kk] = A[ii];
                ii++;
            }
            else
            {
                tempArr[kk] = A[jj];
                jj++;
            }
            kk++;
        }

        for( ii = ii; ii <= midIdx; ii++)
        {
            tempArr[kk] = A[ii];
            kk++;
        }
        for( jj = jj; jj <= rightIdx; jj++)
        {
            tempArr[kk] = A[jj];
            kk++;
        }

        for( kk = leftIdx; kk <= rightIdx; kk++)
        {
            A[kk] = tempArr[kk - leftIdx];
        }
    }//merge()

}