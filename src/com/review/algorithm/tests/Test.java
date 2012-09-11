/**
 * 
 */
package com.review.algorithm.tests;

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
		Test t = new Test(99);
		System.out.println(t.m_count);//？？疑问？？实例可以直接访问其私有成员变量？
	}

}
