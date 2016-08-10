use VideoPortal

insert into UserTable values
('jayesh','talreja','jayesh.talreja@accoliteindia.com'),
('shrema','singh','shrema.singh@accoliteindia.com'),
('ankush','dhama','ankush.dhama@accoliteindia.com'),
('saicharan','movva','saicharan.movva@accoliteindia.com'),
('juhi','jain','juhi.jain@accoliteindia.com'),
('pawan','satyarthi','pawan.satyarthi@accoliteindia.com'),
('sumeet','kumar','sumeet.kumar@accoliteindia.com'),
('gagan','jha','gagan.jha@accoliteindia.com'),
('sachin','gupta','sachin.gupta@accoliteindia.com'),
('chirag','bhansal','chirag.bhansal@accoliteindia.com'),
('vishal','goyal','vishal.goyal@accoliteindia.com'),
('anshika','agarwal','anshika.agarwal@accoliteindia.com'),
('mohit','devda','mohit.devda@accoliteindia.com'),
('sanjali','makkar','sanjali.makkar@accoliteindia.com'),
('shailendra','kumar','shailendra.kumar@accoliteindia.com'),
('kartik','keshri','kartik.keshri@accoliteindia.com'),
('momin','yadav','momin.yadav@accoliteindia.com'),
('nishant','adhikari','nishant.adhikari@accoliteindia.com'),
('sonal','verma','sonal.verma@accoliteindia.com')

insert into SiteAdminTable values
(1),(13)

insert into GroupTable values
('Daredevils'),('Challengers'),('Spartans'),('Rockstars'),('Ninjas')

insert into GroupAdminTable values
(1,2),
(2,6),
(3,10),
(4,14),
(5,17)

insert into GroupUserTable values
(1,4),(1,7),(1,9),
(2,5),(2,8),(2,11),
(3,6),(3,12),(3,16),
(4,4),(4,10),(4,13),
(5,3),(5,15),(5,18)

insert into EventTable values
('Mechtrix','2016-08-08 22:20:22.220')

insert into EventTable values
('Techmax','2016-08-08 20:50:12.333'),
('DechtroMix','2016-08-05 08:40:45.123'),
('Entertainment','2016-08-01 15:20:35.111')

insert into EventTable values
('News','2016-08-06')

insert into VideoTable values
(7,null,'public','News','PM Modi',5,0,'https://www.youtube.com/embed/zQ8Pi8imRTg')

insert into VideoTable values
(10,null,'public','News','Sharmila Manipur CM',5,0,'https://www.youtube.com/embed/O0MgRo7GCn8'),
(16,null,'public','News','India on Rio',5,0,'https://www.youtube.com/embed/jAfrYJKscjY')

insert into VideoTable values
(4,null,'private','Mechtrix','Mech Engg',1,0,'https://www.youtube.com/embed/UqaQ1cE3VdI'),
(7,null,'private','Entertainment','Jons Parentage',4,0,'https://www.youtube.com/embed/wG23-cxkvZc'),
(9,null,'private','Techmax','Download Books',2,0,'https://www.youtube.com/embed/E2U4jLE8Ibg'),
(8,null,'private','DechroMix','Ego Trip',3,0,'https://www.youtube.com/embed/91N3fEB5mg4?list=PLxNUaoVw4XbfTB0qrOtjSUF4UZowOfzKB'),
(11,null,'private','Mechtrix','Make a Car',1,0,'https://www.youtube.com/embed/voT-xADi-RE'),
(5,null,'private','Techmax','Best root apps for Android',2,0,'https://www.youtube.com/embed/Z4UsUPlqScw'),
(6,null,'private','Entertainment','The Ending',4,0,'https://www.youtube.com/embed/wxG03oBY5zU'),
(12,null,'private','DechtroMix','Rude Removal',3,0,'https://www.youtube.com/embed/tl5qccIJqMk?list=PLxNUaoVw4XbfTB0qrOtjSUF4UZowOfzKB'),
(4,null,'private','Mechtrix','Solar Train',1,0,'https://www.youtube.com/embed/gOZ6P4NuO-A'),
(13,null,'private','Techmax','Warrior Hockey',2,0,'https://www.youtube.com/embed/6uVsYfbAoQU'),
(15,null,'private','Entertainment','Biggest Theory',4,0,'https://www.youtube.com/embed/61-ZvBm1cQo'),
(18,null,'private','DechtroMix','Bygone Errors',3,0,'https://www.youtube.com/embed/b6Iksw3ijJk?list=PLxNUaoVw4XbfTB0qrOtjSUF4UZowOfzKB')

insert into GroupVideoTable values
(1,4,'2016-08-08 22:20:22.220')

insert into GroupVideoTable values
(1,5,'2016-08-08 22:20:22.220'),
(1,6,'2016-08-07 22:20:22.220'),
(2,7,'2016-08-06 22:20:22.220'),
(2,8,'2016-08-05 22:20:22.220'),
(2,9,'2016-08-04 22:20:22.220'),
(3,10,'2016-08-03 22:20:22.220'),
(3,11,'2016-08-02 22:20:22.220'),
(4,12,'2016-08-01 22:20:22.220'),
(4,13,'2016-08-08 22:20:22.220'),
(5,14,'2016-08-07 22:20:22.220'),
(5,15,'2016-08-06 22:20:22.220')