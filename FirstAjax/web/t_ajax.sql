drop table if exists t_ajax2;
create table t_ajax2(
    id int primary key auto_increment,
    content varchar (255)
);
insert into t_ajax2(content) values ('javascript');
insert into t_ajax2(content) values ('javaweb');
insert into t_ajax2(content) values ('java');
insert into t_ajax2(content) values ('jdbc');
insert into t_ajax2(content) values ('mysql');
insert into t_ajax2(content) values ('myweb');
insert into t_ajax2(content) values ('myapp');
insert into t_ajax2(content) values ('javase');
insert into t_ajax2(content) values ('javaee');
insert into t_ajax2(content) values ('html');
select * from t_ajax2;