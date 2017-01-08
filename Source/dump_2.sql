PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;
CREATE TABLE PROJECTS (
	ID INTEGER PRIMARY KEY AUTOINCREMENT,
	NAME TEXT,
	DESCRIPTION TEXT,
	DEFAULT_SPRINT_LENGTH INTEGER
);
INSERT INTO "PROJECTS" VALUES(1,'Empty project','Lorem ipsum dolor sit amet,<br />consectetur adipiscing elit. Aliquam at porttitor sem. Aliquam erat<br />volutpat. Donec placerat nisl magna, et faucibus arcu condimentum sed.',1);
INSERT INTO "PROJECTS" VALUES(2,'[IWI] CompWiki Simple to En','Projekt na przedmiot <b>Inteligentne Wyszukiwanie Informacji</b>.<br />Celem projektu jest oszacowanie przy pomocy algorytmów sztucznej inteligencji kategorii dla artykułów z angielskiej wiki przy pomocy simple wiki.<br />',1);
INSERT INTO "PROJECTS" VALUES(3,'test','',1);
CREATE TABLE SPRINTS (
	ID INTEGER PRIMARY KEY AUTOINCREMENT,
	NAME TEXT,
	START_DAY DATE,
	END_DAY DATE,
	PROJECT_ID INTEGER,
	FOREIGN KEY (PROJECT_ID) REFERENCES PROJECTS(ID)
);
INSERT INTO "SPRINTS" VALUES(1,'Sprint 1','2017-01-07 23:44:05','2017-01-14 23:44:05',1);
INSERT INTO "SPRINTS" VALUES(2,'Sprint 1','2017-01-08','2017-01-15',2);
INSERT INTO "SPRINTS" VALUES(3,'Odległość cos sprint 2','2017-01-15','2017-01-22',2);
INSERT INTO "SPRINTS" VALUES(4,'Bayes sprint 1','2017-01-22','2017-01-29',2);
INSERT INTO "SPRINTS" VALUES(5,'Bayes sprint 2','2017-01-29','2017-02-05',2);
INSERT INTO "SPRINTS" VALUES(6,'Sprint 1',1973,2008,3);
CREATE TABLE USER_STORY_STATUS (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    STATUS_NAME TEXT,
    COLOR TEXT,
    IS_ARCHIVE INTEGER
);
INSERT INTO "USER_STORY_STATUS" VALUES(1,'NEW','#8BC34A',0);
INSERT INTO "USER_STORY_STATUS" VALUES(2,'READY','#3f51b5',0);
INSERT INTO "USER_STORY_STATUS" VALUES(3,'IN PROGRESS','#673ab7',0);
INSERT INTO "USER_STORY_STATUS" VALUES(4,'DONE','#f9a825',0);
INSERT INTO "USER_STORY_STATUS" VALUES(5,'ARCHIVED','#9e9e9e',1);
CREATE TABLE USER_STORIES (
	ID INTEGER PRIMARY KEY AUTOINCREMENT,
	NAME TEXT,
	AS_A_STORY TEXT,
	I_WANT_TO_STORY TEXT,
	SO_THAT_STORY TEXT,
    DESCRIPTION TEXT,
	PRIORITY INTEGER,
	STORY_POINTS INTEGER,
	STATUS_ID INTEGER,
	PROJECT_ID INTEGER,
	FOREIGN KEY (PROJECT_ID) REFERENCES PROJECTS(ID),
    FOREIGN KEY (STATUS_ID) REFERENCES USER_STORY_STATUS(ID)
);
INSERT INTO "USER_STORIES" VALUES(1,'Test User Story','<user>','<some goal>','<some reason>','Some text',1,20,1,1);
INSERT INTO "USER_STORIES" VALUES(2,'Implementacja odległości cosinusowej','użytkownik','obliczyć odległości cos','klasyfikować artykuły.','Jak w temacie',1,5,4,2);
INSERT INTO "USER_STORIES" VALUES(3,'Algorytm Naiwny Bayesa','użytkownik','liczyć Bayesa','wyszukiwać kategorie','Jak wyżej',2,13,2,2);
INSERT INTO "USER_STORIES" VALUES(4,'Interfejs Graficzny','użytkownik','prosto i wygodnie posługiwać się programem','wyznaczać kategorie','Implementacja interfejsu graficznego',4,3,1,2);
CREATE TABLE USERS (
	ID INTEGER PRIMARY KEY AUTOINCREMENT,
	NAME TEXT,
	EMAIL TEXT,
	AVATAR TEXT,
	ROLE INTEGER
);
INSERT INTO "USERS" VALUES(1,'admin','admin@foo.com','null',0);
INSERT INTO "USERS" VALUES(2,'krzyswie','krzyswie@student.pg.gda.pl',NULL,2);
INSERT INTO "USERS" VALUES(3,'wojstani','wojstani@student.pg.gda.pl',NULL,2);
CREATE TABLE USERS_SECURITY (
	ID INTEGER PRIMARY KEY AUTOINCREMENT,
	USER_ID INTEGER,
	PASSWORD TEXT,
	SALT TEXT,
	SECURE_QUESTION TEXT,
	SECURE_ANSWER TEXT,
    ACCEPTED INTEGER, /* 0 - hasn't been accepted by the admin yet, cannot log in, 1 - has been accepted, can log in */
	FOREIGN KEY (USER_ID) REFERENCES USERS(ID)
);
INSERT INTO "USERS_SECURITY" VALUES(1,1,'admin','SALT','Secure question','Secure answer',1);
INSERT INTO "USERS_SECURITY" VALUES(2,2,'test','SALT','pytanie?','odpowiedź',1);
INSERT INTO "USERS_SECURITY" VALUES(3,3,'test','SALT','test','test',1);
CREATE TABLE USERS_SETTINGS (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    USER_ID INTEGER,
    RECENT_PROJECT_ID INTEGER,
	USER_STORIES_PER_PAGE INTEGER,
    TASKS_PER_PAGE INTEGER,
    FOREIGN KEY (USER_ID) REFERENCES USERS(ID),
    FOREIGN KEY (RECENT_PROJECT_ID) REFERENCES PROJECTS(ID)
);
INSERT INTO "USERS_SETTINGS" VALUES(1,1,2,10,25,5);
INSERT INTO "USERS_SETTINGS" VALUES(2,2,2,10,25,5);
INSERT INTO "USERS_SETTINGS" VALUES(3,3,2,10,25,5);
CREATE TABLE USER_ROLES_IN_PROJECT (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    ROLE TEXT,
    COLOR TEXT,
    PRIVILIGES INTEGER /* 0 - cannot edit project preferences, 1 - can edit project preferences */
);
INSERT INTO "USER_ROLES_IN_PROJECT" VALUES(1,'Project Owner','#3F51B5',1);
INSERT INTO "USER_ROLES_IN_PROJECT" VALUES(2,'Tester','#F44336',0);
INSERT INTO "USER_ROLES_IN_PROJECT" VALUES(3,'Programmer','#8BC34A',0);
INSERT INTO "USER_ROLES_IN_PROJECT" VALUES(4,'Analyst','#FFC107',0);
CREATE TABLE USERS_PROJECTS (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    USER_ID INTEGER,
    PROJECT_ID INTEGER,
    USER_ROLE_ID INTEGER,
    FOREIGN KEY (USER_ID) REFERENCES USERS(ID)
    FOREIGN KEY (PROJECT_ID) REFERENCES PROJECTS(ID)
    FOREIGN KEY (USER_ROLE_ID) REFERENCES USER_ROLES_IN_PROJECT(ID)
);
INSERT INTO "USERS_PROJECTS" VALUES(1,1,1,1);
INSERT INTO "USERS_PROJECTS" VALUES(2,1,2,1);
INSERT INTO "USERS_PROJECTS" VALUES(3,3,2,3);
INSERT INTO "USERS_PROJECTS" VALUES(5,2,2,3);
INSERT INTO "USERS_PROJECTS" VALUES(6,2,2,2);
INSERT INTO "USERS_PROJECTS" VALUES(7,3,2,2);
INSERT INTO "USERS_PROJECTS" VALUES(8,1,3,1);
CREATE TABLE TASK_STATUSES(
	ID INTEGER PRIMARY KEY AUTOINCREMENT,
	NAME TEXT,
	STAYS_IN_SPRINT INTEGER, /* 0 - when sprint ends, goes to another one, 1 - stays in sprint on sprint end */
	PROJECT_ID INTEGER,
	FOREIGN KEY(PROJECT_ID) REFERENCES PROJECTS(ID)
);
INSERT INTO "TASK_STATUSES" VALUES(1,'To do',0,1);
INSERT INTO "TASK_STATUSES" VALUES(2,'In progress',0,1);
INSERT INTO "TASK_STATUSES" VALUES(3,'Done',1,1);
INSERT INTO "TASK_STATUSES" VALUES(4,'To do',0,2);
INSERT INTO "TASK_STATUSES" VALUES(5,'In progress',0,2);
INSERT INTO "TASK_STATUSES" VALUES(6,'Awaiting tests',0,2);
INSERT INTO "TASK_STATUSES" VALUES(7,'Testing',0,2);
INSERT INTO "TASK_STATUSES" VALUES(8,'Done',1,2);
INSERT INTO "TASK_STATUSES" VALUES(9,'To do',0,3);
INSERT INTO "TASK_STATUSES" VALUES(10,'In progress',0,3);
INSERT INTO "TASK_STATUSES" VALUES(11,'Done',1,3);
CREATE TABLE TASKS (
	ID INTEGER PRIMARY KEY AUTOINCREMENT,
	NAME TEXT,
	DESCRIPTION TEXT,
	COLOR TEXT,
	ASSIGNEE INTEGER,
	TASK_STATUS_ID INTEGER,
	ESTIMATED_TIME INTEGER,
	PROJECT_ID INTEGER,
    USER_STORY_ID INTEGER,
    SPRINT_ID INTEGER,
	FOREIGN KEY(ASSIGNEE) REFERENCES USERS(ID),
	FOREIGN KEY(PROJECT_ID) REFERENCES PROJECTS(ID)
	FOREIGN KEY(TASK_STATUS_ID) REFERENCES TASK_STATUSES(ID),
    FOREIGN KEY(USER_STORY_ID) REFERENCES USER_STORIES(ID),
    FOREIGN KEY(SPRINT_ID) REFERENCES SPRINTS(ID)
);
INSERT INTO "TASKS" VALUES(1,'Łączenie słówników','Łączenie słowników EN<->Simple','#9eff00',3,8,2,2,2,2);
INSERT INTO "TASKS" VALUES(2,'Wyznaczanie odległości cos','Jak wyżej.<br />Instrukcja jak zrobić tutaj:<br /><a href="https://janav.wordpress.com/2013/10/27/tf-idf-and-cosine-similarity/">https://janav.wordpress.com/2013/10/27/tf-idf-and-cosine-similarity/</a>','#ffd600',3,8,1,2,2,2);
INSERT INTO "TASKS" VALUES(3,'Wyznaczanie kategorii','Jw. Na podstawie cosinusów','#008cff',2,8,3,2,2,2);
INSERT INTO "TASKS" VALUES(6,'Implementacja Bayesa - dane tekstowe','Jw.','#ff4b12',3,4,10,2,3,2);
INSERT INTO "TASKS" VALUES(7,'Implementacja Bayesa - dane numeryczne','Jw.','#00fff0',2,4,5,2,3,2);
INSERT INTO "TASKS" VALUES(8,'Projekt interfejsu graficznego','JW','#fff500',2,5,5,2,4,2);
INSERT INTO "TASKS" VALUES(9,'Implementacja projektu graficznego','Jw. Java Swing','#eb00ff',3,4,5,2,4,2);
CREATE TABLE ISSUES (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    NAME TEXT,
    DESCRIPTION TEXT,
    STATUS_ID INTEGER,
    ASSIGNEE_ID INTEGER,
    PRIORITY INTEGER,
    TASK_ID INTEGER,
    PROJECT_ID INTEGER,
    FOREIGN KEY(STATUS_ID) REFERENCES TASK_STATUSES(ID),
    FOREIGN KEY(ASSIGNEE_ID) REFERENCES USERS(ID),
    FOREIGN KEY(TASK_ID) REFERENCES TASKS(ID),
    FOREIGN KEY(PROJECT_ID) REFERENCES PROJECTS(ID)
);
INSERT INTO "ISSUES" VALUES(1,'Błędny wynik cosinusa','Poprawić:<br />Zamiast <b>0.431233</b><br />Wyświetla <b>0.45665</b>',8,3,1,2,2);
DELETE FROM sqlite_sequence;
INSERT INTO "sqlite_sequence" VALUES('USERS',3);
INSERT INTO "sqlite_sequence" VALUES('USERS_SECURITY',3);
INSERT INTO "sqlite_sequence" VALUES('USERS_SETTINGS',3);
INSERT INTO "sqlite_sequence" VALUES('USER_ROLES_IN_PROJECT',4);
INSERT INTO "sqlite_sequence" VALUES('USER_STORY_STATUS',5);
INSERT INTO "sqlite_sequence" VALUES('PROJECTS',3);
INSERT INTO "sqlite_sequence" VALUES('TASK_STATUSES',11);
INSERT INTO "sqlite_sequence" VALUES('USERS_PROJECTS',8);
INSERT INTO "sqlite_sequence" VALUES('SPRINTS',6);
INSERT INTO "sqlite_sequence" VALUES('USER_STORIES',4);
INSERT INTO "sqlite_sequence" VALUES('TASKS',9);
INSERT INTO "sqlite_sequence" VALUES('ISSUES',1);
COMMIT;
