package DataStructureAndAlgorithms;

import java.util.Arrays;


public class MainTest{

	/**
	 * updated by WDY in 2017/1/20
	 * 1.奇怪的是简单插入排序的时间复杂度竟然比二分法插入排序的低！！！
	 * 2.所有排序算法中，堆排序和希尔排序的时间复杂度最低。在数据量较低的情况下
	 *   (array.length < 100000),希尔排序会好于堆排序，数据量高的情况下，堆排序的性能最好！
	 */
	public static void main(String[] args){

		//生成长度为1000，值是随机int的类型的整数数组
		int length = 10000000;
		int[] array = Utils.genRandINTArray(length);

		long begin = 0;


		//测试快速排序的时间复杂度
		begin = System.nanoTime();
		QuickSort.quickSort(Arrays.copyOfRange(array,0,array.length));
		print("快速排序:"+(System.nanoTime()-begin)/1000000+"ms");

		//测试冒泡排序的时间复杂度
		begin = System.nanoTime();
		//BubbleSort.bubbleSort(Arrays.copyOfRange(array,0,array.length));
		print("\n冒泡排序:"+(System.nanoTime()-begin)/1000000+"ms");

		//测试选择排序的时间复杂度
		begin = System.nanoTime();
		//SelectionSort.selectionSort(Arrays.copyOfRange(array,0,array.length));
		print("\n选择排序:"+(System.nanoTime()-begin)/1000000+"ms");

		//测试堆排序的时间复杂度
		begin = System.nanoTime();
		HeapSort.heapSort(Arrays.copyOfRange(array,0,array.length));
		print("堆排序:"+(System.nanoTime()-begin)/1000000+"ms");


		//测试简单插入排序的时间复杂度
		begin = System.nanoTime();
		//InsertSort.insertSort(Arrays.copyOfRange(array,0,array.length));
		print("\n简单插入排序:"+(System.nanoTime()-begin)/1000000+"ms");


		//测试二分法插入排序的时间复杂度
		begin = System.nanoTime();
		//BinaryInsertSort.binaryInsertSort(Arrays.copyOfRange(array,0,array.length));
		print("二分法插入排序:"+(System.nanoTime()-begin)/1000000+"ms");

		//测试希尔排序的时间复杂度
		begin = System.nanoTime();
		ShellSort.shellSort(Arrays.copyOfRange(array,0,array.length));
		print("希尔排序:"+(System.nanoTime()-begin)/1000000+"ms");

	}

	public static void print(Object obj){
		System.out.println(""+obj);
	}
}