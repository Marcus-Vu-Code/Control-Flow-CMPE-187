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
        int[] A = {1,2,7,11};
        int[] B = {3,7,13,16,29};

        //merge the arrays to C[]
        int[] C = merge(A, B);
        
        // Print result
        System.out.println("Input Arrays:");
        System.out.print("A = ");
        printArrayString(A);
        System.out.print("B = ");
        printArrayString(B);

        System.out.println("Output Array:");
        System.out.print("C = ");
        printArrayString(C);   
    }
}