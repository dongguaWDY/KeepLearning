package DataStructureAndAlgorithms;
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


}





