class AliMain {

/** 请完成下面这个函数，实现题目要求的功能 **/
 /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String jump(String arr) {
        //分割字符串，转化成int类型
    	String[] strs = arr.split(",");
    	int[] array = new int[strs.length];
    	for(int i = 0; i < strs.length; i++){
    		array[i] = Integer.parseInt(strs[i]);
    	}

    	//动态规划
    	Node[] nodes = new Node[array.length];
    	for(int i = 0; i < array.length; i++){
    		Node node = new Node();

    		if(i < 2){
    			node.lastIndex = 0;
    			node.count = i; 
    		}else{
    			node.count = Integer.MAX_VALUE;
    			for(int k = 0; k < i; k++){
    				if(k + array[k] >= i){
    					if(nodes[k].count + 1 < node.count){
    						node.lastIndex = k;
    						node.count = nodes[k].count + 1;
    					}
    				}
    			}
    		}
    		nodes[i] = node;
    	}

    	int lastIndex = array.length - 1;
    	String result = "";
    	while(lastIndex != 0){
    		result = "" + array[lastIndex] + "," + result;
    		lastIndex = nodes[lastIndex].lastIndex;
    	}
    	result = "" + array[lastIndex] + "," + result;
    	return result;

    }

    private static class Node{
    	public int lastIndex;
    	public int count;//走了几步
    }

}