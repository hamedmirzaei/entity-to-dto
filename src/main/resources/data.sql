insert into ADDRESS_TABLE(ID, CITY, STREET, ALLEY, FLOOR, NUMBER, POSTAL_CODE)
VALUES (1, 'Tehran', 'Farzin', 'Gonabad', '3', '5', '1111111111');
insert into ADDRESS_TABLE(ID, CITY, STREET, ALLEY, FLOOR, NUMBER, POSTAL_CODE)
VALUES (2, 'Ilam', 'Edalat', 'Adl4', '4', '5', '3333333333');

insert into USER_TABLE(ID, FIRST_NAME, LAST_NAME, USERNAME, PASSWORD, ADDRESS_ID)
values (1, 'Hamed', 'Mirzaei', 'hamedmirzaei', 'abcd5678', 1);
insert into USER_TABLE(ID, FIRST_NAME, LAST_NAME, USERNAME, PASSWORD, ADDRESS_ID)
values (2, 'Ali', 'Mirzaei', 'alimirzaei', 'qwer3513', 1);

insert into SKILL_TABLE(ID, NAME, DESCRIPTION)
VALUES (1, 'Java', 'Ability to write Java programs');
insert into SKILL_TABLE(ID, NAME, DESCRIPTION)
VALUES (2, 'UI', 'Ability to design and develop user interfaces');

insert into USER_SKILL(USERID, SKILLID)
VALUES (1, 1);
insert into USER_SKILL(USERID, SKILLID)
VALUES (1, 2);