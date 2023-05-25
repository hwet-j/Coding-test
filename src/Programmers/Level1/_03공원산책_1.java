package src.Programmers.Level1;

import java.util.Arrays;

public class _03공원산책_1 {

	public static void main(String[] args) {
		String[] park =  {"SOO","OOO","OOO"};
		String[] routes = {"E 2","S 2","W 1"};
		int height = park.length;
		int width = park[0].length();
		String[][] parkArr = new String[height][width];
		int[] startPoint = new int[2];

		for (int i=0; i<height;i++){
			for (int j=0; j<width;j++){
				parkArr[i][j] = park[i].substring(j, j+1);
				if (park[i].substring(j, j+1).equals("S")){
					startPoint[0] = i;
					startPoint[1] = j;
				}
			}
		}
		int block = 0;

		for (int i=0; i<routes.length; i++){
			String[] routeArr = routes[i].split(" ");
			String dir = routeArr[0];
			int move = Integer.parseInt(routeArr[1]);
			block = 0;
			if (dir.equals("E")){
				if (startPoint[1] + move >= width){
					block = 1;
				} else {
					for (int j=startPoint[1] + 1;j <= startPoint[1] + move;j++){
						if (parkArr[startPoint[0]][j].equals("X")){
							block = 1;
							break;
						}
					}
				}
				if (block == 0){
					startPoint[1] = startPoint[1] + move;
				}
			} else if (dir.equals("W")){
				if (startPoint[1] - move < 0){
					block = 1;
				} else {
					for (int j=startPoint[1] - 1;j >= startPoint[1] - move;j--){
						if (parkArr[startPoint[0]][j].equals("X")){
							block = 1;
							break;
						}
					}
				}
				if (block == 0){
					startPoint[1] = startPoint[1] - move;
				}
			} else if (dir.equals("N")){
				if (startPoint[0] - move < 0){
					block = 1;
				} else {
					for (int j=startPoint[0] - 1;j >= startPoint[0] - move;j--){
						if (parkArr[j][startPoint[1]].equals("X")){
							block = 1;
							break;
						}
					}
				}
				if (block == 0){
					startPoint[0] = startPoint[0] - move;
				}
			} else {
				if (startPoint[0] + move >= height){
					block = 1;
				} else {
					for (int j=startPoint[0] + 1;j <= startPoint[0] + move;j++){
						if (parkArr[j][startPoint[1]].equals("X")){
							block = 1;
							break;
						}
					}
				}
				if (block == 0){
					startPoint[0] = startPoint[0] + move;
				}
			}
		}


	}
}
