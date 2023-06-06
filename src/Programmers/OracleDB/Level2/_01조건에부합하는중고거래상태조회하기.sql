SELECT BOARD_ID, WRITER_ID, TITLE, PRICE,
CASE
WHEN STATUS = 'DONE' THEN '거래완료'
WHEN STATUS = 'RESERVED' THEN '예약중'
ELSE '판매중' END
FROM USED_GOODS_BOARD
WHERE TO_CHAR(CREATED_DATE, 'YYYY-MM-DD') = '2022-10-05'
ORDER BY BOARD_ID DESC

-- CASE WHEN THEN END
-- 설정해준 조건에 따라 컬럼값을 변경할 수 있는 명령어다.
-- CASE 작성후 WHEN 조건 THEN 결과 를 작성해주며 자바에서 IF ELSE절로 생각하면 편할거같다.
-- WHEN THEN의 조건절은 여러개 작성 가능하고, 마지막에 ELSE로 어떤 조건도 만족하지 않을떄 값을 설정해줄수있다.
-- 모든 조건을 작성했으면 CASE문이 끝났다는 것을 알려주는 END를 작성해줘야한다.