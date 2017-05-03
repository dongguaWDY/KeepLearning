package DataStructureAndAlgorithms;
import java.util.Random;


public class BubbleSort{
	//implement Bubble Sort
	public static void bubbleSort(int[] array){
		for(int i = array.length-1; i > 0; i--){
			for(int j = 0; j < i; j++){
				if(array[j] > array[j+1]){
					//swap 注意交换两数方式（效率更高）
					array[j] = array[j] + array[j+1];
					array[j+1] = array[j] - array[j+1];
					array[j] = array[j] - array[j+1];
				}
			}
		}
	}



}