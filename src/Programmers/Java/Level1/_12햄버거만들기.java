package src.Programmers.Java.Level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _12햄버거만들기 {
    public static void main(String[] args){
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};

        List<Integer> list = new ArrayList<>();
        for (int i=0;i<ingredient.length;i++){
            list.add(ingredient[i]);
        }

        int cnt = 0;
        int answer = 0;

        while(true){
            // List의 크기가 4개 이하면 햄버거를 더이상 만들 수 없음, 현재위치에서부터 마지막 재료까지 3개남으면 더이상 만들 수 없음
            if (list.size() < 4 || cnt == list.size() - 3){
                break;
            }

            // 현재 위치에서 부터 4개의 재료를 뽑아내었을때, 빵-야채-고기-빵 (1231) 이면 해당 4개의 재료를 삭제하고 이전 재료부터 다시 파악
            // List는 삭제하는 즉시 길이가 달라지기 때문에 cnt, cnt+1, cnt+2, cnt+3로 지우지 않고, cnt를 4번지워준다.
            if(("" + list.get(cnt) + list.get(cnt+1) + list.get(cnt+2) + list.get(cnt+3)).equals("1231")){
                list.remove(cnt);
                list.remove(cnt);
                list.remove(cnt);
                list.remove(cnt);
                // 재료위치가 4번째 이상이면 제거된 재료만큼 뒤로가서 다시 파악하고 4개 이하면 가장 처음부터 확인한다.
                if (cnt > 4){
                    cnt = cnt - 4;
                } else {
                    cnt = 0;
                }
                // 햄버거를 만들면 + 1
                answer ++;
            } else {
                // 햄버거를 못만들면 재료위치 이동
                cnt++;
            }

        }
        System.out.println(answer);
    }
}
