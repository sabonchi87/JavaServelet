create table questions(id integer auto_increment primary key,name varchar(600))
insert into questions(name) values ("What versions of tomcat Should i use?")

insert into questions(name) values ("JQuery How to locate parent element?")


create table  details (id integer auto_increment primary key,name varchar(600),q_id integer references questions(id))

insert into answers  (name,q_id) values ("Is js Hard",1)

SELECT COUNT(`q_id`)
FROM `answers` where q_id=1
group by q_id


ALTER TABLE `answers`
ADD FOREIGN KEY (`q_id`) REFERENCES `questions` (`id`)