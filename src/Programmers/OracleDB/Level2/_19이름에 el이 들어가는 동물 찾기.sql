SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE UPPER(NAME) LIKE '%EL%'
AND UPPER(ANIMAL_TYPE) = 'DOG'
ORDER BY NAME

/*
이름에 대소문자 상관없이 el이라는 문구가 들어가있으면 출력해야 하므로 대문자로 변경하여 확인한다.
*/