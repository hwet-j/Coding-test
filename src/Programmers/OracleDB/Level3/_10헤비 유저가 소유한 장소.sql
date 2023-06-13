SELECT *
FROM PLACES
WHERE HOST_ID IN
(SELECT HOST_ID
FROM PLACES
GROUP BY HOST_ID
HAVING COUNT(*) >= 2)
ORDER BY ID



/*
헤비 유저 (공간을 2개이상 등록한 유저)를 먼저 찾아준다. -> 서브쿼리

--  -05.대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기  문제를 풀기전에 풀면 좋은 문제같음
*/