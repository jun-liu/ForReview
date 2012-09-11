/**
 * 
 */
package com.review.algorithm.tests;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
/**
 * @author Liu jun
 *
 */
public class FindMaxAppear {// 求一个字符串中出现次数最多的那个字母及次数

	public static void main(String[] args) {
		String input = "abcabbbbbbkgllllslll";
		//方法一：
//		doString(input);

		
		//方法二：简单易行
		char[] a= input.toCharArray();
		int[] count = new int[127]; //ASCII码字符最多为127个
		for(int i=0;i<a.length;i++){
			count[a[i]]++; //字符为a[i]的出现次数++
		}
		
		//找出count中最大值，如果有多个就算多个
		int maxCount = 0;
		int maxIndex = 0;
		char maxValue;//出现次数最多的字符
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<count.length;i++){
			if(count[i]>maxCount){
				maxCount=count[i];
				maxIndex = i;
			}
		}
		//从最大值首次出现的位置开始遍历
		for(int i=maxIndex ;i<count.length;i++){
			if(count[i]==maxCount){
				maxValue = (char) i;
				sb.append(maxValue+",");
			}
		}
		System.out.println("出现次数最多的字符有："+sb+"出现次数为："+maxCount);
	//方法二
		
	}

	private static void doString(String input) {

		char[] chars = input.toCharArray();
		List<String> list = new ArrayList<String>();

		TreeSet<String> set = new TreeSet<String>(); // 对插入到的元素进行自然排序

		for (int i = 0; i < chars.length; i++) {
			list.add(String.valueOf(chars[i]));
			set.add(String.valueOf(chars[i])); // 添加了字母，而且没有重复的。

		}

		Collections.sort(list);// 对list进行排序
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
		}
		input = sb.toString();// input已经是排好序的
		int max = 0; // 字符数最多的个数
		String maxString = "";

		List<String> maxList = new ArrayList<String>(); // 字符数最多的可能有多个，如同时有4个a和b，而且最多
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String current = it.next();
			int begin = input.indexOf(current);
			int end = input.lastIndexOf(current);
			int value = end - begin + 1; // 字符current出现过value次
			if (value > max) {
				max = value;
				maxString = current;
				maxList.add(current); 
			} else if (value == max) {
				maxList.add(current);
			}
		}

		// while循环结束后，maxString存放的就是出现次数最多的字符，max为出现最多的次数

		int index = 0;
		for (int i = 0; i < maxList.size(); i++) { //找到maxString的下标，则maxList之后添加的可能是maxString，之前肯定不是出现次数最多的，否则
			if (maxList.get(i).equals(maxString)) {
				index = i;
				break;
			}
		}

		System.out.println("出现最多的字符分别为：");
		for (int i = index; i < maxList.size(); i++) {
			System.out.println(maxList.get(i) + " ");
		}
		System.out.println();
		System.out.println("出现最多的次数为：" + max);
	}
}
