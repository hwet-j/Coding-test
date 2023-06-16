package src.Programmers.Java.Level1;


import java.util.ArrayList;
import java.util.List;

public class _21크레인인형뽑기게임 {
    public static void main(String[] args) {
        int[][] board = { {0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1} };

        int[] moves = {1,5,3,5,1,2,1,4};

        List<Integer> list = new ArrayList<>();

        int l_size = 0;

        int answer = 0;

        // 어디서 인형을 뽑을 건지
        for(int i=0; i<moves.length; i++){
            // 해당 위치에서 가장 위에있는 인형을 뽑는다.
            for (int j=0; j<board.length; j++){
                // 0 보다 큰수여야지 인형이 있음
                if (board[j][moves[i]-1] > 0){
                    // 인형이 있으면 뽑아서 옮겨넣는다.
                    list.add(board[j][moves[i]-1]);
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }

            l_size = list.size();

            // 인형을 뽑았는데 이전 인형과 동일하면 제거
            while(l_size >= 2) {
                if (list.get(l_size - 1) == list.get(l_size - 2)) {
                    list.remove(l_size - 2);
                    list.remove(l_size - 2);
                    answer++;
                } else {
                    break;
                }
                l_size = list.size();
            }

        }
        // 인형은 짝으로 사라지니 무조건 짝수 (사라질 때마다 2개씩)
        System.out.println(answer * 2);

    }
}

