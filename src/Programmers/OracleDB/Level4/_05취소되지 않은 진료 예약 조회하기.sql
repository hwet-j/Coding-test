SELECT a.APNT_NO, c.PT_NAME, a.PT_NO, b.MCDP_CD, b.DR_NAME, a.APNT_YMD
FROM APPOINTMENT a
JOIN DOCTOR b ON a.MDDR_ID = b.DR_ID
JOIN PATIENT c ON a.PT_NO = c.PT_NO
WHERE TO_CHAR(a.APNT_YMD, 'YYYY-MM-DD') = '2022-04-13'
AND APNT_CNCL_YN = 'N'
ORDER BY a.APNT_YMD

/*
PATIENT 테이블
DOCTOR 테이블
APPOINTMENT 테이블
APPOINTMENT에 환자, 의사 정보가있음
APPOINTMENT의 데이터로 두개의 테이블을 JOIN이 가능하여 총 3개의 테이블을 모두 연결 가능
연결된 데이터중에서 '2022-04-13'에 진료예정인 데이터를 가져오고
예약 취소여부를 파악(APNT_CNCL_YN)하여 취소하지 않은 데이터만 사용
*/