package DataStructureAndAlgorithms;

public class QuickSort{
	public static void quickSort(int[] array){
		quickSort(array,0,array.length-1);
		for(int i=0; i<array.length; i++){
			//System.out.println(array[i]);
		}
	}


	private static void quickSort(int[] array, int begin, int end){
		if(begin >= end)
			return;
		int BEGIN = begin;
		int END = end;
		while(begin < end){

			for(; begin<end; end--){
				if(array[begin] > array[end]){
					//swap
					array[begin] = array[begin] + array[end];
					array[end] = array[begin] - array[end];
					array[begin] = array[begin] - array[end];
					break;
				}
			}


			for(; begin<end; begin++){
				if(array[begin] > array[end]){
					//swap
					array[begin] = array[begin] + array[end];
					array[end] = array[begin] - array[end];
					array[begin] = array[begin] - array[end];
					break;
				}
			}

		}
		//System.out.println(""+begin+end+END);
		quickSort(array,BEGIN,begin-1);
		quickSort(array,begin+1,END);
	}
}