SELECT BOOK_ID, TO_CHAR(PUBLISHED_DATE, 'YYYY-MM-DD')
FROM BOOK
WHERE CATEGORY = '인문'
AND TO_CHAR(PUBLISHED_DATE, 'YYYY') = '2021'
ORDER BY PUBLISHED_DATE

/*
TO_CHAR 활용
TO_CHAR(표현식, '형식') 년도의 값만 필요하므로 년도 데이터를 의미하는 YYYY를 형식에 작성하여 사용
*/
