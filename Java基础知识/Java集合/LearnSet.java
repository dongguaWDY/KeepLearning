import java.lang.*;
import java.util.*;



public class LearnSet{
	public static void main(String[] args){

		/*
		TreeSet<Ele2InSet> treeset2=new TreeSet<>();
		for(int i=0;i<30;i++){
			treeset2.add(new Ele2InSet(i));
		}
		System.out.println(treeset2);
		*/

		/*
		TreeSet<EleInSet> treeset1=new TreeSet<>();
		for(int i=0;i<30;i++){
			treeset1.add(new EleInSet(i));
		}
		*/

		/**
		 * 下面的两个输出结果验证了HashSet(不包括TreeSet)判断两个元素相等的依据是当且仅当o1.equals(o2)==true&&o1.hashCode()==o2.hashCode()
		 */
		/*
		HashSet<EleInHashSet> hashset=new HashSet<>();
		for(int i=0;i<20;i++){
			hashset.add(new EleInHashSet(i));
		}
		System.out.println(hashset);
		EleInHashSet temp=new EleInHashSet2(7);
		hashset.add(temp);
		System.out.println(hashset);
		*/

		/**
		 * 下面的两个输出结果验证了包括TreeSet判断两个元素相等的依据是Comparable接口compare方法返回的结果，如果返回0则认为这两个元素相等，否则不相等
		 */
		HashSet<MyNode1> hashset=new HashSet<>();
		for(int i=0;i<20;i++){
			hashset.add(new MyNode1());
		}
		System.out.println(hashset.size());

		TreeSet<MyNode1> treeset=new TreeSet<>();
		for(int i=0;i<20;i++){
			treeset.add(new MyNode1());
		}
		System.out.println(treeset.size());
	}
}


/**
 * 创建这个类的目的是为了验证：HashSet判断元素相同的依据是根据equals的结果还是
 * equals和hashCode共同的结果
 */
class EleInHashSet{
	public int value;
	public EleInHashSet(int value){
		this.value=value;
	}

	@Override
	public boolean equals(Object obj){
		if(obj == this)
			return true;
		if(obj == null || obj.getClass() != this.getClass()){
			return false;
		}
		EleInHashSet temp=(EleInHashSet)obj;
		return temp.value == this.value;
	}

	/**
	 * 如果不重写hashCode方法，则任何对象返回的hashCode值都不相等（有很小概率会发生hash碰撞）
	 */
	
	@Override
	public int hashCode(){
		// always return the same hashcode
		return 4552;
	}

	@Override
	public String toString(){
		return	"element:"+this.value;
	}
}

class EleInHashSet2 extends EleInHashSet{
	public EleInHashSet2(int value){
		super(value);
	}

	@Override
	public int hashCode(){
		// always return the same hashcode
		return 34345;
	}
}






class EleInSet{
	public int value;
	public EleInSet(int value){
		this.value=value;
	}
}

class Ele2InSet implements Comparable<Ele2InSet>{
	public int value;
	public Ele2InSet(int value){
		this.value=value;
	}


	@Override
	public String toString(){
		return "obj="+this.value;
	}

	@Override
	public boolean equals(Object o){
		if(o == this){
			return true;
		}
		if(o == null || this.getClass() != o.getClass()){
			return	false;
		}
		Ele2InSet temp=(Ele2InSet)o;
		if(this.value%2 == temp.value%2){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public int compareTo(Ele2InSet o){
		return this.value%2-o.value%2;
		//return this.value-o.value;
	}
}


/**
 *创建这个类的目的是为了验证TreeSet判断元素相同的依据是根据compareTo方法返回的结果还是跟HashSet方法一样
 */
class MyNode1 implements Comparable<MyNode1>{

	@Override
	public boolean equals(Object obj){
		return true;
	}

	@Override
	public int hashCode(){
		return 356;
	}

	@Override
	public int compareTo(MyNode1 obj){
		return 1;
	}
}