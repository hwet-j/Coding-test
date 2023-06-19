-- ROLLUP은 총 job의 총 개수도 나타낸다. - 가장 마지막 ROW에
SELECT job, COUNT(empno)
FROM emp
GROUP BY ROLLUP(job);

-- ROLLUP은 총 job의 총 개수도 나타낸다. - 가장 첫 ROW에 
SELECT job, COUNT(empno)
FROM emp
GROUP BY CUBE(job);

-- 부서별 같은 업무를 하는 사원정보 조회
SELECT deptno, job, count(*)
FROM emp
GROUP BY deptno, job;

-- ROLLUP 사용, 기준별로 집계 및 전체 집계 -> 기준은 처음 입력된 데이터 부터
SELECT deptno, job, count(*)
FROM emp
GROUP BY ROLLUP(job, deptno);

SELECT deptno, job, count(*)
FROM emp
GROUP BY ROLLUP(job), deptno;


-- ROLLUP의 기준점만 다르게
SELECT deptno, job, count(*)
FROM emp
GROUP BY ROLLUP(deptno, job);

SELECT deptno, job, count(*)
FROM emp
GROUP BY ROLLUP(deptno), job;

SELECT deptno, job, count(*)
FROM emp
GROUP BY ROLLUP(deptno), ROLLUP(job);


SELECT deptno, job, count(*)
FROM emp
GROUP BY CUBE(deptno), ROLLUP(job);

SELECT deptno, job, count(*)
FROM emp
GROUP BY CUBE(deptno,job);

-- 합집합 (UNION)
SELECT deptno
FROM dept
UNION
SELECT deptno
FROM emp;

-- 차집합 (MINUS) A-B와 B-A는 매우 다름
SELECT deptno
FROM dept
MINUS
SELECT deptno
FROM emp;

SELECT deptno
FROM emp
MINUS
SELECT deptno
FROM dept;


-- 교집합 (INTERSECT)
SELECT deptno
FROM dept
INTERSECT 
SELECT deptno
FROM emp;

-- 중복을 포함하는 합집합 (UNION ALL) -> 두개의 정보를 전부 출력함
SELECT deptno
FROM dept
UNION ALL
SELECT deptno
FROM emp;



--------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
https://gent.tistory.com/479
COALESCE 함수도 있음

-- null 다루기
-- NVL(데이터, 대체값) -> 데이터의 값이 null이라면 대체값으로 대체한다.
-- comm의값이 null이면 20으로 대체
SELECT COMM, NVL(COMM, 20) 
FROM EMP;

-- NVL2(데이터, notnull대체값, null대체값) -> null값은 null대체값으로, null이아닌값은 notnull대체값으로 대체된다.
SELECT COMM, NVL2(COMM, 10, 20) 
FROM EMP;

-- NULLIF(표현식1, 표현식2) : 표현식1과 표현식2의 값이 동일하면 null 반환, 동일하지 않으면 표현식1 반환
SELECT NULLIF(sal, 1250) 
FROM emp;

-- COALESCE(표현식1, 표현식2,.... 표현식N) : 차례대로 진행하며(1~N)
-- null이아닌 값을 찾으면 해당 표현식을 반환하고 다음 ROW를 반복진행
-- 표현식1에 null값이 없다면 반환값은 표현식1과 동일할 것이다.


-- 기타함수 
-- GREATEST/LEAST(표현식1, 표현식2,....표현식N) : 표현식 중에서 가장 큰/작은 값을 반환한다.
SELECT GREATEST(1,3,4,6,19,9), LEAST(199,4,19,90,440) 
FROM dual;

-- 문자의 순서도 비교 가능하다.
SELECT GREATEST('김','이','나','박'), LEAST('김','이','나','박') 
FROM dual;


-- DECODE(표현식, 조건1, 결과1, 조건2, 결과2, ....조건N, 결과N) - 조건식이 아닌 조건이 온다.
SELECT deptno, DECODE(deptno, 10, 'ACC', 20, 'MAN')
FROM EMP;
-- > 조건에 맞는 데이터가 없는 경우에는 null값이 된다.

-- 작성해준 모든 조건에 맞지 않을 떄 데이터를 넣어줄 수 있다.
SELECT deptno, DECODE(deptno, 10, 'ACC', 20, 'MAN', '무직')
FROM EMP;
-- > 마지막에 조건을 작성하지 않고 결과값만 입력


-- CASE : DECODE와 개념은 비슷하지만 사용 문법이 조금 다르고 조건 대신 조건식이 들어갈 수 있다.
SELECT 
CASE 
    WHEN deptno = 10 THEN 'ACCCOUNTING'
    WHEN deptno = 20 THEN 'ACCCOUNTING2'
    ELSE '기타' 
END 
FROM emp;

-- 표현식을 앞으로 빼낼 수 있지만, 조건식 사용이 불가능하다. (DECODE랑 다를바없다)
SELECT 
CASE deptno
    WHEN 10 THEN 'ACCCOUNTING'
    WHEN 20 THEN 'ACCCOUNTING2'
    ELSE '기타' 
END 
FROM emp;

-------------------------------------------------------------------------------
-- JOIN : 두 개 이상의 테이블을 연결 또는 결합하여 데이터를 출력하는 것
-- 일반적으로 행들은 PK FK 나 값의 연관에 의해 JOIN이 성립된다
-- 어떤 . PK, FK 경우에는 관계가 없어도 논리적인 값들의 연관만으로 JOIN.


-- EQUI JOIN 
-- 2개의 테이블 간에 칼럼 값들이 서로 정확하게 일치하는 경우에 사용 대부분 , PK, FK의 관계를 기반으로 한다.

-- NON-EQUI JOIN
-- 2개의 테이블 간에 칼럼 값들이 서로 정확하게 일치하지 않는 경우에 사용
-- ‘=’ BETWEEN, >, <= 연산자가 아닌 등 연산자 사용

-- 카르테시안곱 

--  emp테이블에서 부서번호로 정렬
SELECT empno, ename, deptno
FROM emp
ORDER BY deptno;
-- dept테이블에서 부서번호로 정렬
SELECT deptno, dname
FROM dept
ORDER BY deptno;

-- 두개의 테이블을 모두 사용하려 이런식으로 작성하면 CROSS JOIN된다.
SELECT empno, ename, dname
FROM emp, dept;
-- > 모든 부서에 모든 직원이 들어간 형식이 나타난다.

-- CROSS JOIN 명시 ( 동일한 결과를 확인 가능 )
SELECT empno, ename, dname
FROM emp CROSS JOIN dept;

-- EQUI JOIN과 동일함 
SELECT *
FROM emp, dept
WHERE emp.deptno = dept.deptno;

-- CROSS JOIN

-- NATURAL JOIN

-- 사원번호, 사원명, 부서명, 부서워치를 부서명으로 오름차순 정렬
-- 1. INNER JOIN ON
SELECT a.empno, a.ename, b.dname, b.loc
FROM emp a JOIN dept b
ON a.deptno = b.deptno
ORDER BY b.dname;
-- 2. NATURAL JOIN > 각 테이블의 공통적인 요소를 자동으로 연결해준다. (명시하면 에러)
-- 공통적인 요소를 SELECT 절에서 사용할 때도 테이블을 명시해서는 안된다. (하나의 컬럼임)
SELECT a.empno, a.ename, b.dname, b.loc
FROM emp a NATURAL JOIN dept b
ORDER BY 3;
-- 3. JOIN USING
-- USING절에 사용된 공통 컬럼은 하나의 컬럼이된다. (테이블 명시 X)
SELECT a.empno, a.ename, deptno ,b.dname, b.loc
FROM emp a JOIN dept b
USING(deptno)
ORDER BY b.dname;
-- >>  1,2,3 는 동일한 결과가 나오는 쿼리문



-- OUTER JOIN

-- INNER JOIN에서 (+) 명령어로 OUTER JOIN 으로 
-- (+)는 작성해준 위치를 기준으로 동일한 데이터가 없어도 있다고 판단하라는 의미이다. 
-- 즉, 작성한 위치의 데이터는 없어도 null값으로 출력한다. 
SELECT a.empno, a.ename,a.deptno, b.deptno, b.dname, b.loc
FROM emp a JOIN dept b
ON a.deptno(+) = b.deptno
ORDER BY b.dname;

-- RIGHT OUTER JOIN / 위의 쿼리문과 동일 (우측의 데이터는 전부 출력 - 좌측에없는 데이터는 null)
-- LEFT OUTER JOIN은 좌측의 데이터를 전부 출력
SELECT a.empno, a.ename,a.deptno, b.deptno, b.dname, b.loc
FROM emp a RIGHT OUTER JOIN dept b
ON a.deptno = b.deptno
ORDER BY b.dname;

-- 두개의 테이블을 모두 출력 (양측에 없는 데이터는 null값으로 출력됨)
SELECT a.empno, a.ename,a.deptno, b.deptno, b.dname, b.loc
FROM emp a FULL OUTER JOIN dept b
ON a.deptno = b.deptno
ORDER BY b.dname;



-- NON-EQUI JOIN
-- emp 테이블과 salgrade 테이블을 사용하여 사원의 급여에 따라 
-- 등급을 나타내는 쿼리문을 작성. (하나의 ROW에 같이)
SELECT * 
FROM emp a , salgrade b
WHERE a.sal BETWEEN b.losal AND b.hisal
ORDER BY b.grade;


-- SELF JOIN 
-- 사원번호, 사원명, 관리자번호 / 관리자번호 정렬
SELECT empno, ename, mgr 
FROM emp
ORDER BY mgr;

-- 사원번호, 사원명 / 사원번호 정렬
SELECT empno, ename 
FROM emp
ORDER BY empno;

-- 사원번호, 사원명, 관리자번호, 관리자명 
SELECT a.empno "사원번호", a.ename "사원명", a.mgr "관리자번호", b.ename "관리자명"
FROM emp a, emp b
WHERE a.mgr = b.empno;




-- SUB QUERY 
-- 사원번호, 사원명, 부서번호 / 부서번호 오름
SELECT empno, ename, deptno
FROM emp
ORDER BY deptno;

-- 10번 부서근무자들의 정보만
SELECT empno, ename, deptno
FROM emp
WHERE deptno = 10;

-- CLARK와 같은 부서근무자들의 정보만
SELECT empno, ename, deptno
FROM emp
WHERE deptno = 
(SELECT deptno 
FROM emp
WHERE ename = 'CLARK');

-- 서브쿼리 위치에 따른 명칭
-- SELECT 절 : 스칼라 서브쿼리
-- FROM 절 : 인라인 뷰
-- WHERE 절 : 중첩쿼리

-- 전체 사원평균급여보다 급여를 많이받는 사원의 정보 / 고액급여자 부터
SELECT * 
FROM emp
WHERE sal >
(SELECT AVG(sal) 
FROM emp)
ORDER BY sal DESC;

-- !! 부서별 사원평균급여 보다 많이 받는 사원정보
SELECT a.empno, a.ename, a.sal, a.deptno, b.average 
FROM emp a
JOIN 
(SELECT deptno, avg(sal) average
FROM emp
GROUP BY deptno) b
ON a.deptno = b.deptno
WHERE sal >= b.average;

SELECT * 
FROM emp a,
(SELECT deptno, avg(sal) average
FROM emp
GROUP BY deptno) b
WHERE a.deptno = b.deptno
AND a.sal > b.average;


-- 7369사원과 같은 일을 하는 사원정보
SELECT * 
FROM emp
WHERE job = 
(SELECT job 
FROM emp
WHERE empno = 7369);

-- 급여를 제일 많이 받는 사원의 정보를 구하세요
SELECT *
FROM emp
WHERE sal = 
(SELECT MAX(sal)
FROM emp);


-- 10번 부서에 근무하는 사원들과 동일업무에 종사하는 사원정보 조회
SELECT * 
FROM emp
WHERE job IN 
(SELECT job 
FROM emp
WHERE deptno = 10);

-- 10번 부서에 근무하는 사원들과 동일 급여를 받는 사원정보
SELECT * 
FROM emp
WHERE sal IN
(SELECT sal 
FROM emp
WHERE deptno = 10)
AND deptno != 10;

-- 10번 부서에 근무하는 "어떤" 사원보다 급여를 많이 받는 사원 정보 조회
-- ANY : 다중행을 전부 비교하여 하나만 TRUE여도 TRUE (OR)
SELECT * 
FROM emp
WHERE sal >=
ANY(SELECT sal
FROM emp
WHERE deptno = 10)
AND deptno != 10;
-- 현재상황에서 MIN과 동일 (숫자 , >= 연산자)
SELECT * 
FROM emp
WHERE sal >=
(SELECT MIN(sal)
FROM emp
WHERE deptno = 10)
AND deptno != 10;

-- 10번 부서에 근무하는 "모든" 사원들보다 급여를 많이 받는 사원 정보 조회
-- ALL 명령어 : 다중행 전부와 비교하여 전부 TRUE일 때만 TRUE (AND)
SELECT * 
FROM emp
WHERE sal >=
ALL(SELECT sal
FROM emp
WHERE deptno = 10)
AND deptno != 10;
-- 현재상황에서 MAX와 동일 (숫자 , >= 연산자)
SELECT * 
FROM emp
WHERE sal >=
(SELECT MAX(sal)
FROM emp
WHERE deptno = 10)
AND deptno != 10;

-- EXIST 존재여부 파악 ROW가 출력되는가 안되는가를 파악함 내용은 의미없음 (TRUE, FALSE)
SELECT * 
FROM emp
WHERE EXISTS(SELECT ENAME 
            FROM emp
            WHERE job = 'SALESMAN');
            --WHERE job = 'oo');
            
-- 연관성이 있는 서브쿼리 
-- 직원을 관리하는 직원만 출력 ( 관리자의 정보만 출력 )
SELECT * 
FROM emp e
WHERE EXISTS(SELECT empno
            FROM emp
            WHERE e.empno=mgr);
            

SELECT dname,
(SELECT COUNT(*) AS empCNT
FROM emp
WHERE deptno = dept.deptno)
FROM dept;


-- INLINE VIEW (FROM절에 사용된 서브쿼리)
-- VIEW 란????? 크게 말하면 가상 테이블을 말함
-- 하나 이상의 테이블이나 다른 뷰의 데이터를 볼 수 있게 하는 DB 객체이다.

-- 생성 (생성을 위해서는 권한 필요) 
-- CREATE [OR REPLACE] VIEW를 생성 (OR REPLACE 생략하면 동일이름 존재 시 에러)
-- OR REPLACE를 명시해주면 만약 동일한 이름의 VIEW가 존재한다면 이를 현재 생성하는 쿼리로 VIEW를 대체한다.
CREATE OR REPLACE VIEW VW_EMP7369
AS
SELECT empno,job, ename, deptno, sal
 FROM emp 
 WHERE job = 
(SELECT job
 FROM emp 
 WHERE empno = 7369);

-- view명을 정할때는 접두사,접미사로 view임을 알려주는 문구를 명시하는것이 좋다. (vw_, _vw, _view, view_.....등 원하는 형식)

-- 권한이 없어서 에러날때 권한을 부여-- SQL COMMAND에서 관리자 계정으로 생성
GRANT CREATE VIEW TO scott;

-- VIEW는 생성 당시 작성해준 기준에서 데이터가 들어가는 것이 아니라 
-- 쿼리문 자체(TEXT)가 저장되는 형식이므로 VIEW를 생성하고 해당 VIEW에서
-- 참조한 테이블을 수정하게 된다면, VIEW도 같이 수정된다. 
-- 또한 VIEW를 통한 INSERT문을 작성했을 경우 VIEW가 참조하는 TABLE에도 영향을 끼치게된다.
-- VIEW와 (참조)TABLE은 연결되어있다고 생각하면 된다. 

-- VIEW 조회
SELECT * FROM VW_emp7369;
-- VIEW를 통한 입력
INSERT INTO VW_emp7369 VALUES(9002, 'CLERK', 'GDGD', 40, 4050);
-- VIEW를 통한 INSERT가 참조 TABLE에 영향을 끼쳤는가 확인
SELECT * 
FROM emp;
-->> VIEW를 수정하면 참조 TABLE이 같이 수정됨을 확인가능

-- 작성한 VIEW들의 정보를 확인
SELECT * 
FROM user_views;
-->> 데이터가 아닌 쿼리문이 저장되어있다. 

DESC VW_emp7369;


-- UPDATE문, DELETE문을 통해서 VIEW를 통한 입력,수정,조회는 참조 TABLE을 다루는 것과 동일한 것처럼 생각할 수 있지만
-- VIEW에서 검색되지 않는 데이터는 수정, 삭제가 불가능하다. 위에서 INSERT문으로 VIEW에 1개의 ROW가 생성되도록 하고
-- UPDATE문을 통하여 VIEW에서 더이상 검색이 되지 않도록 수정한 이후에 동일한 명령문을 실행하게 되면 
-- 0개의 행이 업데이트 되었다는 문구가 나타나면서 수정이 이뤄지지 않는다. 
-- 권한의 문제도, 문법의 문제도 아닌 상태에서 수정이 안되는데 이는 VIEW에서 검색되지 않기 때문에 VIEW를 통하여 수정이 불가
UPDATE VW_EMP7369
SET job = '개발자'
WHERE empno = 9002;

SELECT * 
FROM emp;

DELETE FROM VW_emp7369
WHERE empno = 9002;


SELECT * 
FROM emp;


-- 40번 부서근무자중 급여를 6600 받는 개발자를 삭제 
DELETE FROM emp
WHERE deptno = 40
AND sal = 6600
AND job = '개발자';


-- 다중테이블 INSERT (조건에 따라 테이블에 값 입력)
INSERT [ALL | FIRST]
[WHEN 조건1 THEN]
INTO 테이블명[(컬럼명...)] VALUES(값....)
[WHEN 조건2 THEN]
INTO 테이블명[(컬럼명...)] VALUES(값....)
......
[ELSE]
INTO 테이블명[(컬럼명...)] VALUES(값....)
서브쿼리문;

CREATE TABLE 테이블명(
    컬럼명 데이터타입(크기),
    컬럼명 데이터타입(크기),
    컬럼명 데이터타입(크기),
    ....
    
    );

-- 테이블 복사 : 서브쿼리를 사용해서 기존 테이블의 구조 및 데이터를 복사하여 새로운 테이블 생성
-- 제약조건까지는 복사하지 않는다.
-- 원본 테이블로 작업하게되면 데이터의 양도 많고, 잘못되면 안되기 때문에 복사하여 테스트를 진행하기도함
CREATE TABLE emp2
AS
SELECT empno, ename, sal 
FROM emp;

DESC emp2;

SELECT * FROM emp2;
-- 커밋( 현상황 적용/저장 )
COMMIT;
-- emp2테이블 내용 삭제 (WHERE절이 없으므로 전체 데이터)
DELETE FROM emp2;
-- 내용 확인
SELECT * FROM emp2;
-- 롤백 (마지막으로 커밋한 상태로)
ROLLBACK;
-- 내용확인
SELECT * FROM emp2;


-- TRUNCATE : 제거 (테이블 내용을 제거함) -> WHERE절을 사용할 수 없음 / DELETE는 WHERE절 사용 가능
TRUNCATE TABLE emp2;

SELECT * FROM emp2;
-- 롤백 (TRUNCATE는 불가능함) : AUTO COMMIT
ROLLBACK;
SELECT * FROM emp2;


-- 테이블 제거 : DROP TABLE..... (데이터 뿐 아니라 구조 자체를 삭제함)
DROP TABLE emp2;

DESC emp2;

-- WHERE절에 FALSE값이 들어가 어떠한 데이터도 들어오지 않지만, 테이블의 구조는 가져온다.
CREATE TABLE emp2
AS
SELECT empno, ename, sal 
FROM emp
WHERE 1=2;

-- 조건없이 테스트
-- emp에서 이름에 A가 포함된 사원의 사원번호, 사원명을 emp2,emp3에 입력
-- VALUES값으로는 서브쿼리에서 작성된 컬럼명을 사용한다.
INSERT ALL
INTO emp2 VALUES(empno, ename, sal)
INTO emp3 VALUES(empno, ename, sal)
SELECT empno, ename, sal
FROM emp
WHERE ename LIKE '%A%';
-- > INSERT 성공한 행의 개수를 출력해주며 테이블 마다 성공한 횟수들의 합을 의미함

-- ALL, 조건 
INSERT ALL
WHEN sal > 4000 THEN 
    INTO emp2 VALUES(empno, ename, sal)
WHEN sal >= 3000 THEN 
    INTO emp3 VALUES(empno, ename, sal)  
ELSE 
    INTO emp4 VALUES(empno, ename, sal)  
SELECT empno, ename, sal
FROM emp;

-- FIRST, 조건 
INSERT FIRST
WHEN sal > 4000 THEN 
    INTO emp2 VALUES(empno, ename, sal)
WHEN sal >= 3000 THEN 
    INTO emp3 VALUES(empno, ename, sal)  
ELSE 
    INTO emp4 VALUES(empno, ename, sal)  
SELECT empno, ename, sal
FROM emp;
--> FIRST와 ALL의 차이는 WHEN절을 순차적으로 실행하되 전체를 실행하여 조건충족하는 위치에 전부 추가
--> FIRST는 WHEN절을 순차적으로 진행하며 조건을 만족하는 데이터가 나오면 이후의 WHEN절은 SKIP한다.

SELECT * FROM emp2;
SELECT * FROM emp3;
SELECT * FROM emp4;

ROLLBACK;




-- 임시 테이블 생성 (WITH)
WITH temp AS (
  SELECT VARCHAR2(20)
    FROM dual 
)  
SELECT dt
     , TRUNC(dt, 'YEAR')  --월, 일 초기화
FROM temp;

-- 오라클은 SELECT절의 ALIAS를 ORDER BY절 이외의 절에서 사용이 불가하다.