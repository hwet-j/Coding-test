package src.Programmers.Level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/140108

public class _10문자열나누기 {
	public static void main(String[] args) {
		String s = "abracadabra";
		int answer = 0;
		int mainCnt = 0;
		String mainStr = "";
		int subCnt = 0;

		for (int i=0; i<s.length(); i++){
			if(mainCnt == 0){
				mainStr = s.substring(i,i+1);
				mainCnt++;
			} else if (mainStr.equals(s.substring(i,i+1))){
				mainCnt++;
			} else {
				subCnt++;
			}
			if (mainCnt == subCnt){
				mainCnt = 0;
				subCnt = 0;
				answer++;
			} else if (i == s.length()-1){
				answer++;
			}
		}




	}
}
