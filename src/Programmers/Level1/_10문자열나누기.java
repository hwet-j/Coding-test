package src.Programmers.Level1;


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
		int cnt = 0;
		for (String item:set){
			map.put(item,0);
		}

		for (int i=0;i<s.length();i++){
			String key = s.substring(i, i+1);
			map.replace(key, map.get(key) + 1);
			for (String mapKey: map.keySet()){
				if (key == s.substring(i, i+1));

			}

		}


	}
}
