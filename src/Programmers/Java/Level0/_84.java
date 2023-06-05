package src.Programmers.Java.Level0;


/*
알파벳 소문자로 이루어진 문자열 myString이 주어집니다.
알파벳 순서에서 "l"보다 앞서는 모든 문자를 "l"로 바꾼
문자열을 return 하는 solution 함수를 완성해 주세요.
*/

public class _84 {
	public static void main(String[] args) {
		String myString = "abcdevwxyz";
		String answer = "";
		char[] charArr = new char[myString.length()];

		for(int i=0; i<myString.length(); i++){
			charArr[i] = myString.charAt(i);
		}
		for(int i=0; i<myString.length(); i++){
			if ((int) charArr[i] < 108){
				charArr[i] = 'l';
			}
		}
		for(int i=0; i<myString.length(); i++){
			answer += charArr[i];
		}

	}
}


