package src.Programmers.Level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _03공원산책 {

	public static void main(String[] args) {
		String[] park =  {"SOO","OOO","OOO"};
		String[] routes = {"E 2","S 2","W 1"};
		String[][] partArr = new String[park.length][park[0].length()];
		int[] startPoint = new int[2];

		for (int i=0; i< park.length;i++){
			for (int j=0; j<park[0].length();j++){
				partArr[i][j] = park[i].substring(j, j+1);
				if (park[i].substring(j, j+1).equals("S")){
					startPoint[0] = i;
					startPoint[1] = j;
				}
			}
		}
		System.out.println(Arrays.toString(partArr[0]));
		System.out.println(Arrays.toString(partArr[1]));
		System.out.println(Arrays.toString(partArr[2]));
		System.out.println(Arrays.toString(startPoint));

		for (int i=0; i<routes.length; i++){
			String[] ro = routes[i].split(" ");
			int move = Integer.parseInt(ro[1]);
			System.out.println(ro[0]);
			System.out.println(ro[1]);
			switch (ro[0]) {
				case "E":
					for (int j=0;j<move;j++){
						if (startPoint[1] + j > partArr[i].length || ) {

						}
					}

			}
		}


	/*	int block = 0;

		for (int i=0; i<routes.length; i++){
			String[] ro = routes[i].split(" ");
			if (ro.equals("E")) {
				for (int j=0; j<Integer.parseInt(ro[1]);j++){
					if (startPoint[1]-j < 0 | partArr[startPoint[0]][startPoint[1]-j].equals("X")){
						block = 1;
						break;
					}
				}
				if (block == 1) continue;
				else {
					startPoint[1] = startPoint[1] - Integer.parseInt(ro[1]);
				}
			} else if (ro.equals("W")) {
				for (int j=0; j<Integer.parseInt(ro[1]);j++){
					if (startPoint[1]+j < park[0].length()-1 | partArr[startPoint[0]][startPoint[1]+j].equals("X")){
						block = 1;
						break;
					}
				}
				if (block == 1) continue;
				else {
					startPoint[1] = startPoint[1] + Integer.parseInt(ro[1]);
				}
			} else if (ro.equals("S")) {
				for (int j=0; j<Integer.parseInt(ro[1]);j++){
					if (startPoint[0]-j < 0 | partArr[startPoint[0]-j][startPoint[1]].equals("X")){
						block = 1;
						break;
					}
				}
				if (block == 1) continue;
				else {
					startPoint[0] = startPoint[0] - Integer.parseInt(ro[1]);
				}
			} else {
				for (int j=0; j< Integer.parseInt(ro[1]);j++){
					System.out.println( partArr[startPoint[0]+j][startPoint[1]]);
					if (startPoint[0]+j > park.length-1 | partArr[startPoint[0]+j][startPoint[1]].equals("X")){
						block = 1;
						break;
					}
				}
				if (block == 1) continue;
				else {
					startPoint[0] = startPoint[0] + Integer.parseInt(ro[1]);
				}
			}
			System.out.println(Arrays.toString(startPoint));
		}
*/



	}
}
