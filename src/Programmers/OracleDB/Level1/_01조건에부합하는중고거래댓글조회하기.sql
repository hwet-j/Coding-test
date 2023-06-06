SELECT b.TITLE, b.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, TO_CHAR(r.CREATED_DATE, 'YYYY-MM-DD')
FROM USED_GOODS_REPLY r,USED_GOODS_BOARD b
WHERE r.BOARD_ID = b.BOARD_ID AND TO_CHAR(b.CREATED_DATE, 'YYYY-MM') = '2022-10'
ORDER BY r.CREATED_DATE, b.TITLE

-- TO_CHAR(날짜형식데이터, '원하는형식') 으로 날짜 데이터를 원하는 형식의 문자 타입으로 변환 가능하다.
-- FROM절에 두 개의 테이블을 입력하여 별칭을 통하여 데이터를 사용한다.
-- DB는 문자열을 작성시에 작은따옴표를 사용하며, 큰따옴표는 주로 객체 식별자로 사용된다.
-- 큰따옴표로 감싸게 되면 대소문자 및 공백까지 동일해야 하며 공백이 존재하거나 예약어와 동일한 이름을 가진 테이블, 컬럼 등을 사용할 때 사용한다.
-- 하지만, 예약어와 동일한 테이블, 컬럼명은 충돌이 일어나지 않도록 피하는것이 올바르다.
-- 작은따옴표: 문자열을 감싼다, 큰따옴표 : 테이블,컬럼명 등을 감싼다.