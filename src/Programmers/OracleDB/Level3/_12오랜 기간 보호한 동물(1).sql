SELECT NAME, DATETIME
FROM (SELECT i.NAME NAME, i.DATETIME DATETIME
FROM ANIMAL_INS i LEFT OUTER JOIN ANIMAL_OUTS o
ON i.ANIMAL_ID = o.ANIMAL_ID
WHERE o.NAME IS NULL
AND i.NAME IS NOT NULL
ORDER BY i.DATETIME)
WHERE ROWNUM <= 3


/*
차집합 활용
A LEFT OUTER JOIN B 을 하고 기준점을 A에 작성
ON 에 동일한 KEY값을 설정
WHERE 절에 A-B 해주고싶은 B컬럼의 정보가 NULL값인 정보만 사용한다.

추가로 NAME 이 NULL 값이 존재하기도 하므로 NULL 값 제외
보호기간으로 정렬하여 상위 3개의 레코드만 출력할것이므로 보호기간으로 정렬하고 만들어진 테이블을 서브쿼리로 설정
ROWNUM을 사용해서 3개의 레코드만 출력해준다.

*/