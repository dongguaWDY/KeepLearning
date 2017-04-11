//package DataStructureAndAlgorithms.tree;

import java.util.*;

public class BinarySortTree{

	public static void main(String[] args){;
		
		int[] array = new int[]{ 79, 41, 30, 38, 71, 33, 26, 84, 59};
		//int[] array = new int[]{-5, 79, -57, -91, 41, 30, -17, -15, 38, -69, 71, -1, -8, -49, 33, 26, -58, 84, 59, -80};
		BinarySortTree tree = new BinarySortTree(array);
		//遍历
		tree.inOrder();
		//查找
		String result = "exists: ";
		for(int i = -10; i < 80; i++){
			if(tree.searchTree(i)){
				result += i + ",";
			}
		}
		System.out.println("\n" + result);

		tree.deleteNode(41);
		tree.inOrder();
		//删除某个节点
		/*
		for(int i = -10; i < 80; i++){
			if(tree.deleteNode(i)){
				System.out.println("删除节点：" + i);
				tree.inOrder();
			}
		}
		*/
		
	}


	private static class Node{
		int val;
		Node left;
		Node right;
		public Node(int val){
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

	private Node root;

	public BinarySortTree(int[] array){
		createBinarySortTree(array);
	}
	public BinarySortTree(){

	}

	private void createBinarySortTree(int[] array){
		for(int val : array){
			insertIntoBinarySortTree(val);
		}
	}

	public boolean insertIntoBinarySortTree(int val){
		if(null == root){
			root = new Node(val);
			return true;
		}else{
			return insertIntoBinarySortTree(root, val);
		}
	}
	private boolean insertIntoBinarySortTree(Node root, int val){
		if(val == root.val){
			return false;
		}else{
			if(val < root.val){
				if(root.left == null){
					root.left = new Node(val);
					return true;
				}else{
					return insertIntoBinarySortTree(root.left, val);
				}
			}else{
				if(root.right == null){
					root.right = new Node(val);
					return true;
				}else{
					return insertIntoBinarySortTree(root.right, val);
				}
			}
		}
	}


	//查找
	public boolean searchTree(int val){
		Node temp = root;
		while(null != temp){
			if(val == temp.val)
				return true;
			else if(val < temp.val){
				temp = temp.left;
			}else{
				temp = temp.right;
			}
		}
		return false;
	}


	//删除某个节点
	public boolean deleteNode(int val){
		Node temp = root;
		Node node = null;
		Node parentNode = root;
		//找到欲删除节点的指针和其双亲指针
		while(null != temp){
			if(val == temp.val){
				node = temp;
				break;
			}else{
				parentNode = temp;
				if(val < temp.val){
					temp = temp.left;
				}else{
					temp = temp.right;
				}
			}
			/*//代码禁止重复
			else if(val < temp.val){
				parentNode = temp;//代码静止重复
				temp = temp.left;
			}else{
				parentNode = temp;
				temp = temp.right;
			}
			*/
		}
		if(null == temp)
			return false;

		if(node == parentNode){//当欲删除节点是根节点时，需要做点特殊修改，这样函数调用才有一致性
			parentNode = new Node(0);
			parentNode.left = node;
			deleteNode(parentNode, node);
			root = parentNode.left;
		}else{
			deleteNode(parentNode, node);
		}
		return true;
	}

	private void deleteNode(Node parentNode, Node node){
		if(node.left != null && node.right != null){
			Node temp = node.right;
			Node pareOfTemp = node;
			while(temp.left != null){
				pareOfTemp = temp;
				temp = temp.left;
			}			

			if(node == parentNode.left){
				parentNode.left = temp;
			}else{
				parentNode.right = temp;
			}

			if(temp == node.right){
				temp.left = node.left;
			}else{
				pareOfTemp.left = temp.right;
				temp.left = node.left;
				temp.right = node.right;
			}
			node.left = null;
			node.right = null;
		}else{
			Node temp = null;//这个变量的作用仅仅是为了使用三目运算符
			if(node.left == null){
				temp = parentNode.left == node ? (parentNode.left = node.right) : (parentNode.right = node.right);//注意运算符优先级问题
			}else{
				temp = parentNode.left == node ? (parentNode.left = node.left) : (parentNode.right = node.left);
			}
		}
	}


	//遍历
	public void inOrder(){
		inOrder(root);
	}
	private void inOrder(Node root){
		if(null == root)
			return;
		else{
			
			inOrder(root.left);
			System.out.print("" + root.val + ",");
			inOrder(root.right);
		}
	}


}