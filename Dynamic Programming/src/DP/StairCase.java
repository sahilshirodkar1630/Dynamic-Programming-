package DP;

import java.util.Arrays;
import java.util.Scanner;

public class StairCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(staircaseDP(n));
		System.out.println(staircaseM(n));
		System.out.println(staircase(n));
	}
	
	// Recursive Solution
	public static long staircase(int n) {
		//Your code goes here
		if(n<0) {
			return 0;
		}else if(n==0) {
			return 1;
		}
		
		long count=0;
		count = staircase(n-1)+staircase(n-2)+staircase(n-3);
		return count;
	}
	
	 public static long staircaseM(int n){
		 long dp[] = new long[n+1];
			
			Arrays.fill(dp,-1);
			return staircaseM(n, dp);
	 }

	private static long staircaseM(int n, long[] dp) {
		// TODO Auto-generated method stub
		if(n==0||n==1) {
			dp[n] =1;
			return 1;
		}
		if(n==2) {
			dp[n]=2;
			return 2;
		}
		
		if(dp[n] != -1) {
			return dp[n];
		}
		
		long count=0;
		count = staircase(n-1)+staircase(n-2)+staircase(n-3);
		dp[n] = count;
		return count;
	}
	
	public static long staircaseDP(int n) {
		long dp[] = new long[n+1];
		dp[0]=1;
		dp[1]=1;
		dp[2] =2;
		for(int i=3;i<n+1;i++) {
			dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
		}
		return dp[n];
	}
	

}
