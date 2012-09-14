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
		System.out.println("输入一个整数：");
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
	 * 获取输入串
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
		System.out.println(d + "的平方：" + d*d);
		System.out.println(d + "的立方：" + d*d*d);
	}
	/**
	 * 判断是否是2的阶次方数
	 * @param i
	 * @return
	 */
	boolean isPowerofTwo(int i){
		return 0==(i&(i-1));
	}
}
