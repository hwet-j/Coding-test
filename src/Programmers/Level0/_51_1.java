package src.Programmers.Level0;


/*
문자열 myString이 주어집니다. myString을 문자
"x"를 기준으로 나눴을 때 나눠진 문자열 각각의 길이를 순서대로 저장한 배열을
return 하는 solution 함수를 완성해 주세요.
*/

import java.util.Arrays;

public class _51_1 {
	public static void main(String[] args) {
		String myString = "oxooxoxxox";
		String[] strArr = myString.split("");
		int[] answer = new int[strArr.length+1];
		int cnt = 0;
		int nox = 0;

		for(int i=0;i<strArr.length;i++){
			if (i == 0){
				if (strArr[i].equals("x")){
					answer[cnt++] = 0;
				} else {
					nox = i;
				}
			} else if (i == strArr.length-1){
				if (strArr[i].equals("x")){
					answer[cnt++] = i - nox;
					answer[cnt++] = 0;
				} else {
					answer[cnt++] = i - nox + 1;
				}
			} else {
				if (strArr[i].equals("x")) {
					if (!strArr[i-1].equals("x")){
						answer[cnt++] = i - nox;
						nox = i+1;
					} else {
						answer[cnt++] = 0;
						nox = i+1;
					}
				} else {
					if (strArr[i-1].equals("x")){
						nox = i;
					}
				}
			}
		}
		answer = Arrays.copyOf(answer,cnt);
		System.out.println(Arrays.toString(answer));

	}
}

// contains 또는 stream을 사용하면 쉽게 해결되는듯함.
//

