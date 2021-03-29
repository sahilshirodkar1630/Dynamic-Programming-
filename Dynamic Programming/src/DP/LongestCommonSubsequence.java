package DP;

import java.util.Scanner;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		
		int output = LCS(a,b);
		System.out.println(output);
		System.out.println(lcs(a, b));
	}

	//Approach1
	private static int LCS(String a, String b) {
		// TODO Auto-generated method stub
		int n = a.length();
		int m = b.length();
		int dp[][] = new int[n+1][m+1];
		for(int i = dp.length-2; i >= 0; i--) {
			for(int j = dp[0].length-2; j >= 0; j--) {
				if(a.charAt(i) == b.charAt(j)) {
					dp[i][j] = 1 +dp[i+1][j+1];
				}else {
					dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
				}
			}
		}
		
		return dp[0][0];
	}
	//Approach2
	public static int lcs(String a,String b) {
		int dp[][] = new int[a.length()+1][b.length()+1];
		for(int i=1; i < a.length() + 1; i++) {
			for(int j = 1; j < b.length() + 1; j++) {
				if(a.charAt(i-1) == b.charAt(j-1)) {
					dp[i][j] = 1 +dp[i-1][j-1];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		return dp[a.length()][b.length()]; 
	}

}
