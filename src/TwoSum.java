

import java.util.HashMap;

public class TwoSum {
	
	/**
	 *  Given an array of integers, return indices of the two numbers such that they add up to a specific target.

		You may assume that each input would have exactly one solution, and you may not use the same element twice.
		
		Example:
		
		Given nums = [2, 7, 11, 15], target = 9,

		Because nums[0] + nums[1] = 2 + 7 = 9,
		return [0, 1].
	 */
    public static int[] twoSum(int[] nums, int target) {
        
    	int[] indices = new int[2];
    	
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	
    	for (int i = 0; i < nums.length; i++)
    	{
    		int difference = target - nums[i];
    		
    		if (map.containsKey(difference))
    		{
    			indices[0] = map.get(difference);
    			indices[1] = i;
    			break;
    		}
    		
    		map.put(nums[i], i);
    	}
    	
    	return indices;
    }
    
    public static void main(String[] args)
    {
    	int[] nums = new int[]{2, 7, 11, 15};
    	int target = 9;
    	
    	int[] indices = TwoSum.twoSum(nums, target);
    	System.out.println(indices[0] + " " + indices[1]);
    
    }

}
