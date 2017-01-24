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

				//System.out.println(2);
				while(j < array.length){
					int index = j;
					//System.out.println(3);
					while(true){
						//System.out.println(4);
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
					//System.out.println("RandomDFJ:"+groups+":"+j+":"+array.length);
					j += groups;
				}

			}

			n <<= 1;
			if(n == 2*array.length)
				break;
		}
	}

}