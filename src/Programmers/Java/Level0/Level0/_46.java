package src.Programmers.Java.Level0.Level0;


/*
문자열 myString과 pat가 주어집니다. myString의 부분 문자열중
pat로 끝나는 가장 긴 부분 문자열을 찾아서 return 하는 solution 함수를 완성해 주세요.
*/

public class _46 {
	public static void main(String[] args) {
//		String myString =  "AbCdEFG";
//		String pat = "dE";
		String myString =  "AAAAaaaa";
		String pat = "a";
		String answer = "";
		int num = 0;

		for (int i=0; i<myString.length();i++){
			if (!myString.substring(i,myString.length()).contains(pat)){
				num = i;
				break;
			}
		}


		if (num == 0){
			answer = myString;
		} else {
			answer = myString.substring(0,num + pat.length() - 1);
		}
		System.out.println(answer);







	}
}


