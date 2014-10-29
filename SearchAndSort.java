

public class SearchAndSort
{

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