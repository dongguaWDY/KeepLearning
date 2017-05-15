package DataStructureAndAlgorithms;

public class MergeSort{
	public static void mergeSort(int[] array){
		mergeSort(array, 0, array.length - 1);
		for(int i = 0; i < array.length; i++){
			System.out.println(array[i]);
		}
	}


	private static void mergeSort(int[] array, int begin, int end){
		if(begin >= end)
			return;
		int mid = begin + ((end - begin)>>>1);//注意运算符优先级问题
		mergeSort(array, begin, mid);
		mergeSort(array, mid + 1, end);

		//do merge sort
		int[] temp = new int[end - begin + 1];
		int b1 = begin;
		int b2 = mid + 1;
		int index = 0;
		while(b1 <= mid && b2 <= end){
			if(array[b1] < array[b2]){
				temp[index] = array[b1];
				b1++;
			}else{
				temp[index] = array[b2];
				b2++;
			}
			index++;
		}

		for(; b1 <= mid; b1++,index++){
			temp[index] = array[b1];
		}

		for(; b2 <= end; b2++,index++){
			temp[index] = array[b2];
		}

		//将排序好的数组还给原数组
		for(int i = 0; i < temp.length; i++){
			array[begin + i] = temp[i];
		}
	}
}