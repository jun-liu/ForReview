/**
 * 
 */
package com.review.algorithm.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import com.review.algorithm.Algorithm;

/**
 * @author Liu jun
 *
 */
public class Test {
	private int m_count;
	Test(int count){
		m_count = count;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//错误，私有成员不可见
//		Algorithm a = new Algorithm(99);
//		System.out.println(a.m_count);
		//正确，私有成员类中可见
//		Test t = new Test(99);
//		System.out.println(t.m_count);//？？疑问？？类中自身的实例可以直接访问其私有成员变量？
		
/*		Stack s = new Stack();
		s.push("s1");
		s.push("s2");
		while(!s.isEmpty())
			System.out.println(s.pop());*/
		
//		List<String> strList = new ArrayList<String>();
		
		
//		int [] array = {4,4,4,4,4,67,67,67,67};
//		String[] strArray = {"ad","sd","fds"};
////		List<String> strList = new ArrayList<String>(strArray);
//		List<String> strList = new ArrayList<String>(Arrays.asList(strArray));
//		for(int i=0;i<10;i++)
//			strList.add(String.valueOf(i));
//		strList.add("df");
//		strList.add("ab");
//		for(String item:strList)
//			System.out.print(item);
//		Collections.sort(strList, new Comparator<String>(){
//			public int compare(String s1, String s2){
//				return 1;
//			}
//		});
//		System.out.println("");
//		//交集
//		strList.retainAll(Arrays.asList(strArray));
//		for(String item:strList)
//			System.out.print(item);
		
		List<String> strList = new ArrayList<String>();  
        List<String> strList2 = new ArrayList<String>();  
        for(int i = 0; i < 10; i ++) {  
            strList.add("aaa>>" + i);  
            strList2.add("aaa>>" + (15 - i));  
        }  
        //求出并集  
        strList2.removeAll(strList);  
        strList2.addAll(strList);  
        System.out.println("并集大小：" + strList2.size());        
          
//        for(int i = 0; i < strList2.size(); i++) {  
//            System.out.println(strList2.get(i));  
//        }         
		
        for(Iterator<String> it= strList2.iterator();it.hasNext();){
        	System.out.println(it.next());
        }
//		System.out.println(dominateNum(array));
		
	}
	public static int dominateNum(int[] source){
		assert(source.length == 0);
		
		int middleNum = findMiddleNum(source);
		int count=0;
		for(int i:source){
			if(i==middleNum)
				count++;
		}
		return ((double)count)/source.length >0.5 ? middleNum:-1 ;
	}

	public static int findMiddleNum(int[] source){
		
		Arrays.sort(source);
		return source[source.length/2];
	}
}
