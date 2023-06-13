SELECT o.ANIMAL_ID, o.NAME
FROM  ANIMAL_OUTS o LEFT OUTER JOIN ANIMAL_INS i
ON i.ANIMAL_ID = o.ANIMAL_ID
WHERE i.NAME IS NULL
AND o.NAME IS NOT NULL
ORDER BY o.ANIMAL_ID


/* 차집합
LEFT OUTER JOIN을 사용해서 좌측데이터를 기준으로 우측의 데이터와 공통되는 데이터를 제외
(WHERE i.NAME IS NULL 이 공통되는 데이터 제외)
동물이름에 Null값을 제외하고 ID로 정렬

*/