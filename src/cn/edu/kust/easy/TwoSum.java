package cn.edu.kust.easy;

import java.util.HashMap;

/**
 *
 * 1. Two Sum
 * pass
 */
public class TwoSum {
	
	/**
	 * O(n)
	 */
	public int[] twoSum(int[] numbers, int target) {
	    int[] result = new int[2];
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < numbers.length; i++) {
	    	//将数组元素及索引存入HashMap，数组元素值作为Key，数组索引作为Value
	    	//使用目标值减去数组元素，获得差值（即对目标数的补数），如果该补数存在于HashMap中，则将其提取出来并返回
	        if (map.containsKey(target - numbers[i])) {
	            result[1] = i;
	            result[0] = map.get(target - numbers[i]);
	            return result;
	        }
	        map.put(numbers[i], i);
	    }
	    return result;
	}
}
