SELECT PT_NAME, PT_NO, GEND_CD, AGE, NVL(TLNO, 'NONE')
FROM PATIENT
WHERE AGE <= 12 AND GEND_CD = 'W'
ORDER BY AGE DESC, PT_NAME ASC

/*
NVL(컬럼, 대체값) - NULL 값인지 확인하여 NULL값인 경우 대체값으로 수정해준다.

NULL 값을 다루는 함수는 NVL, NVL2, COALESCE 가 있는데

가장 간단한 NVL을 사용하여 변경

NVL은 표현식이 NULL이면 두 번째 인자로 값을 수정한다.

*/
