package techQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		List<List<String>> output = groupAnagrams(strs);
		
		for (List l : output) {
			System.out.println(l.toString());
		}
	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {
		int[] count = new int[26];
				
		Map<String, List> map = new HashMap<String, List>();
		
		for (String s: strs) {
			// initialize count for each string in strs
			Arrays.fill(count, 0);
			for (char c: s.toCharArray()) {
				count[c - 'a']++;
			}
			StringBuilder sb = new StringBuilder("");
			for (int i = 0; i < 26; i++) {
				sb.append('#');
				sb.append(count[i]);
			}
			String key = sb.toString();
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList());
			}
			map.get(key).add(s);
		}
		
		return new ArrayList(map.values());
	}

}
