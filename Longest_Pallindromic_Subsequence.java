Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".
  
  
  
  
  class Solution {
    public int longestPalindromeSubseq(String s) {
        String text1 = s;
        String text2 = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[text1.length()+1][text2.length()+1];

        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]= Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        return dp[text1.length()][text2.length()];




    }
}
