package src.Programmers.Level0;


/*
문자열 배열 strArr이 주어집니다.
strArr의 원소들을 길이가 같은 문자열들끼리
그룹으로 묶었을 때 가장 개수가 많은 그룹의 크기를
return 하는 solution 함수를 완성해 주세요.
*/

public class _63 {
	public static void main(String[] args) {
		String[] strArr = {"a","bc","d","efg","hi"};
		int answer = 0;
		int mleng = 0;
		for (int i=0;i<strArr.length;i++){
			if (mleng < strArr[i].length()){
				mleng = strArr[i].length();
			}
		}
		int cnt = 0;
		for (int i=1; i<mleng+1;i++){
			for (int j=0; j<strArr.length; j++){
				if (strArr[j].length() == i){
					cnt += 1;
				}
			}
			if(answer < cnt){
				answer = cnt;
			}
			cnt = 0;
		}


	}
}


