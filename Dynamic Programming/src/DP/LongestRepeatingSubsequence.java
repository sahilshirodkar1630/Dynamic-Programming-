package DP;

import java.util.Arrays;
import java.util.Scanner;

public class LongestRepeatingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		System.out.println(LRS(a));
		System.out.println(longestRepeatingSubsequence(a));
	}

	
	private static int longestRepeatingSubsequence(String a) {
		// TODO Auto-generated method stub
		int n = a.length();
		int dp[][] = new int[n+1][n+1];
		for(int i = 1;i < dp.length; i++) {
			for(int j = 1;j < dp[0].length;j++) {
				if(a.charAt(i-1)==a.charAt(j-1)&&i!=j) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[n][n];
	}
	//Recursive
	private static int  LRS(String a) {
		// TODO Auto-generated method stub
		int dp[][] = new int [a.length()+1][a.length()+1];
		for(int i[]:dp) {
		Arrays.fill(i, -1);
		}
		
		return longestRepeatingSubsequence(a, a.length(), a.length(),dp);
		
	}

	public static int longestRepeatingSubsequence(String a, int i,int j,int[][] dp) {

        // return if we have reached the end of either string
		if(i==0 || j==0) {
			return dp[i][j] = 0;
		}
		
		if(dp[i][j] != -1) {
			return dp[i][j];
		}
		 // if characters at index i and j matches
        // and index is different
		if(a.charAt(i-1) == a.charAt(j-1) && i!=j ) {
			return dp[i][j] = longestRepeatingSubsequence(a, i-1, j-1, dp)+1;
			
		}
		
		  // else if characters at index m and n don't match
        return dp[i][j] = Math.max(longestRepeatingSubsequence(a, i, j - 1,dp),longestRepeatingSubsequence(a, i-1 , j, dp));		
	}

}
