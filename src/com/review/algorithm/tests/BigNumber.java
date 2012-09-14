/**
 * 
 */
package com.review.algorithm.tests;

/**
 * ����������
 * @author zhoujianghai
 * zhoujiangbohai@163.com
 * ת�ԣ�http://zhoujianghai.iteye.com/blog/1168264
 */
public class BigNumber {

	 public static void main(String agrs[]){
		 StringBuffer sb = new StringBuffer(); 
		 // // String str1 = "99999999999"; String str2 = "99999999999"; 
		 for (int i = 0; i < 100; i++) { 
			 sb.append(9); 
			 } 
		 String number1 = sb.toString(); 
		 String number2 = number1;
		 
//	 String number1 = "1234567891011121314151617181920";
//	 String number2 = "2019181716151413121110987654321";
	  String result = multipBigNumber(number1,number2);
	  System.out.println("��������"+result+"; length="+result.length());
	  System.out.println("��֤�����"+Double.parseDouble(number1) * Double.parseDouble(number2));
	 }
	
	 public static String multipBigNumber(String s1,String s2){
		  int longArray[] = null;
		  int shortArray[] = null;
		  int s1Length = s1.length();
		  int s2Length = s2.length();
		  int longLength = s1Length > s2Length ? s1Length : s2Length;
		  int shortLength = s1Length == longLength ? s2Length : s1Length;
		  longArray = new int[longLength];
		  shortArray = new int[shortLength];
		  String longString = s1Length >= s2Length ? s1 : s2; 
		  String shortString = s1.equals(longString) ? s2 : s1;
		  System.out.println("longString="+longString+"; shortString="+shortString); 
		  //��λ��ǰ����λ�ں�
		  for(int i = longLength - 1; i >= 0; i --){
			  longArray[longLength - 1 - i] = longString.charAt(i) - 48; 
		  }
		  for(int i = shortLength - 1; i >= 0; i --){
			  shortArray[shortLength - 1 - i] = shortString.charAt(i) - 48;
		  }
		 
		  StringBuffer results[] = new StringBuffer[longLength];
		  for(int i = 0; i < results.length; i++) {
			  results[i] = new StringBuffer();
	    	}
		  StringBuffer resultBuffer = new StringBuffer();
	   
		  /**
		   * �ѱ�������ÿһλ�������λ���
		   * �磺5607 * 2256,������5607������2256
		   * 7 * 6 + 0 = 42 ��0��ʾ��λ���λ�Ľ�λ
			 7 * 5 + 4 = 39
             7 * 2 + 3 = 17
             7 * 2 + 1 = 15
             29751
             0 * 6 + 0 = 0
             0 * 5 + 0 = 0
             0 * 2 + 0 = 0
			 0 * 2 + 0 = 0
			 00000
			 6 * 6 + 0 = 36
			 6 * 5 + 3 = 33
			 6 * 2 + 3 = 15
			 6 * 2 + 1 = 13
			 63531
			 5 * 6 + 0 = 30
			 5 * 5 + 3 = 28
			 5 * 2 + 2 = 12
			 5 * 2 + 1 = 11
			 08211
		   *  results��29751�� 00000��63531��08211
		   * */
		  for(int i = 0; i < longLength; i ++){
		   int temp = 0;
		   int tempCarry = 0;//��λ���λ�Ľ�λ
		   int currentValue = 0; //��ǰλ�˻���ֵ
			   for(int j = 0; j < shortLength; j ++){
				  
				    temp = longArray[i] * shortArray[j] + tempCarry;
				    //System.out.println("longArray[i]="+longArray[i]+" * "+"shortArray[j]="+shortArray[j]+" + "+tempCarry+" = "+temp); 
				    tempCarry = temp / 10;
				    currentValue = temp % 10;
				    results[i].append(currentValue);
				    if(j == shortLength - 1){
				     results[i].append(tempCarry);//���λ�н�λ���λ���޽�λ��0
				    }
			   }
//			  System.out.println( results[i].toString()); 
		  }
		 /**��λ��0��results[i]��λ��i��0(��λ��ǰ����λ�ں�)
		  * 29751
			000000
			0063531
			00008211
		  *  */
		  for(int i = 0,length = results.length;i < length; i++){
		   String temp = "";
		   for(int j = 0; j < i; j ++){
		    temp += "0";
		   }
		   results[i].insert(0, temp);
		   System.out.println( results[i].toString()); 
		  }

		   /**��ÿһ�����(��λ��ǰ����λ�ں�,�������� ��)
		  * 29751
			000000
			0063531
			00008211
		  -------------
		    29394621 
		    * 
		    * */
		  int tempCarry = 0;
		  int currentValue = 0; 
		  StringBuffer lastBuffer = results[results.length - 1];
		 //��Ҫѭ���Ĵ���  
        int times =  lastBuffer.length();  
       
        for(int i = 0; i < times; i ++ ){  
            int temp = 0;  
            for(int j = 0,length2 = results.length; j < length2; j ++){  
                if(results[j].length() > i){  
                    temp += (results[j].charAt(i) - 48);//�ѵ�j�еĵ�iλ���ַ�ת����int  
                }  
            }  
            temp += tempCarry;  
            tempCarry = temp / 10;  
            currentValue = temp % 10;  
            resultBuffer.append(currentValue);  
        }  

        StringBuffer finalResult = new StringBuffer();  

        boolean hasNumNotZero = false;
        //��Ϊ��λ��ǰ����λ�ں����԰�29394621 ת�������ս����12649392  
        for(int i = resultBuffer.length() - 1; i >= 0; i --) {  
            int temp  = resultBuffer.charAt(i) - 48;  
            if(temp != 0) hasNumNotZero = true;
            if (hasNumNotZero) finalResult.append(temp);    
        }  
        if (finalResult.length() == 0) finalResult.append(0);
        return finalResult.toString();  

    }  
}
