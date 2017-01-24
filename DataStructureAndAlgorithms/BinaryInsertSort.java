
package DataStructureAndAlgorithms;

public class BinaryInsertSort{
	/**
	 *二分法插入排序算法
	 *@version:v1
	 *@author:WDY
	 *@datetime:2017.1.2
	 *
	 *二分法如果找不到元素
     */
	/*
	public static void binaryInsertSort(int[] array){
		for(int i=1; i<array.length; i++){
			int flag = array[i];

			//二分法查找元素flag的插入位置
			int right=i-1;
			int left=0;
			int midIndex=0;
			while(left <= right){
				midIndex=(int)((left+right)/2);

				if(flag < array[midIndex]){
					right = midIndex-1;
				}else if(flag > array[midIndex]){
					left = midIndex+1;
				}else{//查找成功
					left = midIndex+1;
					right = midIndex+1;
					break;
				}
			}
			int insertPos = left;

			//移动其他元素并插入flag
			for(int j=i-1; j >= insertPos; j--){
				array[j+1]=array[j];
			}
			array[insertPos]=flag;
		}
	}
	*/


	/**
	 *二分法插入排序算法
	 *@version:v2
	 *@author:WDY
	 *@datetime:2017.1.23
	 *
	 *使用位运算优化
     */
	public static void binaryInsertSort(int[] array){
		for(int i=1; i<array.length; i++){
			int flag = array[i];

			//二分法查找元素flag的插入位置
			int right=i-1;
			int left=0;
			int midIndex=0;
			while(left <= right){
				midIndex = (left+right)>>>1;

				if(0 == (flag^(array[midIndex]))){
					//查找成功
					left = midIndex+1;
					right = midIndex+1;
					break;
				}
				else if(flag < array[midIndex]){
					right = midIndex-1;
				}else{
					left = midIndex+1;
				}
			}
			int insertPos = left;

			//移动其他元素并插入flag
			for(int j=i-1; j >= insertPos; j--){
				array[j+1]=array[j];
			}
			array[insertPos]=flag;
		}
	}
}