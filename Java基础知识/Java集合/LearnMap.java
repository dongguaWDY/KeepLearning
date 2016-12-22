import java.lang.*;
import java.util.*;

public class LearnMap{
	public static void main(String[] args){
		HashMap<key1,Integer> hashmap=new HashMap<>();
		hashmap.put(new key1(1),45);
		hashmap.put(new key1(1),54);
		//
		System.out.println(hashmap);
	}
}


class key1{
	private  int value;
	public key1(int value){
		this.value=value;
	}

	@Override
	public boolean equals(Object obj){
		if(obj == this)
			return true;
		if(obj == null || obj.getClass() != this.getClass()){
			return false;
		}
		key1 temp=(key1)obj;
		return temp.value == this.value;
	}

	@Override
	public int hashCode(){
		return this.value;
	}
}
