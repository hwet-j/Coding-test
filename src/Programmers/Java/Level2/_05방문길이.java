package src.Programmers.Java.Level2;

import java.util.*;

public class _05방문길이 {

	public static void main(String[] args) {
		String dirs = "ULURRDLLU";

		List<Character> dirList = new ArrayList<>();

		// 문자열을 한 문자씩 순회하면서 리스트에 추가
		for (char c : dirs.toCharArray()) {
			dirList.add(c);
		}

		int[] positionA = {0,0};
		int[] positionB = {0,0};


		// U, L, R, D 에 따른 좌표의 이동을 저장하는 변수를 생성하여  A,B와 B,A가 동일한 정보를 제외하고
		// 유니크?한 값을 고려하면 이동한 경로의 개수를 파악하는데 사용할 수 있지 않을까함.
		// String으로 생각했다가 길이가 10이상으로넘어가면 구분이 어려울 수 있으므로 길이 4의 배열로 진행 또는 길이 2의 배열 2로
		// 좌표 2개를 표시하여 이동 구조를 파악하는게 가장 편리해보임.


	}
}

/*




* */