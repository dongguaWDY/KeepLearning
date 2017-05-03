import java.util.*;


/*
 *问题描述：有面值为1元、3元和5元的硬币若干枚(足够)，如何用最少的硬币凑够11元？
 */

public class Coins{
	public static void main(String[] args){
		for(int i = 0; i < 12; i++){
			System.out.println(minCoins(i));	
		}
		
	}

	//缓存，避免重复计算
	private static Map<Integer, Integer> map = new HashMap<>();
	static{
		map.put(0, 0);
	}
	public static int minCoins(int total){
		Integer ret = map.get(total);
		if(null == ret){
			int minCoins = Integer.MAX_VALUE;
			int[] temp = new int[]{1, 3, 5};
			for(int num : temp){
				if(total - num < 0)break;
				else{
					int nextMin = minCoins(total - num) + 1;
					if(minCoins > nextMin){
						minCoins = nextMin;
					}
				}
			}
			map.put(total, minCoins);
			return minCoins;
		}else{
			return ret;
		}
	}
}