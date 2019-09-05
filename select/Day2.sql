
-- 절대값
select abs(2), abs(-2);

-- mod 연산
select mod(7, 2), mod(15, 4);

-- floor
select floor(3.14), floor(-3.14);

-- celling
select ceiling(3.14), ceiling(-3.14);

-- round
select round(1.298), round(1.51515151);

-- pow
select pow(2, 5), power(10, 5);

-- sign(x)
select sign(-2), sign(2), sign(8);

select greatest(10, 2, 4, 9),
least(10, 2, 4, 9),
greatest('ABc', 'Abc1', 'ABcD');

-- 날짜 관련
select curdate(), current_date;
select curtime(), current_time;
select now(), sysdate(), current_timestamp;

select now(), sleep(2), now();
select now(), sleep(2), sysdate();

select date_format(now(),'%Y년 %m월 %d일 %W %h:%i:%s');

-- period diff(p1, p2)
-- : YYMM,YYYYMM으로 표기되는 p1과 p2의 차이의 개월을 반환한다
-- ex) 직원들의 근무 개월 수 구하기
select concat(first_name, ' ', last_name) as name,
	   period_diff(date_format(curdate(), '%Y%m'), date_format(hire_date, '%Y%m'))
from employees;

-- ex) 직원들의 6개월후 날짜 찾기
select concat(first_name, ' ', last_name) as name,
       hire_date,
	   date_add(hire_date, INTERVAL 6 month)
from employees;

-- cast
select now(), cast(now() as date), cast(now() as datetime);

select 1-2, cast(1-2 as unsigned);