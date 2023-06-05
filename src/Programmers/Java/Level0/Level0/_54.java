package src.Programmers.Java.Level0.Level0;


/*
문자 "A"와 "B"로 이루어진 문자열 myString과 pat가 주어집니다.
myString의 "A"를 "B"로, "B"를 "A"로 바꾼 문자열의 연속하는 부분
문자열 중 pat이 있으면 1을 아니면 0을 return 하는 solution 함수를 완성하세요.

*/

public class _54 {
	public static void main(String[] args) {
		String myString = "ABBAA";
		String pat = "AABB";
		String myString2 = "";
		int answer = 0;
		String[] strArr = myString.split("");
		for(int i=0;i<strArr.length;i++){
			if(strArr[i].equals("A")) {
				myString2 += "B";
			} else {
				myString2 += "A";
			}
		}
		if(myString2.contains(pat)){
			answer = 1;
		}

	}
}


