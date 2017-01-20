public class HeapSort{
	public static void main(String[] args){
		HeapSort hSort = new HeapSort();
	}

	//
	public void buildMaxHeap(int[] array){
		for(int i=0; i<array.length; i++){
			int index = i;
			while(index > 0){
				if(array[index] > array[(int)((i-1)/2)]){
					//swap 2 ints
					array[index] = array[index] + array[(int)((i-1)/2)];
					array[(int)((i-1)/2)] = array[index] - array[(int)((i-1)/2)];
					array[index] = array[index] - array[(int)((i-1)/2)];
					index = (i-1)/2;
					continue;
				}
				break;
			}
		}
	}
}