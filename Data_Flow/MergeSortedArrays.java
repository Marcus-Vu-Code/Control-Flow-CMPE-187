package Data_Flow;
import java.util.Arrays;

public class MergeSortedArrays {
    // Merge array A and B to sorted array S:
    public static int[] merge(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;

        int[] C = new int[n + m];
        
        //initialize indexes for 3 arrays: i -> A[], j -> B[]; k -> C[]
        int i = 0, j = 0, k = 0;

        // Merge while A and B arrays still have items
        while (i < n && j < m) {
            // Compare items from A[] and B[], if A[i] < B]j], put A[i] to C[k], increment, repeat
            if (A[i] <= B[j]) {
                C[k] = A[i];
                i++;
            } else {
                C[k]= B[j];
                j++;
            }
            k++;
        }
        
        // Move any remaning of A and B into S
        while (i < n) {
            C[k] = A[i];
            i++;
            k++; 
        }
        while (j < m) {
            C[k] = B[j];
            j++;
            k++; 
        }
        
        // Return sorted array S
        return C;
    }

    //Helper to covnert array to String and print it
    public static void printArrayString(int[] arrayC) {
        System.out.println(Arrays.toString(arrayC));
    }

    public static void main(String[] args) {
        //sorted arrays for test
        int[] A = {5, 23, 67, 112, 143, 555, 1000, 123982137};
        int[] B = {-1999, -321, -100, -55, -3, 0};

        //merge the arrays to C[]
        int[] C = merge(A, B);
        
        // Print result
        printArrayString(C);
    }
}