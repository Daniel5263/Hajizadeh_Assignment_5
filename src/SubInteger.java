import java.util.Hashtable;

public class SubInteger {
    public static void main(String[] args) {
        int[] S1 = {32, 3};
        int[] T1 = {1, 2, 3, 52, 32, 54};
        int[] S2 = {89, 32, 54, 32, 3};
        int[] T2 = {54, 32, 99};
        int[] S3 = {0, 67};
        int[] T3 = {100, 5, 66, 2, 32, 90};
        int[] S4 = {};
        int[] T4 = {54, 32, 99};

        System.out.println(isSubset(S1, T1));
        System.out.println(isSubset(S2, T2));
        System.out.println(isSubset(S3, T3));
        System.out.println(isSubset(S4, T4));
    }

    public static String isSubset(int[] S, int[] T) {
        Hashtable<Integer, Boolean> tableT = new Hashtable<>();

        for (int i = 0; i < T.length; i++) {
            tableT.put(T[i], true);
        }

        // Check if every element in S is present in T
        for (int i = 0; i < S.length; i++) {
            if (!tableT.containsKey(S[i])) {
                return "No";
            }
        }
        return "Yes";
    }
}