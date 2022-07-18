create table member(
id varchar2(20) primary key,
pw varchar2(100),
addr varchar2(50),
name varchar2(20),
email varchar2(30),
prf_addr varchar2(200),
gender varchar2(1),
per_cate varchar2(20),
auto_cookie varchar2(100),
phNum varchar2(20),
age int,
rpt int,
limit_time date
);
commit;
