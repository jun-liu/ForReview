package com.review.algorithm.tests;

import java.util.LinkedList;
import java.util.List;

/**
 * ���ظ�ȫ��������
 * ���1,2,2,3,4�⼸���������в�ͬ������˳��
 * һ���ݹ����⣬�뷨�������ǰ����ȷ������������ļ�λ���м�����Ϸ�ʽ���𲽵���С���漸λ�Ĺ�ģ
 *
 * ��������������⣺����һ��resultר��װǰ������õ�Ԫ�أ�input��װ���Ǻ���˳��û�ж�������Ԫ�صļ��ϣ�
 * layer�Ǳ�ʾ��ǰ�������input�еĵڼ�λ��ÿ��inputΪ�յ�ʱ�򣬶���result���Ԫ�ض���ӡһ��
 * 
 *���ظ����⣺��������layer�ϣ��Ѿ������һ������ǰԪ��ֵ��ͬ��Ԫ�أ��Ͱ����Ԫ������ȥ
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
	//����һ�������б�������⣬ʱ�临�Ӷ�Ҳ����
	public static void print(List<Integer> input, int layer, int[] result){
		
		if(input.isEmpty()){                             //����û�����Ԫ�ؼ���Ϊ�գ����һ��result����
			for(int i=0 ; i<5; i++){
				System.out.print(result[i]);
			}
			System.out.println("");
			return;
		}
		
		int flag;
		for(int i = 0 ; i<input.size() ; i++){
			
			int node = (Integer)input.get(i);
			
			flag = 0;                                     //ͬһλ�ã��ظ�������ֻ����һ��
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
				newRefer.remove(i);			            //���һ���µ�input���ϣ������ڴ����Ԫ�أ��ӵ�ǰ��input�������õ�
				print(newRefer,layer+1,result);
			}
		}
	}
	//������
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
