import java.util.Arrays;

public class SumTargetEC {
    public static int[] sumTarget(int[] A, int K) {
        int start = 0, end = 0, currentSum = 0;

        // Expand the window by adding the current element to the sum
        while (end < A.length) {
            currentSum += A[end];

            // Adjust the window by removing elements from the start if the sum exceeds K
            while (currentSum > K) {
                currentSum -= A[start];
                start++;
            }

            // If the current sum equals K, return the indices of the subarray
            if (currentSum == K) {
                return new int[]{start, end};
            }

            end++;
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] A1 = {1, 2, 3, 7, 5};
        int K1 = 12;
        System.out.println(Arrays.toString(sumTarget(A1, K1))); // Output: [1, 3] or [3, 4]

        int[] A2 = {1, 2, 3, 7, 5};
        int K2 = 5;
        System.out.println(Arrays.toString(sumTarget(A2, K2))); // Output: [1, 2] or [4, 4]

        int[] A3 = {1, 2, 3, 7, 5};
        int K3 = 7;
        System.out.println(Arrays.toString(sumTarget(A3, K3))); // Output: [3, 3]

        int[] A4 = {1, 2, 3, 7, 5};
        int K4 = 11;
        System.out.println(Arrays.toString(sumTarget(A4, K4))); // Output: [-1, -1]
    }
}