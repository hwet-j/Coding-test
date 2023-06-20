SELECT MEMBER_ID, MEMBER_NAME, GENDER, TO_CHAR(DATE_OF_BIRTH, 'YYYY-MM-DD') DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE TLNO != 'null' AND TO_CHAR(DATE_OF_BIRTH, 'MM') = '03' AND GENDER = 'W'
ORDER BY MEMBER_ID


/*
크게 어렵지 않게 문제를 곱씹으며 WHERE절 작성하면 해결.
-> 데이터 형식이 다르면 오답
*/
