package com.leetcode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Design a data structure that supports all following
 * operations in average O(1) time.
 * insert(val): Inserts an item val to set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements.
 *    Each element must have the same probability of being returned.
 * Example:
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 * // Since 1 is the only number in the set, getRandom always return 1.
 * randomSet.getRandom();
 */

/**
 * @brief: RandomizedSet is a HashTable pointing to a vector *
 * HashTable maps given number to a vector index which holds *
 * the actual number                                         *
 * O(1) insert by inserting to end of vector and mapping hash*
 * O(1) randget by directly getting rand index in vector     *
 * O(1) delete by swapping with last vector elem and del last*
 * Time Complexity = O(1), Space Complexity ~ O(2n)          */
public class RandomizedSet {
	
	// map to hold the integer location
	Map<Integer, Integer> map;
	List<Integer> list;
	Random rand = new Random();
	
	/** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
        		return false;
        }
        
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    		
    		boolean contain = map.containsKey(val);
    		
    		if (!contain) return false;
    		
    		// the value to be deleted if it is not last val, swap the last val to value to be deleted, 
    		// and remove the last val
    		int valLocation = map.get(val);
    		if (valLocation < list.size() - 1) {
    			
    			int lastVal = list.get(list.size() - 1);
    			map.put(lastVal, valLocation);
    			list.set(valLocation, lastVal);
    		} 
    		
    		map.remove(val);
    		list.remove(list.size() - 1);
    		return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
    
    public static void main (String []args) {
    		RandomizedSet set = new RandomizedSet();
    		
    		System.out.println("Insert from main : " + set.insert(5));
    		System.out.println("Insert from main : " + set.insert(5));
    		System.out.println("Insert from main : " + set.insert(7));
    		System.out.println("Insert from main : " + set.insert(8));
    		
    		System.out.println("Random from main : " + set.getRandom());
    		System.out.println("Random from main : " + set.getRandom());
    		System.out.println("Random from main : " + set.getRandom());
    		
    		System.out.println("Delete from main : " + set.remove(7));
    		System.out.println("Delete from main : " + set.remove(7));
    		System.out.println("Delete from main : " + set.remove(8));
    }
	
	

}
