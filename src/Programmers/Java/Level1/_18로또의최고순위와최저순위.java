package src.Programmers.Java.Level1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18로또의최고순위와최저순위 {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        List<Integer> list = new ArrayList<>();

        for (int i=0; i < 6; i++){
            list.add(win_nums[i]);
        }

        int[] answer = new int[2];
        // 맟출수 있는 최저, 최고 개수
        for (int i=0; i < 6; i++){
            if (lottos[i] == 0){
                answer[0]++;
            } else {
                if (list.contains(lottos[i])){
                    answer[0]++;
                    answer[1]++;
                }
            }
        }

        // 맞춘개수를 순위로 변경
        for (int i=0; i<2;i++){
            if (answer[i] == 6){
                answer[i] = 1;
            } else if (answer[i] == 5){
                answer[i] = 2;
            } else if (answer[i] == 4){
                answer[i] = 3;
            } else if (answer[i] == 3){
                answer[i] = 4;
            } else if (answer[i] == 2){
                answer[i] = 5;
            } else {
                answer[i] = 6;
            }
        }
        System.out.println(Arrays.toString(answer));

    }
}


/*
뽑은 번호(lottos)가 로또 번호(win_nums)에 포함하는지 쉽게 확인하기 위해 LIST 타입으로 변경
두 데이터를 비교하여 공통의 숫자를 가진 개수를 COUNT하고, 앞에 숫자에 0의 개수까지 더해준 값을
배열에 입력해준다. 0번 인덱스에는 두수의합, 1번 인덱스는 공통의 숫자를 가진개수를 넣어준다.
-> 0은 사실상 맞춘 숫자나 마찬가지다.

이후에 맞춘 개수를 순위로 바꿔준다.
*/
