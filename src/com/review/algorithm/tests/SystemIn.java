/**
 * 
 */
package com.review.algorithm.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Liu jun
 *
 */
public class SystemIn {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Result result = new Result();
		System.out.println("����һ��������");
		int a = InputData.getInt();
		result.print(a);
//		System.out.println(result.isPowerofTwo(a));
	}
}
/**
 * 
 * @author Liu jun
 *
 */
class InputData{
	static private String s = "";
	/*
	 * ��ȡ���봮
	 */
	static public void input(){
		BufferedReader bu = new BufferedReader(
				new InputStreamReader(System.in));
		try{
			s = bu.readLine();
		}
		catch(IOException ioe){
			
		}
	}
	static public int getInt() {
		input();
		return Integer.parseInt(s);
	}
}
/**
 * 
 * @author Liu jun
 *
 */
class Result{
	void print(int d){
		System.out.println(d + "��ƽ����" + d*d);
		System.out.println(d + "��������" + d*d*d);
	}
	/**
	 * �ж��Ƿ���2�Ľ״η���
	 * @param i
	 * @return
	 */
	boolean isPowerofTwo(int i){
		return 0==(i&(i-1));
	}
}
