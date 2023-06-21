package src.Programmers.Java.Level1;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _25다트게임 {
    public static void main(String[] args) {
        String dartResult = "10D4S10D";

        String dartResult2 = dartResult.replaceAll("[^0-9]", " ");
        // 맞춘 다트 기본점수를 저장
        String[] point = dartResult2.split("[ ]+");
        // 각 기회마다 보너스 및 옵션 (가장 처음 부분은 빈 문자열이 생기며 10의 경우도 빈배열이 생성됨)
        String[] addi = dartResult.split("[0-9]");
        // 가장 첫 index와 10의 경우 배열이 두 번 생기는 문제가 발생하여 빈배열 제외
        String[] additional = new String[3];
        int cnt = 0;
        for (String s : addi){
            if(!s.equals("")){
                additional[cnt++] = s;
            }
        }
        // 각 기회별 점수를 계산
        int[] get_point = new int[3];

        for(int i=0; i<3; i++){
            get_point[i] = Integer.parseInt(point[i]);
            for (int j=0;j<additional[i].length();j++){
                if (additional[i].charAt(j) == 'S'){
                    continue;
                } else if (additional[i].charAt(j) == 'D'){
                    get_point[i] = get_point[i] * get_point[i];
                } else if (additional[i].charAt(j) == 'T'){
                    get_point[i] = get_point[i] * get_point[i] * get_point[i];
                } else if (additional[i].charAt(j) == '*'){
                    get_point[i] =  get_point[i] * 2;
                    if (i != 0){    // 바로 이전값이 있으면 바로 이전값도 2배
                        get_point[i-1] =  get_point[i-1] * 2;
                    }
                } else if (additional[i].charAt(j) == '#'){
                    get_point[i] =  -get_point[i];
                }
            }
        }

        System.out.println(Arrays.toString(get_point));

        System.out.println(Arrays.stream(get_point).sum());
    }
}


/*

*/