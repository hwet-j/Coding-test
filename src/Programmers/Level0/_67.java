package src.Programmers.Level0;


/*
0번부터 n - 1번까지 n명의 학생 중 3명을 선발하는 전국 대회 선발 고사를 보았습니다.
등수가 높은 3명을 선발해야 하지만, 개인 사정으로 전국 대회에 참여하지 못하는
 학생들이 있어 참여가 가능한 학생 중 등수가 높은 3명을 선발하기로 했습니다.

각 학생들의 선발 고사 등수를 담은 정수 배열 rank와 전국 대회 참여
가능 여부가 담긴 boolean 배열 attendance가 매개변수로 주어집니다.
전국 대회에 선발된 학생 번호들을 등수가 높은 순서대로 각각 a, b, c번이라고
할 때 10000 × a + 100 × b + c를 return 하는 solution 함수를 작성해 주세요.
*/

import java.util.HashMap;
import java.util.Map;

public class _67 {
	public static void main(String[] args) {
		int[] rank = {3, 7, 2, 5, 4, 6, 1};
		boolean[] attendance = {false, true, true, true, true, false, false};
		Map<Integer, Boolean> map = new HashMap<>();

		for (int i=0; i< rank.length; i++){
			map.put(rank[i], attendance[i]);
		}

		System.out.println(map);
		int[] three = new int[3];
		int cnt = 0;
		for (int i=1; i<=rank.length; i++){
			if (map.get(i) == true){
				three[cnt++] = i;
				if (cnt == 3){
					break;
				}
			}
		}
		int answer = 0;
		cnt = 0;
		for(int i: three){
			for(int j=0;j<rank.length; j++){
				if (rank[j] == i){
					if (cnt == 0){
						answer += j * 10000;
						cnt++;
						break;
					} else if(cnt == 1){
						answer += j * 100;
						cnt++;
						break;
					} else if (cnt == 2){
						answer += j;
						break;
					}
				}
			}
		}


	}
}


