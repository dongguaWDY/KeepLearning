

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

		//使用匿名内部类
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

			//Note that it is always safe not to override Object.equals(Object)(From JavaDoc)
			/*
			@Override
			public boolean equals(Object obj){
				return true;
			}
			*/

			//匿名内部类不允许定义static方法，根本也没这个必要
			/*
			public static void callStaticMethod(){
				System.out.println("in Static Method");
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



class  test implements Comparator<test>{
	/*
	@Override
	public int compare(test o1, test o2){
		return 0;
	}
	*/

	@Override
	public boolean equals(Object obj){
		return true;
	}
}