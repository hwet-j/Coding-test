SELECT b.FOOD_TYPE, b.REST_ID, b.REST_NAME, b.FAVORITES
FROM (SELECT FOOD_TYPE, MAX(FAVORITES) MAX_F
FROM REST_INFO
GROUP BY FOOD_TYPE) a JOIN REST_INFO b
ON a.MAX_F = b.FAVORITES AND a.FOOD_TYPE = b.FOOD_TYPE
ORDER BY b.FOOD_TYPE DESC




/*
음식종류별로 즐겨찾기수가 가장 많은 식당을 구하는 쿼리문을 작성 (서브쿼리)

서브쿼리와 REST_INFO 를 JOIN해줘서 구해준 MAX_FAVORITES값과 타입이 동일한 데이터만 추출하여 해당 데이터의 ID, NAME도 함꼐 출력 해준다.
*/