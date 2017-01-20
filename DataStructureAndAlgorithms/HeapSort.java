import java.util.Random;

public class HeapSort{
	public static void main(String[] args){
		HeapSort hSort = new HeapSort();
		int[] array = hSort.genRandINTArray(100);
		hSort.buildMaxHeap(array);
		hSort.keepMaxHeap(array);
		for(int i=0; i<array.length; i++){
			System.out.println(array[i]);
		}
	}

	//
	private void buildMaxHeap(int[] array){
		for(int i=0; i<array.length; i++){
			int index = i;
			while(index > 0){
				if(array[index] > array[(int)((index-1)/2)]){
					//swap 2 ints
					array[index] = array[index] + array[(int)((index-1)/2)];
					array[(int)((index-1)/2)] = array[index] - array[(int)((index-1)/2)];
					array[index] = array[index] - array[(int)((index-1)/2)];

					index = (index-1)/2;
				}else{
					break;
		 		}
			}
		}
	}

	private void keepMaxHeap(int[] array){
		for(int i=array.length-1; i>0; i--){
			//swap
			array[0] = array[0] + array[i];
			array[i] = array[0] - array[i];
			array[0] = array[0] - array[i];

			for(int j=0; j<i;){
				int changePos = 2*j + 1;

				//in case of index out of bounds
				if(changePos >= i ){
					break;
				}else if(changePos + 1 == i){
					//do nothing
				}else if(array[2*j+1] < array[2*(j+1)]){
					changePos = 2*(j+1);
				}
				
				if(array[j] >= array[changePos]){
					break;
				}

				//swap
				array[j] = array[j] + array[changePos];
				array[changePos] = array[j] - array[changePos];
				array[j] = array[j] - array[changePos];
				j = changePos;
			}
		}
	}

	//generate a random array
	public  int[] genRandINTArray(int length){
		Random rand = new Random();
		int[] array = new int[length];
		long divisor = length * 100;
		for(int i=0; i<array.length; i++){
			array[i] = (int)(rand.nextInt()%divisor);
		}
		return array;
	}
}