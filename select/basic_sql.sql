-- select 기본
select first_name,
	   last_name,
       gender,
       hire_date
  from employees;

select concat(first_name, ' ', last_name),
	   gender,
       hire_date
  from employees;
  
-- alias -> as 생략 가능
select concat(first_name, ' ', last_name) as name,
	   gender,
       hire_date
  from employees;			
  
  select concat(first_name, ' ', last_name) as '이름',
		 gender '성별',
		 hire_date '입사날짜'
	from employees
order by hire_date desc;  

-- distinct 중복 제거
select distinct(title) from titles;

-- salaries 테이블에서 2001년 월급을 가장 높은순으로 사번, 월급 순으로 출력
select *
from salaries
where from_date like '2001%';


-- dept_emp 테이블에서 부서 번호가 d005나 d009에 속한 사원의 사번, 부서번호 출력
select *
from dept_emp
where dept_emp = 'd005' 
or dept_emp = 'd009';

-- Like 검색


-- employees 테이블에서 1989년에 입사한 직원의 이름,
select concat(first_name, ' ', last_name) as '이름',
       hire_date
  from employees
 where hire_date < '1990-01-01'
order by hire_date desc;
