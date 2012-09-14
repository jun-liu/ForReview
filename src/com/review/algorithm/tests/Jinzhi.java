/**
 * 
 */
package com.review.algorithm.tests;

/**
 * @author Liu jun
 *
 */
public class Jinzhi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(caculateReversedBinaryNum(11));
	}
	
	public static int caculateReversedBinaryNum(int sourceNum){
		String binaryStr = toBinary(sourceNum);
		int result=0;
		char [] binarys = binaryStr.toCharArray();
		for(int i=0; i<binarys.length; i++){
			if(binarys[i]!='0')
				result += Math.pow(2,i);
		}
		return result;
	}
	public static String toBinary(int sourceNum){
		StringBuffer result = new StringBuffer();
		while(sourceNum >0){
			result.append(sourceNum%2);
			sourceNum>>=1;
		}
		return result.reverse().toString();
	}

}
