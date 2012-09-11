/**
 * 
 */
package com.review.algorithm.tests;

/**
 * @author Liu jun
 *
 */
public class testNumofOnes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countOnes(99999999));
	}

	/***
	 * 计算1～n的数中含有1的总个数
	 * @param n
	 * @return
	 */
	public static long countOnes(int n){
		long count=0;
		
		int factor=1;
		int lowerNum = 0;
		int currentNum = 0;
		int higherNum = 0;
		while(n/factor !=0){
			lowerNum = n%(factor);
			currentNum = (n/factor)%10;
			higherNum = n/(factor*10);
			switch(currentNum){
			case 0:
				count += higherNum * factor;
				break;
			case 1:
				count += higherNum * factor + lowerNum +1;
				break;
			default:
				count += (higherNum+1) * factor;
				break;
			}
			factor *=10;
		}
		return count;
	}
}
