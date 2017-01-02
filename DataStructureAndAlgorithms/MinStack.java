

public class MinStack{

	private static class Node{
		public Integer e;
		public Node next;
	}

	private Node head;

	private List<Integer> list=new LinkedList<>();

	public void push(Integer e){
		list.add(e);
		Node temp=head;
		Node priHead=head;
		Node node=new Node();
		node.e=e;
		while(temp != null){
			if(temp.next == null){
				temp.next=node;
				break;
			}

			if(e < temp.e){
				priHead.next=node;
				node.next=temp;
				if(temp == head){
					node.next=head;
					head = node;
				}
			}

			priHead=temp;
			temp=temp.next;
		}
	}

	public Integer pop(){
		if(list.length() == 0)
			return null;

		Integer e=list.remove(list.length()-1);
		Node temp=head;
		Node priHead=head;
		while(temp != null){
			if(temp.e == e){
				priHead.next=temp.next;
				temp.e=null;
				temp.next=null;
				break;
			}
			priHead=temp;
			temp=temp.next;
		}
		return e;
	}


	public Integer getMin(){
		list.remove(head.e);
		Integer e=head.e;
		head=head.next;
		return e;
	}
}




