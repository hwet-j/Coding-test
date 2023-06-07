SELECT NAME
FROM (SELECT NAME
        FROM ANIMAL_INS
        ORDER BY DATETIME)
WHERE ROWNUM = 1


/*
ROWNUM 을 사용한다. 정해진 출력 순서에서 가장 위(1번)의 데이터를 출력한다.
*/
