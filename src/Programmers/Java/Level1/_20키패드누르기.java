package src.Programmers.Java.Level1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _20키패드누르기 {
    public static void main(String[] args) {
        int[] numbers =  {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand = "right";

        List<Integer> leftside = new ArrayList<>();
        List<Integer> rightside = new ArrayList<>();
        
        // 무조건 왼손
        leftside.add(1);
        leftside.add(4);
        leftside.add(7);
        // 무조건 오른손
        rightside.add(3);
        rightside.add(6);
        rightside.add(9);

        // 시작점은 가장 아래를 3으로 지정 -> 0부터 3까지 위에서 아래로
        // 열,행 이있으므로 배열로 생성
        int[] left_ps = {0,3};
        int[] right_ps = {2,3};

        // 버튼을 누를때마다 손위치 저장
        String answer = "";

        for (int i:numbers){
            if(leftside.contains(i)){   // 무조건 왼손
                answer += "L";
                left_ps[0] = 0;
                if(i == 1){
                    left_ps[1] = 0;
                } else if (i == 4){
                    left_ps[1] = 1;
                } else if (i == 7){
                    left_ps[1] = 2;
                }
            } else if (rightside.contains(i)){  // 무조건 오른손
                answer += "R";
                right_ps[0] = 2;
                if(i == 3){
                    right_ps[1] = 0;
                } else if (i == 6){
                    right_ps[1] = 1;
                } else if (i == 9){
                    right_ps[1] = 2;
                }
            } else {  
                if (i == 2){
                    // 왼손과 오른손에서 버튼까지의 길이를 저장하여 비교
                    int left_dis = Math.abs(1 - left_ps[0]) + Math.abs(left_ps[1]);
                    int right_dis = Math.abs(1 - right_ps[0]) + Math.abs(right_ps[1]);
                    if(left_dis > right_dis) {
                        answer += "R";
                        right_ps[0] = 1;
                        right_ps[1] = 0;
                    } else if(left_dis < right_dis) {
                        answer += "L";
                        left_ps[0] = 1;
                        left_ps[1] = 0;
                    } else {
                        if (hand.equals("right")){
                            answer += "R";
                            right_ps[0] = 1;
                            right_ps[1] = 0;
                        } else {
                            answer += "L";
                            left_ps[0] = 1;
                            left_ps[1] = 0;
                        }
                    }
                } else if (i == 5){
                    int left_dis = Math.abs(1 - left_ps[0]) + Math.abs(1 - left_ps[1]);
                    int right_dis = Math.abs(1 - right_ps[0]) + Math.abs(1 - right_ps[1]);
                    if(left_dis > right_dis) {
                        answer += "R";
                        right_ps[0] = 1;
                        right_ps[1] = 1;
                    } else if (left_dis < right_dis){
                        answer += "L";
                        left_ps[0] = 1;
                        left_ps[1] = 1;
                    } else {
                        if (hand.equals("right")){
                            answer += "R";
                            right_ps[0] = 1;
                            right_ps[1] = 1;
                        } else {
                            answer += "L";
                            left_ps[0] = 1;
                            left_ps[1] = 1;
                        }
                    }
                } else if (i == 8){
                    int left_dis = Math.abs(1 - left_ps[0]) + Math.abs(2 - left_ps[1]);
                    int right_dis = Math.abs(1 - right_ps[0]) + Math.abs(2 - right_ps[1]);
                    if(left_dis > right_dis) {
                        answer += "R";
                        right_ps[0] = 1;
                        right_ps[1] = 2;
                    } else if(left_dis < right_dis) {
                        answer += "L";
                        left_ps[0] = 1;
                        left_ps[1] = 2;
                    } else {
                        if (hand.equals("right")){
                            answer += "R";
                            right_ps[0] = 1;
                            right_ps[1] = 2;
                        } else {
                            answer += "L";
                            left_ps[0] = 1;
                            left_ps[1] = 2;
                        }
                    }
                } else {
                    int left_dis = Math.abs(1 - left_ps[0]) + Math.abs(3 - left_ps[1]);
                    int right_dis = Math.abs(1 - right_ps[0]) + Math.abs(3 - right_ps[1]);
                    if(left_dis > right_dis) {
                        answer += "R";
                        right_ps[0] = 1;
                        right_ps[1] = 3;
                    } else if(left_dis < right_dis) {
                        answer += "L";
                        left_ps[0] = 1;
                        left_ps[1] = 3;
                    } else {
                        if (hand.equals("right")){
                            answer += "R";
                            right_ps[0] = 1;
                            right_ps[1] = 3;
                        } else {
                            answer += "L";
                            left_ps[0] = 1;
                            left_ps[1] = 3;
                        }
                    }
                }

            }
        }

        System.out.println(answer);
    }
}

