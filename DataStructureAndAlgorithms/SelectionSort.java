package DataStructureAndAlgorithms;
import java.util.Random;


public class SelectionSort{
	public static void selectionSort(int[] array){
		for(int i = 0; i < array.length-1; i++){
			int minIndex = i;
			for(int j = i + 1; j < array.length; j++){
				if(array[j] < array[minIndex]){
					minIndex = j;
				}
			}

			// swap  2 ints
			if(i == minIndex)
				continue;//why need this step WDY??
			array[i] = array[i] + array[minIndex];
			array[minIndex] = array[i] - array[minIndex];
			array[i] = array[i] - array[minIndex];
		}
	}
}