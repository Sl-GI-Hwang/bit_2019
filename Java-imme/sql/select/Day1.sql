-- upper
-- 자바 upperCase보다 DB의 upper()가 더 빠르다
-- 웬만한 DB에서 문자열 처리 뿐만 아니라 포맷팅 처리등을 다 해주고
-- java에서는 출력만 해결한다.

select upper('SeouL'), upper('seoul');
select upper(first_name) from employees;

select first_name from employees;

-- lower
select lower('SEoul'), lower('SEOUL');

-- substring()
select substring('Happy Day', 3, 2);

select first_name as '이름',
	   substring(hire_date, 1, 4) as '입사년도'
  from employees;
  

-- lpad, rpad : 정렬
select lpad('1234', 10, '-');
select rpad('1234', 10, '-');


-- salaries 테이블에서 1년 급여가 70000불 이하의 직원만 사원, 급여로 출력하되
-- 급여는 10자리로 부족한 자리수는 *로 표시

select emp_no, lpad(cast(salary as char), 10, '*')
from salaries
where from_date = '2001%'
and salary < 70000;


-- ltrim, rtrim, trim
select concat('------', ltrim('		hello		'), '---') as 'LTRIM',
       concat('------', rtrim('		hello		'), '---') as 'RTRIM',
	   concat('------', trim('		hello		'), '---') as 'TRIM',
	   concat('------', trim(both 'x' from 'xxxxxxhelloxxxxxx'), '---') as 'TRIM2',       
	   concat('------', trim(leading 'x' from 'xxxxxxhelloxxxxxx'), '---') as 'TRIM2',       
	   concat('------', trim(trailing 'x' from 'xxxxxxhelloxxxxxx'), '---') as 'TRIM2';            
       
       
       
select * from dept_emp;
select * from dept_manager;
select * from titles;

