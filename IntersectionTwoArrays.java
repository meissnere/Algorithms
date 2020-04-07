package techquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class IntersectionTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		
		System.out.println(Arrays.toString(intersection(nums1, nums2)));
	}
	
	public static int[] set_intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
	    int [] output = new int[set1.size()];
	    int idx = 0;
	    for (Integer s : set1) {
	    	System.out.println(idx);
	      if (set2.contains(s)) output[idx=idx+1] = s;
	    }
	    
	    System.out.println(Arrays.toString(output));

	    return Arrays.copyOf(output, idx);
	  }

	  public static int[] intersection(int[] nums1, int[] nums2) {
	    HashSet<Integer> set1 = new HashSet<Integer>();
	    for (Integer n : nums1) set1.add(n);
	    HashSet<Integer> set2 = new HashSet<Integer>();
	    for (Integer n : nums2) set2.add(n);
	    
	    if (set1.size() < set2.size()) return set_intersection(set1, set2);
	    else return set_intersection(set2, set1);
	  }

}
