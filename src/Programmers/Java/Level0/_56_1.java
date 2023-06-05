package src.Programmers.Java.Level0;


/*
임의의 문자열이 주어졌을 때 문자 "a", "b", "c"를 구분자로 사용해 문자열을 나누고자 합니다.

예를 들어 주어진 문자열이 "baconlettucetomato"라면 나눠진 문자열 목록은 ["onlettu", "etom", "to"] 가 됩니다.

문자열 myStr이 주어졌을 때 위 예시와 같이 "a", "b", "c"를 사용해 나눠진 문자열을 순서대로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.

단, 두 구분자 사이에 다른 문자가 없을 경우에는 아무것도 저장하지 않으며, return할 배열이 빈 배열이라면 ["EMPTY"]를 return 합니다.
*/

import java.util.Arrays;

public class _56_1 {
	public static void main(String[] args) {
		String myStr = "baconlettucetomato";

		String[] answer = new String[myStr.length()];

		int temp = 0;
		int cnt = 0;
		String[] strArr = myStr.split("");

		for (int i = 0; i < strArr.length; i++) {
			if (i != strArr.length - 1) {
				if (strArr[i].equals("a") || strArr[i].equals("b") || strArr[i].equals("c")) {
					if (i != 0){
						if (!(strArr[i - 1].equals("a") || strArr[i - 1].equals("b") || strArr[i - 1].equals("c"))) {
							answer[cnt++] = myStr.substring(temp, i);
							temp = i;
						}
					}
				} else {
					if (i != 0){
						if (strArr[i - 1].equals("a") || strArr[i - 1].equals("b") || strArr[i - 1].equals("c")) {
							temp = i;
						}
					}
				}
			}else {
				if (strArr[i].equals("a") || strArr[i].equals("b") || strArr[i].equals("c")) {
					if (!(strArr[i - 1].equals("a") || strArr[i - 1].equals("b") || strArr[i - 1].equals("c"))) {
						answer[cnt++] = myStr.substring(temp, i);
						temp = i;
					}
				} else {
					if (!(strArr[i - 1].equals("a") || strArr[i - 1].equals("b") || strArr[i - 1].equals("c"))) {
						answer[cnt++] = myStr.substring(temp, strArr.length);
						temp = i;
					} else {
						answer[cnt++] = myStr.substring(i, strArr.length);
					}
				}
			}
		}
		if (cnt == 0){
			answer = new String[]{"EMPTY"};
		} else {
			answer = Arrays.copyOf(answer, cnt);
		}
		System.out.println(Arrays.toString(answer));
	}
}

