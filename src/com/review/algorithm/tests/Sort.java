/**
 * 
 */
package com.review.algorithm.tests;

/**
 * @author Liu jun
 *
 */
public class Sort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {4,657,634,32,7756,54,87,45,23,65,87};
//		bubbleSort(array);
		quickSort(array);
		for(int element : array){
			System.out.printf("%d ", element);
		}
	}
	//冒泡排序
	public static void bubbleSort(int [] source){
		for(int i=source.length-1; i>0; i--)
			for(int j=0; j<i; j++)
				if(source[j] > source[j+1])
					swap(source, j, j+1);
	}
	public static void swap(int[] source, int x, int y){
		int temp = source[x];
		source[x] = source[y];
		source[y] = temp;
	}
	
	//快速排序
	public static void quickSort(int[] source){
		quickSort(source, 0, source.length-1);
	}
	public static void quickSort(int[] source,int low, int high){
		if(low<high){
			int pivotPos = partition(source, low, high);
			quickSort(source, low, pivotPos-1);
			quickSort(source, pivotPos+1, high);
		}
	}
	private static int partition(int[] source, int low, int high){
		int pivot = source[low]; //作为基准
		while(low<high){
			while(low<high && source[high]>=pivot)
				high--;
			if(low<high)
				source[low++] = source[high];
			while(low<high && source[low]<=pivot)
				low++;
			if(low<high)
				source[high--] = source[low];
		}
		source[low] = pivot;
		return low;
	}
}
