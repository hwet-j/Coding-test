SELECT ANIMAL_ID , ANIMAL_TYPE, NAME
FROM ANIMAL_INS
WHERE ANIMAL_ID IN
(
SELECT ANIMAL_ID
FROM ANIMAL_OUTS
WHERE SEX_UPON_OUTCOME NOT LIKE '%Intact%'
) AND SEX_UPON_INTAKE LIKE '%Intact%'


/*
INS 에는 중성화가 아니고, OUTS에는 중성화 상태의 동물의 정보를 찾아야함.
서브쿼리로 OUTS에 중성화된 동물의 ANIMAL_ID 만 가져와 WHERE절에 사용하고,
INS 테이블에서는 중성화되지 않은 동물의 ANIMAL_ID만 가져오도록 한다.

*/