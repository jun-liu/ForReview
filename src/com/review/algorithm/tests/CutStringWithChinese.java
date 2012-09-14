/**
 * 
 */
package com.review.algorithm.tests;

import java.io.UnsupportedEncodingException;

/**
 * @author Liu jun
 *
 */
public class CutStringWithChinese {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String str = "ÎÒABCººDEF";

		System.out.println(cutString(str,6));
	}

	public static boolean isChineseChar(char c){
		return String.valueOf(c).getBytes().length > 1;
	}
	public static String cutString(String orignal, int count){
		if(orignal != null && !"".equals(orignal)){
			
			int bytes = orignal.getBytes().length;
			assert(count>bytes);
			
			StringBuffer result = new StringBuffer();
			char currentChar;
			for(int i=0; i<count; i++ ){
				currentChar = orignal.charAt(i);
				if(isChineseChar(currentChar)){
					count--;
					if(i<count)
						result.append(currentChar);
				}
				else{
					result.append(currentChar);
				}
			}
			return result.toString();
		}
		
		return orignal;
	}
}
