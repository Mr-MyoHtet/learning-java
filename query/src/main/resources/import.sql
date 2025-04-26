insert into course(name,hours,fees) value('Java Basic','100','200000');
insert into course(name,hours,fees) value('Java Web','80','150000');
insert into course(name,hours,fees) value('Spring Framework','190','200000');
insert into course(name,hours,fees) value('Java EE','120','3000000');
insert into course(name,hours,fees) value('React','100','1200000');

insert into section(course_id,end_at, fees, start_at,days,end_time,start_time) values ('1','2024-08-15', '150000', '2024-04-10', 'SATURDAY,SUNDAY','12:00','9:00');
insert into section(course_id,end_at, fees, start_at,days,end_time,start_time) values ('2','2024-08-15', '200000', '2024-04-09', 'MONDAY,TUESDAY,WEDNESDAY','16:00','13:00');
insert into section(course_id,end_at, fees, start_at,days,end_time,start_time) values ('3','2024-09-30', '400000', '2024-04-08', 'MONDAY,TUESDAY,WEDNESDAY','16:00','9:00');
insert into section(course_id,end_at, fees, start_at,days,end_time,start_time) values ('4','2024-08-15', '200000', '2024-04-07', 'MONDAY,TUESDAY,WEDNESDAY','12:00','9:00');
insert into section(course_id,end_at, fees, start_at,days,end_time,start_time) values ('5','2024-08-15', '200000', '2024-04-06', 'SATURDAY,SUNDAY','16:00','13:00');
insert into section(course_id,end_at, fees, start_at,days,end_time,start_time) values ('1','2024-12-10', '150000', '2024-10-05', 'SATURDAY,SUNDAY','16:00','9:00');
insert into section(course_id,end_at, fees, start_at,days,end_time,start_time) values ('2','2024-12-10', '200000', '2024-10-01', 'MONDAY,TUESDAY,WEDNESDAY','12:00','13:00');
insert into section(course_id,end_at, fees, start_at,days,end_time,start_time) values ('3','2024-12-10', '200000', '2024-10-02', 'MONDAY,TUESDAY,WEDNESDAY','16:00','9:00');
insert into section(course_id,end_at, fees, start_at,days,end_time,start_time) values ('4','2024-12-10', '200000', '2024-10-03', 'MONDAY,TUESDAY,WEDNESDAY','16:00','9:00');

insert into student (name, phone, email) values ('Aung', '09978961902', 'aung@gmail.com');
insert into student (name, phone, email) values ('Maung Maung', '09978961903', 'maung@gmail.com');
insert into student (name, phone, email) values ('Thidar', '09978961904', 'thidar@gmail.com');
insert into student (name, phone, email) values ('Nilar', '09978961905', 'nilar@gmail.com');
insert into student (name, phone, email) values ('Myo Myint', '09978961906', 'myomyint@gmail.com');
insert into student (name, phone, email) values ('Win Htun', '09978961907', 'winhtun@gmail.com');
insert into student (name, phone, email) values ('Phyu', '09978961908', 'phyu@gmail.com');
insert into student (name, phone, email) values ('Win Win', '09978961909', 'winwin@gmail.com');
insert into student (name, phone, email) values ('War War', '09978961910', 'warwar@gmail.com');