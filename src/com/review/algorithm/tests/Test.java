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
		
		//����˽�г�Ա���ɼ�
//		Algorithm a = new Algorithm(99);
//		System.out.println(a.m_count);
		//��ȷ��˽�г�Ա���пɼ�
		Test t = new Test(99);
		System.out.println(t.m_count);//�������ʣ���ʵ������ֱ�ӷ�����˽�г�Ա������
	}

}
