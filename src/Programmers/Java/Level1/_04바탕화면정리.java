package src.Programmers.Java.Level1;

import java.util.ArrayList;
import java.util.List;

public class _04바탕화면정리 {

	public static void main(String[] args) {
		String[] wallpaper = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
		int height = wallpaper.length;
		int width = wallpaper[0].length();
		List<String> list =new ArrayList<>();

		String[][] areaArr = new String[height][width];
		for (int i=0; i<height;i++){
			for (int j=0; j<width;j++){
				areaArr[i][j] = wallpaper[i].substring(j, j+1);
				if (areaArr[i][j].equals("#")){
					list.add(i+","+j);
				}
			}
		}
		int hmax = 0;
		int hmin = 50;
		int wmax = 0;
		int wmin = 50;

		for (int i=0;i<list.size();i++){
			String[] strArr = list.get(i).split(",");
			int hdata = Integer.parseInt(strArr[0]);
			int wdata = Integer.parseInt(strArr[1]);
			if (hdata < hmin){
				hmin = hdata;
			}
			if (hdata > hmax){
				hmax = hdata;
			}
			if (wdata < wmin){
				wmin = wdata;
			}
			if (wdata > wmax){
				wmax = wdata;
			}
		}
		int[] answer = {hmin, wmin, hmax+1, wmax+1};
	}
}

// 굳이 리스트를 만들필요는 없어보이지만 이미 완성과정까지 리스트를 사용해서 
// 없어려면 다시 만들어야되어서 그냥 패스