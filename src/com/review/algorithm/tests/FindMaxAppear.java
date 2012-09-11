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
public class FindMaxAppear {// ��һ���ַ����г��ִ��������Ǹ���ĸ������

	public static void main(String[] args) {
		String input = "abcabbbbbbkgllllslll";
		//����һ��
//		doString(input);

		
		//��������������
		char[] a= input.toCharArray();
		int[] count = new int[127]; //ASCII���ַ����Ϊ127��
		for(int i=0;i<a.length;i++){
			count[a[i]]++; //�ַ�Ϊa[i]�ĳ��ִ���++
		}
		
		//�ҳ�count�����ֵ������ж��������
		int maxCount = 0;
		int maxIndex = 0;
		char maxValue;//���ִ��������ַ�
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<count.length;i++){
			if(count[i]>maxCount){
				maxCount=count[i];
				maxIndex = i;
			}
		}
		//�����ֵ�״γ��ֵ�λ�ÿ�ʼ����
		for(int i=maxIndex ;i<count.length;i++){
			if(count[i]==maxCount){
				maxValue = (char) i;
				sb.append(maxValue+",");
			}
		}
		System.out.println("���ִ��������ַ��У�"+sb+"���ִ���Ϊ��"+maxCount);
	//������
		
	}

	private static void doString(String input) {

		char[] chars = input.toCharArray();
		List<String> list = new ArrayList<String>();

		TreeSet<String> set = new TreeSet<String>(); // �Բ��뵽��Ԫ�ؽ�����Ȼ����

		for (int i = 0; i < chars.length; i++) {
			list.add(String.valueOf(chars[i]));
			set.add(String.valueOf(chars[i])); // �������ĸ������û���ظ��ġ�

		}

		Collections.sort(list);// ��list��������
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
		}
		input = sb.toString();// input�Ѿ����ź����
		int max = 0; // �ַ������ĸ���
		String maxString = "";

		List<String> maxList = new ArrayList<String>(); // �ַ������Ŀ����ж������ͬʱ��4��a��b���������
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String current = it.next();
			int begin = input.indexOf(current);
			int end = input.lastIndexOf(current);
			int value = end - begin + 1; // �ַ�current���ֹ�value��
			if (value > max) {
				max = value;
				maxString = current;
				maxList.add(current); 
			} else if (value == max) {
				maxList.add(current);
			}
		}

		// whileѭ��������maxString��ŵľ��ǳ��ִ��������ַ���maxΪ�������Ĵ���

		int index = 0;
		for (int i = 0; i < maxList.size(); i++) { //�ҵ�maxString���±꣬��maxList֮����ӵĿ�����maxString��֮ǰ�϶����ǳ��ִ������ģ�����
			if (maxList.get(i).equals(maxString)) {
				index = i;
				break;
			}
		}

		System.out.println("���������ַ��ֱ�Ϊ��");
		for (int i = index; i < maxList.size(); i++) {
			System.out.println(maxList.get(i) + " ");
		}
		System.out.println();
		System.out.println("�������Ĵ���Ϊ��" + max);
	}
}
