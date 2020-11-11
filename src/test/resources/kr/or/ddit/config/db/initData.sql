
/* 에러방지용 테이블 조회 쿼리 */
select *
from NOT_EXISTS_IN_PRD;


/* DELETE users; */
TRUNCATE TABLE users;

Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('brown','브라운','brownPass',to_date('2020/10/22','YYYY/MM/DD'),'곰',null,null,null,'D:\profile\cb3cd39d-2a90-49d0-ad6c-12f974c59f8d.png','brown.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('cony','코니','conyPass',to_date('2020/10/21','YYYY/MM/DD'),'토끼',null,null,null,'D:\profile\cony.png','cony.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('sally','샐리','sallyPass',to_date('2020/10/21','YYYY/MM/DD'),'병아리',null,null,null,'D:\profile\sally.png','sally.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('james','제임스','jamesPass',to_date('2020/10/21','YYYY/MM/DD'),'사람',null,null,null,'D:\profile\james.png','james.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('moon','문','moonPass',to_date('2020/10/21','YYYY/MM/DD'),'달',null,null,null,'D:\profile\moon.png','moon.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('leonard','레너드','leonardPass',to_date('2020/10/21','YYYY/MM/DD'),'개구리',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('edward','에드워드','edwardPass',to_date('2020/10/21','YYYY/MM/DD'),'애벌레',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('jessica','제시카','jessicaPass',to_date('2020/10/21','YYYY/MM/DD'),'고양이',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('boss','보스','bossPass',to_date('2020/10/21','YYYY/MM/DD'),'사람',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('choco','초코','chocoPass',to_date('2020/10/21','YYYY/MM/DD'),'곰2',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('pangyo','팡요','pangyoPass',to_date('2020/10/21','YYYY/MM/DD'),'판다',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('muzi','무지','muziPass',to_date('2020/10/21','YYYY/MM/DD'),'토끼',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('con','콘','conPass',to_date('2020/10/21','YYYY/MM/DD'),'악어',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('apeach','어피치','apeachPass',to_date('2020/10/22','YYYY/MM/DD'),'복숭아',null,null,null,'D:\profile\0ea0ac71-89cd-4907-ad05-334915a9309d.png','apeach.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('ryan','라이언 ','ryanPass',to_date('2020/10/21','YYYY/MM/DD'),'사자',null,null,null,'D:\profile\ryan.png','ryan.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('shs','신하승','pass1234',to_date('2020/11/09','YYYY/MM/DD'),'java','대전 중구 중앙로 76','영민빌딩 4충 404호','34904','D:\profile\ca858b33-c16a-4c59-aad4-afc5f6cc1963.jpg','펭귄.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('user001','유저001','1234',to_date('2020/11/09','YYYY/MM/DD'),'유저001',null,'404호',null,'D:\profile\f098d778-1db7-4779-8220-7a18c0e83484.jpg','사자.jpg');


commit;