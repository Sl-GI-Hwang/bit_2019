-- 문제1. 107706
-- 현재 평균 연봉보다 많은 월급을 받는 직원은 몇 명이나 있습니까?

select count(*)
from salaries s
where s.to_date = '9999-01-01'
and  s.salary > (select avg(salary) 
				from salaries
                where to_date = '9999-01-01') ;


-- 문제2. 
-- 현재, 각 부서별로 최고의 급여를 받는 사원의 사번, 이름, 부서, 연봉을 조회하세요. 단 조회결과는 연봉의 내림차순으로 정렬되어 나타나야 합니다. 
-- +--------+--------------------+--------------------+--------+
-- | emp_no | name               | dept_name          | salary |
-- +--------+--------------------+--------------------+--------+
-- |  43624 | Tokuyasu Pesch     | Sales              | 158220 |
-- | 466852 | Akemi Warwick      | Marketing          | 145128 |
-- |  18006 | Vidya Hanabata     | Customer Service   | 144866 |
-- |  13386 | Khosrow Sgarro     | Development        | 144434 |
-- | 413137 | Lunjin Swick       | Finance            | 142395 |
-- | 421835 | Yinlin Flowers     | Human Resources    | 141953 |
-- | 430504 | Youjian Cronau     | Production         | 138273 |
-- | 472905 | Shin Luck          | Quality Management | 132103 |
-- | 425731 | Ramachenga Soicher | Research           | 130211 |
-- +--------+--------------------+--------------------+--------+

select  a.emp_no, concat(a.first_name , ' ', a.last_name) as 'name', e.dept_name, b.salary
from employees a, salaries b, dept_emp d, departments e,
     (select a.dept_no, max(b.salary) as salary from salaries b, dept_emp a
				where b.emp_no = a.emp_no
                and b.to_date = '9999-01-01'
                group by a.dept_no
                ) f
where a.emp_no = b.emp_no
and a.emp_no = d.emp_no
and d.dept_no = e.dept_no
and b.salary = f.salary
and d.dept_no = f.dept_no
order by b.salary desc;


-- 문제3. 113154
-- 현재, 자신의 부서 평균 급여보다 연봉(salary)이 많은 사원의 사번, 이름과 연봉을 조회하세요 
select  a.emp_no, concat(a.first_name , ' ', a.last_name) as 'name',  b.salary
from employees a, salaries b, dept_emp d,
	(select a.dept_no, avg(b.salary) as salary from salaries b, dept_emp a
	where b.emp_no = a.emp_no
    and b.to_date = '9999-01-01'
    and a.to_date = '9999-01-01'
    group by a.dept_no) c
where a.emp_no = b.emp_no
and b.to_date = '9999-01-01'
and d.to_date = '9999-01-01'
and a.emp_no = d.emp_no
and d.dept_no = c.dept_no
and b.salary > c.salary;



-- 문제4. 240124
-- 현재, 사원들의 사번, 이름, 매니저 이름, 부서 이름으로 출력해 보세요.
select a.emp_no, concat(a.first_name, ' ' ,a.last_name), b.name, c.dept_name
from employees a, departments c, dept_emp d,
     (select concat(b.first_name, ' ' ,b.last_name) as name, a.dept_no, a.emp_no 
      from employees b, dept_manager a
      where a.emp_no = b.emp_no
      and a.to_date = '9999-01-01'
      ) b
where a.emp_no = d.emp_no
and d.dept_no = c.dept_no
and d.dept_no = b.dept_no
and d.to_date = '9999-01-01';


-- 문제5. 14842
-- 현재, 평균연봉이 가장 높은 부서의 사원들의 사번, 이름, 직책, 연봉을 조회하고 연봉 순으로 출력하세요.
select  a.emp_no, concat(a.first_name , ' ', a.last_name) as 'name', d.title,  b.salary
from employees a, salaries b, titles d, dept_emp c,
    (select e.dept_no, max(avg_salary) as avg_salary
    from 
		(select a.dept_no, avg(b.salary) as avg_salary 
        from salaries b, dept_emp a
		where b.emp_no = a.emp_no
		and b.to_date = '9999-01-01'
		group by a.dept_no) e
	) e        
where a.emp_no = b.emp_no
and a.emp_no = c.emp_no
and a.emp_no = d.emp_no
and c.dept_no = e.dept_no
and b.to_date = '9999-01-01'
and c.to_date = '9999-01-01'
and d.to_date = '9999-01-01'
order by b.salary desc;


-- 문제6.
-- 평균 연봉이 가장 높은 부서는? 
-- +-----------+------------+
-- | dept_name | avg_salary |
-- +-----------+------------+
-- | Sales     | 88842.1590 |
-- +-----------+------------+

select c.dept_name, avg(b.salary) as avg_salary from salaries b, dept_emp a, departments c
where b.emp_no = a.emp_no
and a.dept_no = c.dept_no
and b.to_date = '9999-01-01'
group by a.dept_no
order by avg_salary desc
limit 1;


-- 문제7.
-- 평균 연봉이 가장 높은 직책?
-- +--------------+------------+
-- | title        | avg_salary |
-- +--------------+------------+
-- | Senior Staff | 80705.9855 |
-- +--------------+------------+

select a.title, avg(b.salary) as avg_salary from salaries b, titles a
where b.emp_no = a.emp_no
and b.to_date = '9999-01-01'
group by a.title
order by avg_salary desc
limit 1;
    
    
-- 문제8. 97261
-- 현재 자신의 매니저보다 높은 연봉을 받고 있는 직원은? 부서이름, 사원이름, 연봉, 매니저 이름, 메니저 연봉 순으로 출력합니다.

select c.dept_name, concat(a.first_name, ' ' ,a.last_name), e.salary, b.name, b.salary
from employees a, departments c, dept_emp d, salaries e,
     (select concat(b.first_name, ' ' ,b.last_name) as name, a.dept_no, c.salary
      from employees b, dept_manager a, salaries c
      where a.emp_no = b.emp_no
      and b.emp_no = c.emp_no
      and a.to_date = '9999-01-01'
      and c.to_date = '9999-01-01') b
where a.emp_no = d.emp_no
and a.emp_no = e.emp_no
and d.dept_no = c.dept_no
and d.dept_no = b.dept_no
and d.to_date = '9999-01-01'
and e.to_date = '9999-01-01'
and e.salary > b.salary;