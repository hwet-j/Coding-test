package src.Programmers.Level1;

import java.util.ArrayList;
import java.util.List;

public class _05덧칠하기 {

	public static void main(String[] args) {
		int n = 8;
		int m = 3;
		int[] section = {2,3, 6};
		int temp = 0 ;
		int cnt = 0;
		for (int i=0;i<section.length;i++){
			if (i == 0){
				temp = section[i] + m - 1;
				cnt++;
			} else {
				if (section[i] > temp){
					cnt++;
					temp = section[i] + m - 1;
				}
			}
		}
		System.out.println(cnt);


	}
}

