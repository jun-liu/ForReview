package com.review.algorithm.tests;

import java.util.LinkedList;
import java.util.List;

/**
 * 无重复全排列问题
 * 输出1,2,2,3,4这几个数字所有不同的排列顺序
 * 一个递归问题，想法是如果当前数字确定下来，后面的几位还有几种组合方式，逐步的缩小后面几位的规模
 *
 * 输出的完整性问题：定义一个result专门装前面排序好的元素，input里装的是后面顺序没有定下来的元素的集合，
 * layer是表示当前处理的是input中的第几位，每次input为空的时候，都把result里的元素都打印一下
 * 
 *无重复问题：如果在这个layer上，已经处理过一个跟当前元素值相同的元素，就把这个元素跳过去
 * @author justrun
 *
 */
public class testFullArray {
	static int count = 0;
	public static void main(String args[]){
/*		List<Integer> input = new LinkedList<Integer>();
		input.add(1);
		input.add(2);
		input.add(2);
		input.add(3);
		input.add(4);
		
		int[] result = new int[input.size()];
		print(input,0,result);*/
		pailie("1223334", "");
	}
	//方法一：处理列表，不好理解，时间复杂度也跟高
	public static void print(List<Integer> input, int layer, int[] result){
		
		if(input.isEmpty()){                             //后面没排序的元素集合为空，输出一次result集合
			for(int i=0 ; i<5; i++){
				System.out.print(result[i]);
			}
			System.out.println("");
			return;
		}
		
		int flag;
		for(int i = 0 ; i<input.size() ; i++){
			
			int node = (Integer)input.get(i);
			
			flag = 0;                                     //同一位置，重复的数字只调用一次
			for(int n=0 ; n<i; n++){
				if( node == (Integer)input.get(n)){
					flag = 1; 
					break;
				}
			}
			
			if(flag == 0){
				result[layer]=node;
				List<Integer> newRefer = new LinkedList<Integer>();
				for(int j=0 ; j<input.size() ; j++){
					newRefer.add((Integer) input.get(j));
				}
				newRefer.remove(i);			            //深拷贝一个新的input集合，把正在处理的元素，从当前的input集合中拿掉
				print(newRefer,layer+1,result);
			}
		}
	}
	//方法二
	public static void pailie(String s, String p){
		int index[] = new int[s.length()];
		if(s.length() < 1){
			System.out.println(s+p);
			count ++;
		}
		else{
			for(int i=0; i<s.length(); i++)
				index[i] = s.indexOf(s.charAt(i));
		}
		for(int i=0; i<s.length(); i++){
			if(i == index[i]){
				pailie(s.substring(1), p + s.substring(0, 1));
			}
			s = s.substring(1) + s.substring(0, 1);
		}
	}
}
