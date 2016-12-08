INSERT INTO PROJECTS VALUES (
	NULL, /* autoincremented value */
	"Empty project",
	"Lorem ipsum dolor sit amet,<br />consectetur adipiscing elit. Aliquam at porttitor sem. Aliquam erat<br />volutpat. Donec placerat nisl magna, et faucibus arcu condimentum sed.",
	1
);


INSERT INTO TASK_STATUSES VALUES (
	NULL,
	"To do",
	0,
	1
);

INSERT INTO TASK_STATUSES VALUES (
	NULL,
	"In progress",
	0,
	1
);

INSERT INTO TASK_STATUSES VALUES (
	NULL,
	"Done",
	1,
	1
);

INSERT INTO USERS_PROJECTS VALUES(
    NULL,
    1,
    1,
    1
);

INSERT INTO SPRINTS VALUES(
	NULL,
	"Sprint 1",
	datetime('now'),
	datetime('now', '+7 day'),
	1
);

UPDATE USERS_SETTINGS SET RECENT_PROJECT_ID=1 WHERE USER_ID=1;

INSERT INTO USER_STORIES VALUES (
	NULL, /* autoincremented value */
	"Test User Story",
	"<user>",
	"<some goal>",
	"<some reason>",
    "Some text",
	1,
	20,
	1,
	1
);
