

public class MinStack{

	LinkedList<Integer> stack = new LinkedList<>();
	LinkedList<Integer> helpStack = new LinkedList<>();

	void push(int num){
		Integer num = new Integer(num);
		stack.push(num);
		if(num < helpStack.peek()){
			helpStack.push(num);
		}
	}

	Integer pop(){
		Integer ret = stack.pop();
		if(null != ret && ret == helpStack.peek())
			helpStack.pop();
		return ret;
	}

	Integer getMin(){
		return helpStack.peek();
	}
}




