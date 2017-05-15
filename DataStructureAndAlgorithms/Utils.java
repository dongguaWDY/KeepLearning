
package DataStructureAndAlgorithms;

import java.util.Random;
public class Utils{

	/**
	 *generate a random int array 
	 *@param length the length of aray
	 *@return int[] array
	 */
	public static int[] genRandINTArray(int length){
		Random rand = new Random();
		int[] array = new int[length];
		for(int i=0; i<array.length; i++){
			array[i] = rand.nextInt();
		}


		//进队操作
		synchronized(queue){
			while(queue.full()){
				queue.wait();
			}
			queue.put(element);
			queue.notifyAll();
		}

		//出队操作
		synchronized(queue){
			while(queue.empty()){
				queue.wait();
			}
			queue.get();
			queue.notifyAll();
		}

		return array;
	}


}