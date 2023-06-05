package src.Programmers.Java.Level1;

import java.util.*;


// 선입선출의 특징을 가진 Queue를 사용하면 좋을것 같다.
public class _07카드뭉치 {

	public static void main(String[] args) {
		String[] cards1 = {"i", "water", "drink"};
		String[] cards2 = {"want", "to"};
		String[] goal = {"i", "want", "to", "drink", "water"};
		List<String> list1 = new ArrayList<> (Arrays.asList(cards1));
		List<String> list2 = new ArrayList<> (Arrays.asList(cards2));

		String result = "Yes";

		for (String go:goal){
			if (list1.size() != 0 && list1.get(0).equals(go)){
				list1.remove(0);
			} else if (list2.size() != 0 && list2.get(0).equals(go)){
				list2.remove(0);
			} else {
				result = "No";
				break;
			}
		}
		System.out.println(result);
	}
}

