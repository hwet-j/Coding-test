package src.Programmers.Java.Level2;


import java.util.Arrays;
import java.util.Comparator;

public class _02피로도 {
	public static int findMaxIndex(int[] array) {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException("배열이 비어 있습니다.");
		}

		int maxIndex = 0;
		int maxValue = array[0];

		for (int i = 1; i < array.length; i++) {
			if (array[i] > maxValue) {
				maxValue = array[i];
				maxIndex = i;
			}
		}

		return maxIndex;
	}
	public static void main(String[] args) {
		int k = 8;
		int[][] dungeons = {{7, 3}, {5, 4}, {1, 1}};

		int count;
		int block;
		int position;
		int dunLeng = dungeons.length;

		int answer = 0;

		Arrays.sort(dungeons, Comparator.comparingInt((int[] dungeon) -> dungeon[0])
				.reversed().thenComparingInt(dungeon -> dungeon[1]));

		System.out.println("정렬 후 배열 정보");
		for (int i = 0; i < dunLeng; i++) {
			System.out.println(Arrays.toString(dungeons[i]));
		}
		System.out.println("============================");

		int[] ableStages = new int[dunLeng];
		int[] leftCountStages = new int[dunLeng];
		int lastStage = -1;


		while (true) {
			block = 0;
			// 스테이지 마다 도전했을 경우 이후에 도전가능한 스테이지 개수 체크
			for (int i = 0; i < dunLeng; i++) {
				count = 0;

				// 스테이지가 도전하지 않은 스테이지면 0
				if (ableStages[i] == 0) {
					// 남아있는 피로도가 소모 피로도 보다 낮다면 스킵
					if (k < dungeons[i][0]){
						leftCountStages[i] = count;
						continue;
					}
					// 남아있는 피로도가 소모 피로도보다 높으면 해당 스테이지를 도전했다 가정하고 이후 가능 스테이지 체크
					// 도전한 이후의 피로도
					int temp = k - dungeons[i][1];

					for (int j = 0; j < dunLeng; j++) {
						if (temp >= dungeons[j][0] && ableStages[j] == 0 && i != j) {
							count += 1;

						}
					}
					leftCountStages[i] = count;
				} else {
					leftCountStages[i] = count;
				}
			}


			System.out.println("도전 가능 스테이지개수" + Arrays.toString(leftCountStages));
			System.out.println("도전 가능 스테이지" + Arrays.toString(ableStages));

			for (int i = 0; i < leftCountStages.length; i++) {
				block += leftCountStages[i];
			}

			if(block == 0){
				while(true) {
					lastStage = -1;
					for (int i = 0; i < dunLeng; i++) {
						if (ableStages[i] == 0) {
							if (k < dungeons[i][0]) {
								continue;
							} else {
								if (k >= dungeons[i][1]) {
									lastStage = i;
									break;
								}
							}
						}
					}
					if (lastStage != -1) {
						position = lastStage;
						System.out.println("도전 스테이지" + position);
						ableStages[position] = 1;
						System.out.println("소모전 피로도 :" + k);
						k -= dungeons[position][1];
						System.out.println("소모후 피로도 :" + k);
						answer++;
					} else {
						break;
					}
				}
				break;
			}

			position = findMaxIndex(leftCountStages);
			System.out.println("도전 스테이지" + position);
			ableStages[position] = 1;
			System.out.println("소모전 피로도 :" + k);
			k -= dungeons[position][1];
			System.out.println("소모후 피로도 :" + k);
			answer++;


		}
		System.out.println(answer);



	}
}


/*
Comparator.comparingInt((int[] dungeon) -> dungeon[0]).thenComparingInt(dungeon -> dungeon[1])

Comparator.comparingInt(...): 이 부분은 Comparator를 생성하는 정적 메서드 comparingInt()를 호출합니다. comparingInt()는 요소를 정수로 변환하여 비교하는데 사용됩니다.

(int[] dungeon) -> dungeon[0]: 이 부분은 람다 표현식입니다. dungeon이라는 int 배열을 입력으로 받고, dungeon[0]을 반환합니다. 즉, 이는 dungeons 배열의 각 요소에 대해 첫 번째 요소인 "최소 필요 피로도"를 기준으로 비교한다는 의미입니다.

.thenComparingInt(dungeon -> dungeon[1]): 이 부분은 첫 번째 comparingInt() 기준으로 이미 정렬된 상태에서 두 번째 기준으로 정렬을 수행합니다. 여기서 dungeon[1]은 각 요소의 두 번째 요소인 "소모 피로도"를 나타냅니다.

따라서, Arrays.sort() 함수는 먼저 "최소 필요 피로도"를 기준으로 오름차순으로 정렬한 후, 동일한 "최소 필요 피로도"를 가진 요소들에 대해서는 "소모 필로도"를 기준으로 오름차순으로 정렬합니다.

이러한 정렬 방식을 통해 dungeons 배열은 "최소 필요 피로도"를 기준으로 오름차순으로 정렬되고, 동일한 "최소 필요 피로도"를 가진 요소들에 대해서는 "소모 피로도"를 기준으로 오름차순으로 정렬된 상태가 됩니다.


 Arrays.sort(dungeons, Comparator.comparingInt((int[] dungeon) -> dungeon[0])
                .reversed().thenComparingInt(dungeon -> dungeon[1]));

--> 첫번째 요소에 대해서 오름차순, 두번째 요소에 대해서 내림차순

-------------------------
도전 이후 도전가능한 스테이지의 개수를 파악하는 과정에서 자기자신을 제외하는것을 작성하지 않아서
뭐가 어떻게 문제인지 알아내는데 오래 걸렸다

 */