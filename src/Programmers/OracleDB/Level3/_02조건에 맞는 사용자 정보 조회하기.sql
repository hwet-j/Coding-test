SELECT USER_ID, NICKNAME, CITY || ' ' || STREET_ADDRESS1 || ' ' || STREET_ADDRESS2 전체주소, REGEXP_REPLACE(TLNO, '(.{3})(.+)(.{4})', '\1-\2-\3') 전화번호
FROM
(SELECT WRITER_ID
FROM USED_GOODS_BOARD
GROUP BY WRITER_ID
HAVING COUNT(WRITER_ID) >= 3) a
, USED_GOODS_USER b
WHERE b.USER_ID = a.WRITER_ID
ORDER BY b.USER_ID DESC

-- SELECT USER_ID, NICKNAME, CITY || ' ' || STREET_ADDRESS1 || ' ' || STREET_ADDRESS2 전체주소, SUBSTR(TLNO, 1, 3) || '-' || SUBSTR(TLNO, 4, 4) || '-' || SUBSTR(TLNO, 8) 전화번호
-- FROM
-- (SELECT WRITER_ID
-- FROM USED_GOODS_BOARD
-- GROUP BY WRITER_ID
-- HAVING COUNT(WRITER_ID) >= 3) a
-- , USED_GOODS_USER b
-- WHERE b.USER_ID = a.WRITER_ID
-- ORDER BY b.USER_ID DESC


/*
글의 개수가 3개인 사용자를 찾아내는 쿼리문을 작성하여 서브쿼리로 작성하고
USED_GOODS_USER와 JOIN하여 값을 출력한다.

이 문제는 전화번호 형식을 만드는데 어려움이 있다. SUBSTR를 사용하면 가능하지만
010-1234-5678, 011-234-5678 처럼 전화번호는 가운데의 길이가 다를 수도있다.
이 문제에서는 길이가 동일하여 SUBSTR를 사용하는데 문제없지만, 이런 상황이 있을수 있기
때문에 관련 함수를 찾아보고 가도록한다.

REGEXP_REPLACE(tel_no, '(.{3})(.+)(.{4})', '\1-\2-\3')

REGEXP_REPLACE(tel_no, '(문자열앞3자리)(나머지문자열)(문자열뒤4자리)', '\1-\2-\3')

마지막 매개변수는 잘라준 문자열의 배치를 나타냄 (형식)
*/