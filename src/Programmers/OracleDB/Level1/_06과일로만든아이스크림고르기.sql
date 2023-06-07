SELECT f.FLAVOR
FROM FIRST_HALF f, ICECREAM_INFO i
WHERE f.FLAVOR = i.FLAVOR
AND f.TOTAL_ORDER > 3000
AND i.INGREDIENT_TYPE = 'fruit_based'
ORDER BY f.TOTAL_ORDER desc

/*
FROM 절에 2개의 테이블을 사용했다. JOIN 을 사용하면 편할 거같지만 아직 배우지 않은 상태로
WHERE 절에 조건을 넣어 원하는 데이터를 출력.
*/
