package techQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;

public class FindLuckyInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,2,3,3,3};
		
		System.out.println(findLucky(arr));
	}
		
	public static int findLucky(int[] arr) {
		
		if (arr.length < 1 || arr == null) {
			return -1;
		}
		
		
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				int count = map.get(arr[i]);
//				System.out.println(count);
				count = count + 1;
				map.replace(arr[i], count);
//				System.out.println(count);
			} else if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			}
		}
		
		Set<Integer> set = map.keySet();
		List<Integer> list = new ArrayList<>();
		
//		System.out.println(map.values());
		
		for (int num : set) {
			if (num == map.get(num)) {
//				System.out.println(num);
				list.add(num);
			}
		}
		
		Collections.sort(list);


//		for (int x : list) {
//			System.out.println(x);
//		}
		
		if (list.size() < 1) {
			return -1;
		}
		
		return list.get(list.size()-1);
	}

}
