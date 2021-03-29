package DP;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteAndEarn740 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(deleteAndEarnDP(arr));
		
	}
	
	 public static int deleteAndEarnDP(int[] nums) {
	        int maxElement = Integer.MIN_VALUE;
	        for(int i : nums){
	            maxElement = Math.max(i,maxElement);
	        }
	        int count[] = new int[maxElement+1];
	        for(int i: nums){
	            count[i] += i;
	        }
	        
	        int dp[] = new int[count.length+1];
	        dp[0] = 1;
	        dp[0] = count[0];
			dp[1] = Math.max(count[0], count[1]);
			int n = count.length;
			for(int i=2;i<n;i++) {
				dp[i]= Math.max(dp[i-2]+count[i] ,dp[i-1]);
			}
			return dp[n-1];
		 
		 
	 }
	
	 public int deleteAndEarn(int[] nums) {
	        int n = nums.length;
	        int maxElement = Integer.MIN_VALUE;
	        
	        for(int i : nums){
	            maxElement = Math.max(i,maxElement);
	        }
	        int count[] = new int[maxElement+1];
	        for(int i: nums){
	            count[i] += i;
	        }
	        
	         int dp[] = new int[count.length+1];
		        Arrays.fill(dp,-1);
	        return  rob(count,count.length,dp);
	    }

	 
	     public static int rob(int[] nums, int n,int[] dp) {
			 //Basecase
			 if(n<=0){
		        return 0;
		     }
		        
		     if(dp[n] != -1){
		        return dp[n];
		     }
	         
		     int choice1 = nums[n-1]+rob(nums,n-2,dp); // loot
		     int choice2 = rob(nums,n-1,dp);   //notlooto
	         
		     dp[n] = Math.max(choice1,choice2); // Experience stored
	         
		     return dp[n];
		        
		 }

}
