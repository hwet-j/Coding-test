SELECT COUNT(USER_ID)
FROM USER_INFO
WHERE JOINED BETWEEN TO_DATE('2021-01-01', 'YYYY-MM-DD') AND TO_DATE('2022-01-01', 'YYYY-MM-DD') AND
AGE BETWEEN 20 AND 29;


/*
BETWEEN A AND B
A 포함 , B 포함임
*/
