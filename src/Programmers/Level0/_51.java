package src.Programmers.Level0;


/*
문자열 myString이 주어집니다. myString을 문자
"x"를 기준으로 나눴을 때 나눠진 문자열 각각의 길이를 순서대로 저장한 배열을
return 하는 solution 함수를 완성해 주세요.
*/

import java.util.Arrays;

public class _51 {
	public static void main(String[] args) {
		String my_string = "xo";
		String[] strArr = my_string.split("");
		int num = 0;
		int temp = 0;
		int[] intArr = new int[strArr.length + 1];
		int cnt = 0;

		for (int i=0;i<strArr.length;i++){
			if (strArr[i].equals("x")){
				num = i;
				System.out.println("x일때" + i);

				if (i == 0){
					intArr[cnt++] = 0;
					System.out.println("1번");
				} else if (!strArr[i-1].equals("x")){
					intArr[cnt++] = num - temp;
					System.out.println("2번");
				} else if (strArr[i-1].equals("x")){
					intArr[cnt++] = 0;
					System.out.println("3번");
				}
				if (i == strArr.length-1){
					intArr[cnt++] = strArr.length - temp;
					System.out.println("4번");
				}
			} else {
				if (i != 0 && strArr[i-1].equals("x")){
					temp = i;
					System.out.println("1번");
					if (i == strArr.length-1){
						intArr[cnt++] = strArr.length - temp;
					}
				} else if (i == strArr.length-1){
					intArr[cnt++] = strArr.length - temp;
					System.out.println("2번");
				}

				System.out.println("x아닐때" + i);
			}
			System.out.println();
		}
		intArr = Arrays.copyOf(intArr, cnt);
		System.out.println(Arrays.toString(intArr));

	}
}


// 부분 테스트 실패..
