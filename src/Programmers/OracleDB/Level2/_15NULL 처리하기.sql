SELECT ANIMAL_TYPE, NVL(NAME, 'No name') NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID

/*
NVL 을 사용해서 null 값을 처리하는 문제이다.
대소문자를 구분해서 'No name'이다. 이것만 정확하면 쉬움
*/