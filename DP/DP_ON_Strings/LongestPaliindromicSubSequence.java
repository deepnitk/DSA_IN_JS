//Recursive solution

class Solution {
    public int longestPalindromeSubseq(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        int n = s.length();
        return longestCommonSubsequenceUtil(s, n - 1, reversed, n - 1);
    }

    private int longestCommonSubsequenceUtil(String s1, int idx1, String s2, int idx2) {
        if (idx1 < 0 || idx2 < 0) {
            return 0;
        }

        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            return 1 + longestCommonSubsequenceUtil(s1, idx1 - 1, s2, idx2 - 1);
        }

        return Math.max((0 + longestCommonSubsequenceUtil(s1, idx1 - 1, s2, idx2)),
                        (0 + longestCommonSubsequenceUtil(s1, idx1, s2, idx2 - 1)));
    }
}
