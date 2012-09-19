package com.review.algorithm.tests;

public class MaxSubsequenceSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] a = {-9,9,-1,-2,4,-3,};
		System.out.println(findMaxSubsequenceSum(a));
	}
	
	public static int findMaxSubsequenceSum(int[] sourceArray){
		int thisSum = 0;
		int maxSum = Integer.MIN_VALUE;
		
		for(int j=0; j<sourceArray.length; j++){
			thisSum += sourceArray[j];
			
			if(thisSum > maxSum){
				maxSum = thisSum;
			}
			if(thisSum < 0 ){
				thisSum = 0;
			}
		}
		return maxSum;
	}

}
