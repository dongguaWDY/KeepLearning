

public class BinarySearch{
	public static void main(String[] args){

	}

	/**
	 *@param array: 已经按照升序排好顺序的待查找数组
	 *@param key: 查找关键字
	 *@return boolean: 指示是否查找成功
	 */
	public static boolean search(int[] array, int key){
		if(key < array[0] || key > array[array.length-1])
			return false;
		int LIndex=0;
		int RIndex=array.length-1;
		while(LIndex <= RIndex){
			//这种方法效率更高：int MidIndex = LIndex + (RIndex - LIndex) >>> 1;
			int MidIndex = (LIndex+RIndex)/2;

			if(key > array[MidIndex]){
				LIndex = MidIndex+1;//如果不加1或者减1可能会产生什么结果？
			}else if(key < array[MidIndex]){
				RIndex = MidIndex-1;
			}else{
				return true;
			}
		}
		return false;
	}
}