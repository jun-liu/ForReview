/**
 * 
 */
package com.review.algorithm.tests;

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
		
		//����˽�г�Ա���ɼ�
//		Algorithm a = new Algorithm(99);
//		System.out.println(a.m_count);
		//��ȷ��˽�г�Ա���пɼ�
		Stack s = new Stack();
		s.push("s1");
		s.push("s2");
		while(!s.isEmpty())
			System.out.println(s.pop());
		
//		Test t = new Test(99);
//		System.out.println(t.m_count);//�������ʣ���ʵ������ֱ�ӷ�����˽�г�Ա������
	}

}
