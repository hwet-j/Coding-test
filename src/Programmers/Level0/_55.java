package src.Programmers.Level0;


/*
'm'과 "rn"이 모양이 비슷하게 생긴 점을 활용해 문자열에
 장난을 하려고 합니다. 문자열 rny_string이 주어질 때,
 rny_string의 모든 'm'을 "rn"으로 바꾼
문자열을 return 하는 solution 함수를 작성해 주세요.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _55 {
	public static void main(String[] args) {
		String rny_string = "masterpiece";
		String[] strArr = rny_string.split("");
		List<String> list = new ArrayList<String>();
		for (int i=0; i<strArr.length;i++){
			if(strArr[i].equals("m")){
				list.add("rn");
			} else {
				list.add(strArr[i]);
			}
		}
		String answer = "";
		for(int i=0; i<list.size();i++){
			answer += list.get(i);
		}
		System.out.println(answer);

	}
}


