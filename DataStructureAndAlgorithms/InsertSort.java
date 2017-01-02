import java.util.Random;


public class InsertSort{
    /**
	 *简单插入排序算法
	 *@version:v1
	 *@author:WDY
	 *@datetime:2014.7.21
     */
    /*
	public static void insertSort(int[] targetArray){
  		int n=targetArray.length;
  		for(int i=1;i<n;i++){
   			int temp=i;
        	while(temp!=0){
	       		if(targetArray[temp-1]>targetArray[temp]){
    	    		//交换两个数
        			int k=targetArray[temp];
        			targetArray[temp]=targetArray[temp-1];
        			targetArray[temp-1]=k;
        			temp--;
       			}else{
        			break;
       			}
      		}
  		}
 	}
	*/

 	/**
	 *简单插入排序算法
	 *@version:v2
	 *@author:WDY
	 *@datetime:2017.1.1
     */
 	/*
	public static void insertSort(int[] array){
		for(int i=1; i<array.length; i++){
			int flag=array[i];
			for(int j=i-1; j>=0; j--){
				if(array[j] > flag){
					array[j+1] = array[j];
				}else{
					array[j+1] = flag;
					break;
				}
			}
		}
	}
	*/


	/**
	 *二分法简单插入排序算法
	 *@version:v3
	 *@author:WDY
	 *@datetime:2017.1.2
	 *
	 *二分法如果找不到元素
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
     */
	public static void insertSort(int[] array){
		for(int i=1; i<array.length; i++){
			int flag = array[i];

			//二分法查找元素flag的插入位置
			int right=i-1;
			int left=0;
			int midIndex=0;
			while(true){
				//System.out.println("hello");
				if(left > right)
					break;
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



	public static void main(String[] args){
		int[] array=new int[100];
		Random rand=new Random(3847);
		for(int i=0; i<array.length; i++){
			//随机数初始化
			array[i] = rand.nextInt()%500;
		}

		insertSort(array);
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);	
		}
		
	}

}





