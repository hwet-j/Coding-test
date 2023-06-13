SELECT ANIMAL_ID, NAME
FROM (SELECT i.ANIMAL_ID ANIMAL_ID, i.NAME NAME
FROM ANIMAL_INS i JOIN ANIMAL_OUTS o
ON i.ANIMAL_ID = o.ANIMAL_ID
ORDER BY (o.DATETIME - i.DATETIME) DESC)
WHERE ROWNUM <= 2

/*
INS와 OUTS에 같이 존재하면 입양보낸 동물임 (ANIMAL_ID를 JOIN key로 설정하면 알아서 입양간 동물의 정보만 나옴)
보호기간으로 정렬해야 하므로 입양간날 - 보호시작일 로 정렬해준다.
기간이 가장 길었던 동물 2마리만 출력해야 하므로 정렬은 내림차순으로 해주며, 해당 SELECT문은 서브쿼리로 사용한다.
ROWNUM을 사용해 2개만 출력
*/