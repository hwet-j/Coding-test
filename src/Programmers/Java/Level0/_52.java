package src.Programmers.Java.Level0;


/*
문자열 myString이 주어집니다. "x"를 기준으로 해당 문자열을 잘라내 배열을
만든 후 사전순으로 정렬한 배열을 return 하는 solution 함수를 완성해 주세요.

단, 빈 문자열은 반환할 배열에 넣지 않습니다.
*/

import java.util.Arrays;

public class _52 {
	public static void main(String[] args) {
		String myString = "dxccxxbbbxaaaa";
		String[] myArr = myString.split("x");
		Arrays.sort(myArr);
		System.out.println(Arrays.toString(myArr));

		int cnt = 0;
		for (int i=0; i< myArr.length; i++){
			if (myArr[i].equals("")){
				cnt++;
			}
		}
		String[] answer = Arrays.copyOfRange(myArr,  cnt, myArr.length);
		System.out.println(Arrays.toString(answer));

	}
}

