public class StackPushPopSeq{
	public static boolean judgeIfExists(LinkedList<Integer> pushSeq, LinkedList<Integer> popSeq){

		LinkedList<Integer> temp = new LinkedList<>();

		while(!popSeq.isEmpty()){
			Integer data = popSeq.pop();
			if(Object.equals(temp.peek(), data)){
				temp.pop();
			}else{
				while(true){
					if(pushSeq.isEmpty())
						return false;
					Integer tempData = pushSeq.pop();
					if(Object.equals(tempData, data)){
						break;
					}else{
						temp.push(tempData);
					}
				}
			}
		}

		return true;
	}
}