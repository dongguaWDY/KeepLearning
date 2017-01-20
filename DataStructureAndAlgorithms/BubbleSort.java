import java.util.Random;


public class BubbleSort{
	public static void main(String[] args){
		
		int[] array = genRandINTArray(1000);
		bubbleSort(array);
		for(int i=0; i<array.length; i++){
			System.out.println(array[i]);
		}
	}


	//generate a random array
	public static int[] genRandINTArray(int length){
		Random rand = new Random();
		int[] array = new int[length];
		long divisor = length * 100;
		for(int i=0; i<array.length; i++){
			array[i] = (int)(rand.nextInt()%divisor);
		}
		return array;
	}

	//implement Bubble Sort
	public static void bubbleSort(int[] array){
		for(int i=array.length-1; i>0; i--){
			for(int j=0; j<i; j++){
				if(array[j] > array[j+1]){
					//swap 
					array[j] = array[j] + array[j+1];
					array[j+1] = array[j] - array[j+1];
					array[j] = array[j] - array[j+1];
				}
			}
		}
	}



}