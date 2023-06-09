SELECT ANIMAL_ID, NAME, TO_CHAR(DATETIME, 'YYYY-MM-DD') 날짜
FROM ANIMAL_INS
ORDER BY ANIMAL_ID


/*
TO_CHAR

TRUNC 를 알게되어서 해당 명령어를 사용해보려했으나, 시간부터 전부 잘라내어 버리도록 했지만
YYYY-MM-DD 00:00:00 처럼 형식자체가 잘리지 않고 0값으로 대체되어 나온다.
*/
