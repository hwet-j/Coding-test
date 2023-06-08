package src.Programmers.Java.Level1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _10문자열나누기 {
	public static void main(String[] args) {
		String s = "banana";
		Set<String> set = new HashSet();

		for (int i=0; i<s.length();i++){
			set.add(s.substring(i, i+1));
		}

		Map<String, Integer> map = new HashMap();

		for (String item:set){
			map.put(item,0);
		}
		int answer = 0;
		for (int i=0;i<s.length();i++){
			String key = s.substring(i, i+1);

			System.out.println(map);
			System.out.println(map.containsValue(map.get(key)+1));
			if (map.containsValue(map.get(key)+1) && i != s.length()-1){
				for (String item:set){
					map.replace(item,0);
				}
				answer++;
			} else {
				map.replace(key, map.get(key) + 1);
				if (i == s.length()-1){
					answer++;
				}
			}

		}
		System.out.println(answer);
	}
}
