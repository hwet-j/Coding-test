package src.Programmers;


/*
문자열 배열 strArr가 주어집니다. 배열 내의 문자열 중
"ad"라는 부분 문자열을 포함하고 있는 모든 문자열을
제거하고 남은 문자열을 순서를 유지하여 배열로
return 하는 solution 함수를 완성해 주세요.
*/

import java.util.Arrays;

public class _48 {
	public static void main(String[] args) {
		String[] strArr = {"and","notad","abcd"};
		String tempStr = "";

		for (int i=0; i<strArr.length;i++){
			String[] temp = strArr[i].split("");
			tempStr = "";
			for (int j=0; j< temp.length-1; j++){
				if ((temp[j] + temp[j+1]).equals("ad")){
					temp[j] = "";
					temp[j+1] = "";
				}
				tempStr += temp[j];
			}
			tempStr += temp[temp.length-1];
			strArr[i] = tempStr;
		}
		System.out.println(Arrays.toString(strArr));

	}
}

// 한국어를 잘못해서 작성한 문제...

// ad를 포함하면 전체 삭제를 하면되었으나 ad만 삭제하는 작업을 진행함

