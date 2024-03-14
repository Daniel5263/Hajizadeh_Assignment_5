import java.util.Arrays;
import java.util.HashMap;

public class RadixSort {
    public static void main(String[] args) {
        String[] input = {"gojo", "google", "jogo", "bill", "pup", "cipher", "watchmen", "knight", "it", "stand", "sandman", "hydra", "surtr"};

        radixSort(input);

        System.out.println(Arrays.toString(input));
    }

    public static void radixSort(String[] s) {
        final int RADIX = 256;
        String[] aux = new String[s.length];
        HashMap<Integer, Integer> countMap = new HashMap<>();

        // Find the string with the maximum length
        int maxLen = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i].length() > maxLen) {
                maxLen = s[i].length();
            }
        }

        for (int d = maxLen - 1; d >= 0; d--) {
            countMap.clear();

            // Compute frequency counts using HashMap
            for (int i = 0; i < s.length; i++) {
                int c = charAt(s[i], d);
                countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            }

            // Transform counts to indices
            int index = 0;
            for (int r = 0; r < RADIX; r++) {
                if (countMap.containsKey(r)) {
                    int count = countMap.get(r);
                    countMap.put(r, index);
                    index += count;
                }
            }

            // Distribute
            for (int i = 0; i < s.length; i++) {
                int c = charAt(s[i], d);
                if (countMap.containsKey(c)) {
                    int auxIndex = countMap.get(c);
                    aux[auxIndex] = s[i];
                    countMap.put(c, auxIndex + 1);
                }
            }

            // Copy back
            for (int i = 0; i < s.length; i++) {
                s[i] = aux[i];
            }
        }
    }

    // Get the character at index d, -1 if d is greater than the string length
    private static int charAt(String s, int d) {
        if (d < s.length()) {
            char c = s.charAt(d);
            if (Character.isUpperCase(c)) {
                return c; // Uppercase characters precede lowercase in ASCII
            } else {
                return c + 128; // Shift lowercase characters to the end
            }
        } else {
            return 0; // Treat empty as smallest value
        }
    }
}