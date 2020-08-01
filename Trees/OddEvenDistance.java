/**
 * This is function problem to find the odd even level difference in Binary Tree.
 */
class OddEvenDistance
{
	int getLevelDiff(Node root)
	{
	    Map<Integer,Integer> bucket = new HashMap<>();
	    updateLevelSum(root, 0, bucket);
	    int evenSum = 0;
	    int oddSum = 0;
	    
	    for(Map.Entry<Integer, Integer> count: bucket.entrySet()){
	        int key = count.getKey();
	        int value = count.getValue();
	        
	        if(key % 2 == 0){
	            evenSum += value;
	        }else {
	            oddSum += value;
	        }
	    }
	    
	    return evenSum - oddSum;
	}
	
	private void updateLevelSum(Node node, int level, 
	    Map<Integer,Integer> bucket){
	    
	    if(node == null) return;
	    
	    int sum = bucket.getOrDefault(level, 0);
	    
	    bucket.put(level, sum + node.data);
	    
	    updateLevelSum(node.left, level+1, bucket);
	    updateLevelSum(node.right, level+1, bucket);
    }
}