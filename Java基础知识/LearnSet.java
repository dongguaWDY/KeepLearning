import java.lang.*;
import java.util.*;



public class LearnSet{
	public static void main(String[] args){


		TreeSet<Ele2InSet> treeset2=new TreeSet<>();
		for(int i=0;i<30;i++){
			treeset2.add(new Ele2InSet(i));
		}
		System.out.println(treeset2);
		/*
		TreeSet<EleInSet> treeset1=new TreeSet<>();
		for(int i=0;i<30;i++){
			treeset1.add(new EleInSet(i));
		}
		*/

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