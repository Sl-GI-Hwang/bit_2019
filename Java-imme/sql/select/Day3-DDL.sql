use webdb;
drop table user;

create table user (
	no int unsigned not null auto_increment primary key,
    email varchar(100) not null default '',
    passwd varchar(64) not null,
    name varchar(25),
    dept_name varchar(25)
);
insert into user values(null, 'kicksmycar@gmail.com', password('1234'), '안대혁', '개발부');
insert into user (email, passwd) values('kicksyourcar@gmail.com', password('1234'));
insert into user (passwd) values(password('1234'));

alter table user add juminbunho char(13) not null after no;
alter table user drop juminbunho;
alter table user add join_date datetime default now();
alter table user change email email varchar(200) not null default 'no email';
alter table user change dept_name department_name varchar(25);

update user
set email = 'kickshiscar@gmail.com',
name = '카아악'
where no = 3;

delete
from user
where no = 4;


select * from user;
show tables;
desc user;