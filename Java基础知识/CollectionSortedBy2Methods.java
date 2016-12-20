

import java.lang.Comparable;
import java.util.*;

public class CollectionSortedBy2Methods{
	public static void main(String[] args){
		List<MyApple> list=new ArrayList<>();
		for(int i=0;i<20;i++){
			list.add(new MyApple(i));
		}
		Collections.sort(list);
		System.out.println("after sorted:"+list);

		Collections.sort(list,new Comparator<MyApple>(){
			@Override
			public int compare(MyApple o1, MyApple o2){
				if(o1.volumn == o2.volumn){
					return 0;
				}else if(o1.volumn > o2.volumn){
					return -1;
				}else{
					return 1;
				}
			}

			/*
			@Override
			public boolean equals(Object obj){
				return true;
			}
			*/
		});
		System.out.println("after sorted again:"+list);
	}
}


//method 1:implements Comparable
class MyApple implements Comparable<MyApple>{
	public int volumn;

	public MyApple(int volumn){
		this.volumn=volumn;
	}

	@Override
	public String toString(){
		return "volumn:"+this.volumn;
	}

	@Override
	public int compareTo(MyApple o){
		if(this.volumn == o.volumn){
			return 0;
		}else if(this.volumn > o.volumn){
			return 1;
		}else{
			return -1;
		}
	}
}