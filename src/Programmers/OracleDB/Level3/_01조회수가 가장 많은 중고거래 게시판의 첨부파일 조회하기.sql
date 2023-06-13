SELECT '/home/grep/src/' || a.BOARD_ID || '/' || FILE_ID || FILE_NAME || FILE_EXT AS "FILE_PATH"
FROM USED_GOODS_BOARD a JOIN USED_GOODS_FILE b
ON a.BOARD_ID = b.BOARD_ID
WHERE VIEWS = (SELECT MAX(VIEWS) FROM USED_GOODS_BOARD)
ORDER BY FILE_PATH DESC

/*
SUB 쿼리를 작성하여 WHERE절에서 최대값만을 출력하도록 설정
|| 연산자를 사용해서 문자를 연결한다.
연결된 문자를 별칭을 정하고 ORDER BY에 사용
*/