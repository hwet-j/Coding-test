package src.Programmers.Level1;

import java.lang.reflect.Array;
import java.util.*;

public class _06대충만든자판 {

	public static void main(String[] args) {
		String[] keymap = {"BC"};
		String[] targets = {"AC", "BC"};

		Set<String> set1 = new HashSet<>();
		for (int i = 0; i<targets.length; i++){
			String[] setData = targets[i].split("");
			for (int j=0; j<setData.length; j++){
				set1.add(setData[j]);
			}
		}
		Map<String, Integer> map1 = new HashMap<>();
		int min = 101;
		int temp = 0;
		for (String sd:set1){
			min = 101;
			for (int i=0; i<keymap.length; i++){
				if (keymap[i].contains(sd)){
					for (int j=0; j<keymap[i].length();j++){
						if (keymap[i].substring(j, j+1).equals(sd)){
							temp = j;
							break;
						}
					}
					if (temp < min){
						min = temp;
					}
				}
			}
			map1.put(sd,min+1);
		}

		int[] answer = new int[targets.length];
		int sum = 0;
		for (int i=0; i<targets.length; i++){
			sum = 0;
			for(int j=0; j<targets[i].length(); j++){
				if (map1.get(targets[i].substring(j,j+1)) == 102){
					sum = 0;
					break;
				} else {
					sum += map1.get(targets[i].substring(j,j+1));
				}
			}
			if (sum == 0){
				answer[i] = -1;
			} else {
				answer[i] = sum;
			}
		}

		System.out.println(Arrays.toString(answer));



	}
}

