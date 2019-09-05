-- 단일행 연산
-- ex) 현재 Fai Bale이 근무하는 부서)에서 근무하는 (직원의 사번, 전체이름)을 출력하쇼

-- sol1) 현재 Fai Bale이 근무하는 부서를 찾음
select  a.dept_no
from dept_emp a, employees b
where a.emp_no = b.emp_no
and to_date = '9999-01-01'
and concat(b.first_name, ' ', b.last_name) = 'Fai Bale';

select  a.dept_no, concat(b.first_name, ' ', b.last_name)
from dept_emp a, employees b
where to_date = '9999-01-01'
and a.dept_no = any(select  a.dept_no
						from dept_emp a, employees b
						where a.emp_no = b.emp_no
						and to_date = '9999-01-01'
						and concat(b.first_name, ' ', b.last_name) = 'Fai Bale');

-- 서브쿼리는 괄호로 묶어야 함
-- 서브쿼리 내에 order by 금지
-- group by 절에 외에 거의 모든 절에서 사용가능 (특히, from, wherer절에 많이 사용)
-- where절의 경우
-- 1) 단일행 연산자 > < = 같은거들

-- 실습문제 1) 현재 전체사원의 평균 연봉보다 적은 급여를 받는 사원의  이름, 급여를 나타내세요.
select concat(a.first_name, ' ' , a.last_name), b.salary
from employees a, salaries b
where a.emp_no = b.emp_no
and b.salary < (select avg(salary) 
				from salaries
				where to_date = '9999-01-01')


-- 실습문제 2) 현재 가장적은 평균 급여를 받고 있는 직책에 대해서 평균 급여를 구하세요 
select b.title, avg(a.salary)
from salaries a, titles b
where a.emp_no = b.emp_no
and a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
group by b.title
having round(avg(a.salary)) = (select round(avg(a.salary))
								from salaries a, titles b
								where a.emp_no = b.emp_no
								and a.to_date = '9999-01-01'
								and b.to_date = '9999-01-01'
								group by b.title
								limit 0, 1);

-- where 절의 경우
-- 2) 다중(복수)행 연산자 : in, not in, any , all
-- any 사용법
-- =any in과 완전동일
-- >any, >=any 최소값
-- <any, <=any 최대값
-- <>any, != any  not equal


-- 방법2) subquery로 해결 (in)

select first_name
from employees a
where a.emp_no in (
   select emp_no
   from salaries
   where to_date = '9999-01-01'
   and salary > 50000);
    
-- 방법3) subquery로 해결 (=any)

select first_name
from employees a
where a.emp_no =any (
   select emp_no
   from salaries
   where to_date = '9999-01-01'
   and salary > 50000);
    
-- 2) 각 부서별로 최고 월급을 받는 직원의 이름과 월급 출력
-- dept_no, first_name, max_salary
select max(a.salary) as max_salary
from salaries a, dept_emp b
where a.emp_no = b.emp_no
and a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
group by b.dept_no;

select *
from (select max(a.salary) as max_salary
from salaries a, dept_emp b
where a.emp_no = b.emp_no
and a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
group by b.dept_no)