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
    public static String printArrayString(int[] arrayC) {
        return Arrays.toString(arrayC);
    }

    public static void main(String[] args) {
        //sorted arrays for test
        int[] A = {1,2,7,11};
        int[] B = {3,7,13,16,29};

        //merge the arrays to C[]
        int[] C = merge(A, B);
        
        // Print result
        System.out.printf("A = %s\nB = %s\nC = %s\n\n", 
            printArrayString(A), printArrayString(B), printArrayString(C));

        // MORE TEST CASES
        int[] A2 = {};
        int[] B2 = {};
        int[] C2 = merge(A2, B2);
        System.out.printf("A2 = %s\nB2 = %s\nC2 = %s\n\n", 
            printArrayString(A2), printArrayString(B2), printArrayString(C2));

        int[] A3 = {};
        int[] B3 = {1, 3, 5};
        int[] C3 = merge(A3, B3);
        System.out.printf("A3 = %s\nB3 = %s\nC3 = %s\n\n", 
            printArrayString(A3), printArrayString(B3), printArrayString(C3));

        int[] A4 = {2,4,6};
        int[] B4 = {};
        int[] C4 = merge(A4, B4);
        System.out.printf("A4 = %s\nB4 = %s\nC4 = %s\n\n", 
            printArrayString(A4), printArrayString(B4), printArrayString(C4));

        int[] A5 = {1,3,5};
        int[] B5 = {2,4,6};
        int[] C5 = merge(A5, B5);
        System.out.printf("A5 = %s\nB5 = %s\nC5 = %s\n\n", 
            printArrayString(A5), printArrayString(B5), printArrayString(C5));
        
        int[] A6 = {-5, 0, 2};
        int[] B6 = {-3,1,4};
        int[] C6 = merge(A6, B6);
        System.out.printf("A6 = %s\nB6 = %s\nC6 = %s\n\n", 
            printArrayString(A6), printArrayString(B6), printArrayString(C6));
        
        

    }
}