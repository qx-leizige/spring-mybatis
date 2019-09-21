CREATE TABLE student ( id INT PRIMARY KEY auto_increment, NAME VARCHAR ( 20 ), age INT DEFAULT 20, cardid INT ) auto_increment = 1;

CREATE TABLE studentCard ( cardid INT PRIMARY KEY auto_increment, cardInfo VARCHAR ( 20 ) ) auto_increment = 1;

insert into student (name,age,cardid)values ('zs',23,1),('ls',24,1);
insert into studentCard (cardInfo) values ('zs info ...'),('ls info...');

select  from student;
select  from studentCard;

alter table student add constraint fk_student_studentclass_cardid foreign key(cardid) references
studentcard(cardid)


select s.,c.cardInfo from student s inner join studentCard c
on s.cardid = c.cardid where s.id = 1

create table studentClass (classid int primary key ,classname varchar(20));

insert into studentClass (classid,classname) values (1,'g1班'),(2,'g2班');

select  from studentClass;

alter table student add column classid int;

update student set classid = 1;

alter table student constraint fk_studnet_studentclass_classid foreign key(classid) references 
studentclass(classid)

查询班级编号为1的学生和班级信息
select s.id,s.name,c.classname from studentclass c inner join student s
on c.classid = s.classid where c.classid = 1

查询班级编号为1的学生、班级和学生证信息
select s.id,s.name,s.age,c.classname,d.cardInfo from 
(studentclass c inner join student s on c.classid = s.classid)
inner join studentcard d
 on s.cardid = d.cardid
where c.classid = 1