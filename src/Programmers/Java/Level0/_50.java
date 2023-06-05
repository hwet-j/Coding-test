package src.Programmers.Java.Level0;


/*
단어가 공백 한 개 이상으로 구분되어 있는 문자열 my_string이
매개변수로 주어질 때, my_string에 나온 단어를 앞에서부터
순서대로 담은 문자열 배열을 return 하는 solution 함수를 작성해 주세요.
*/

import java.util.Arrays;

public class _50 {
	public static void main(String[] args) {
		String my_string = "i love you";
		String[] temp = my_string.split(" ");
		String[] answer = new String[temp.length];
		int cnt = 0;

		for (int i=0;i<temp.length;i++){
			if(temp[i].equals("")){
				continue;
			} else {
				answer[cnt++] = temp[i];
			}
		}
		answer = Arrays.copyOf(answer,cnt);
		System.out.println(Arrays.toString(answer));


	}
}


