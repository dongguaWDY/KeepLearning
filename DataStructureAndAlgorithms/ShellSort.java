package DataStructureAndAlgorithms;

public class ShellSort{

	public static void shellSort(int[] array){
		int n = 2;//每组元素个数,初始化为2
		int groups = 0;//总
		while(true){
			if(n > array.length){
				n = array.length;
			}

			groups = array.length/n;
			for(int i=0; i<groups; i++){
				int j = i;
				while(j < array.length){
					int index = j;
					while(true){
						if(index <= i)
							break;
						if(array[index-groups] > array[index]){
							//swap two int
							array[index-groups] = array[index-groups] + array[index];
							array[index] = array[index-groups] - array[index];
							array[index-groups] = array[index-groups] - array[index];

							index -= groups;		
							continue;
						}
						break;
					}
					j += groups;
				}

			}

			n <<= 1;
			if(n == 2*array.length)
				break;
		}
	}

}