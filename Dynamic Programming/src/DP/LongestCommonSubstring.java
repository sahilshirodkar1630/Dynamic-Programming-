package DP;

import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		System.out.println(lCSubstring(a, b));
		System.out.println(longestCommonSubstringDP(a,b));
	}
	public static int lCSubstring(String a, String b) {
		
	
		 return longestCommonSubstring(a, b,0);
		
	}
	
	private static int longestCommonSubstring(String a, String b, int count) {
		// TODO Auto-generated method stu
		int n = a.length();
		int m = b.length();
		
		if(n == 0|| m == 0) {
			return count;
		}
		
		if(a.charAt(n-1) == b.charAt(m-1)) {
			 count = longestCommonSubstring(a.substring(1), b.substring(1),count+1);
			 
		}
		
		int op1 = longestCommonSubstring(a.substring(1), b,0);
		int op2 = longestCommonSubstring(a, b.substring(1),0);
		count = Math.max(count, Math.max(op1,op2));
			
		return count;
		
	}
	
	private static int longestCommonSubstringDP(String a, String b) {
		// TODO Auto-generated method stub
		
		int dp[][] = new int[a.length()+1][b.length()+1];
		
		for(int i=1;i<a.length()+1;i++) {
			for(int j=1;j<b.length()+1;j++) {
				if(a.charAt(i-1) == b.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}else {
					dp[i][j] = 0;
				}
			}
		}
		int MaxElement=Integer.MIN_VALUE;
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(dp[i][j]>MaxElement) {
					MaxElement=dp[i][j];
				}
			}
		}
		
		return MaxElement;
	}

	

}
