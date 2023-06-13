SELECT i.ANIMAL_ID , i.NAME
FROM ANIMAL_INS i, ANIMAL_OUTS o
WHERE i.ANIMAL_ID = o.ANIMAL_id
AND i.DATETIME > o.DATETIME
ORDER BY i.DATETIME


/*
두 테이블을 하나의 테이블로 합치는 과정을 진행 후
보호시작일(i.DATETIME) 이 입양일(o.DATETIME)보다 늦는 경우를 찾아내야한다.
날짜의 경우 시간이 흐를수록 더욱 큰 수기 때문에 "보호시작일 > 입양일"로 조건설정한다.

*/