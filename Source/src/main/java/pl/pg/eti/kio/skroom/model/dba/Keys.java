/**
 * This class is generated by jOOQ
 */
package pl.pg.eti.kio.skroom.model.dba;


import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;

import pl.pg.eti.kio.skroom.model.dba.tables.Projects;
import pl.pg.eti.kio.skroom.model.dba.tables.Tasks;
import pl.pg.eti.kio.skroom.model.dba.tables.UserRolesInProject;
import pl.pg.eti.kio.skroom.model.dba.tables.UserStories;
import pl.pg.eti.kio.skroom.model.dba.tables.Users;
import pl.pg.eti.kio.skroom.model.dba.tables.UsersProjects;
import pl.pg.eti.kio.skroom.model.dba.tables.UsersSecurity;
import pl.pg.eti.kio.skroom.model.dba.tables.UsersSettings;
import pl.pg.eti.kio.skroom.model.dba.tables.records.ProjectsRecord;
import pl.pg.eti.kio.skroom.model.dba.tables.records.TasksRecord;
import pl.pg.eti.kio.skroom.model.dba.tables.records.UserRolesInProjectRecord;
import pl.pg.eti.kio.skroom.model.dba.tables.records.UserStoriesRecord;
import pl.pg.eti.kio.skroom.model.dba.tables.records.UsersProjectsRecord;
import pl.pg.eti.kio.skroom.model.dba.tables.records.UsersRecord;
import pl.pg.eti.kio.skroom.model.dba.tables.records.UsersSecurityRecord;
import pl.pg.eti.kio.skroom.model.dba.tables.records.UsersSettingsRecord;


/**
 * A class modelling foreign key relationships between tables of the <code></code> 
 * schema
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<ProjectsRecord, Integer> IDENTITY_PROJECTS = Identities0.IDENTITY_PROJECTS;
    public static final Identity<UsersRecord, Integer> IDENTITY_USERS = Identities0.IDENTITY_USERS;
    public static final Identity<UsersProjectsRecord, Integer> IDENTITY_USERS_PROJECTS = Identities0.IDENTITY_USERS_PROJECTS;
    public static final Identity<UsersSecurityRecord, Integer> IDENTITY_USERS_SECURITY = Identities0.IDENTITY_USERS_SECURITY;
    public static final Identity<UsersSettingsRecord, Integer> IDENTITY_USERS_SETTINGS = Identities0.IDENTITY_USERS_SETTINGS;
    public static final Identity<UserRolesInProjectRecord, Integer> IDENTITY_USER_ROLES_IN_PROJECT = Identities0.IDENTITY_USER_ROLES_IN_PROJECT;
    public static final Identity<UserStoriesRecord, Integer> IDENTITY_USER_STORIES = Identities0.IDENTITY_USER_STORIES;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<ProjectsRecord> PK_PROJECTS = UniqueKeys0.PK_PROJECTS;
    public static final UniqueKey<TasksRecord> PK_TASKS = UniqueKeys0.PK_TASKS;
    public static final UniqueKey<UsersRecord> PK_USERS = UniqueKeys0.PK_USERS;
    public static final UniqueKey<UsersProjectsRecord> PK_USERS_PROJECTS = UniqueKeys0.PK_USERS_PROJECTS;
    public static final UniqueKey<UsersSecurityRecord> PK_USERS_SECURITY = UniqueKeys0.PK_USERS_SECURITY;
    public static final UniqueKey<UsersSettingsRecord> PK_USERS_SETTINGS = UniqueKeys0.PK_USERS_SETTINGS;
    public static final UniqueKey<UserRolesInProjectRecord> PK_USER_ROLES_IN_PROJECT = UniqueKeys0.PK_USER_ROLES_IN_PROJECT;
    public static final UniqueKey<UserStoriesRecord> PK_USER_STORIES = UniqueKeys0.PK_USER_STORIES;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<TasksRecord, UsersRecord> FK_TASKS_USERS_1 = ForeignKeys0.FK_TASKS_USERS_1;
    public static final ForeignKey<TasksRecord, ProjectsRecord> FK_TASKS_PROJECTS_1 = ForeignKeys0.FK_TASKS_PROJECTS_1;
    public static final ForeignKey<UsersProjectsRecord, UsersRecord> FK_USERS_PROJECTS_USERS_1 = ForeignKeys0.FK_USERS_PROJECTS_USERS_1;
    public static final ForeignKey<UsersProjectsRecord, ProjectsRecord> FK_USERS_PROJECTS_PROJECTS_1 = ForeignKeys0.FK_USERS_PROJECTS_PROJECTS_1;
    public static final ForeignKey<UsersProjectsRecord, UserRolesInProjectRecord> FK_USERS_PROJECTS_USER_ROLES_IN_PROJECT_1 = ForeignKeys0.FK_USERS_PROJECTS_USER_ROLES_IN_PROJECT_1;
    public static final ForeignKey<UsersSecurityRecord, UsersRecord> FK_USERS_SECURITY_USERS_1 = ForeignKeys0.FK_USERS_SECURITY_USERS_1;
    public static final ForeignKey<UsersSettingsRecord, UsersRecord> FK_USERS_SETTINGS_USERS_1 = ForeignKeys0.FK_USERS_SETTINGS_USERS_1;
    public static final ForeignKey<UsersSettingsRecord, ProjectsRecord> FK_USERS_SETTINGS_PROJECTS_1 = ForeignKeys0.FK_USERS_SETTINGS_PROJECTS_1;
    public static final ForeignKey<UserStoriesRecord, ProjectsRecord> FK_USER_STORIES_PROJECTS_1 = ForeignKeys0.FK_USER_STORIES_PROJECTS_1;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 extends AbstractKeys {
        public static Identity<ProjectsRecord, Integer> IDENTITY_PROJECTS = createIdentity(Projects.PROJECTS, Projects.PROJECTS.ID);
        public static Identity<UsersRecord, Integer> IDENTITY_USERS = createIdentity(Users.USERS, Users.USERS.ID);
        public static Identity<UsersProjectsRecord, Integer> IDENTITY_USERS_PROJECTS = createIdentity(UsersProjects.USERS_PROJECTS, UsersProjects.USERS_PROJECTS.ID);
        public static Identity<UsersSecurityRecord, Integer> IDENTITY_USERS_SECURITY = createIdentity(UsersSecurity.USERS_SECURITY, UsersSecurity.USERS_SECURITY.ID);
        public static Identity<UsersSettingsRecord, Integer> IDENTITY_USERS_SETTINGS = createIdentity(UsersSettings.USERS_SETTINGS, UsersSettings.USERS_SETTINGS.ID);
        public static Identity<UserRolesInProjectRecord, Integer> IDENTITY_USER_ROLES_IN_PROJECT = createIdentity(UserRolesInProject.USER_ROLES_IN_PROJECT, UserRolesInProject.USER_ROLES_IN_PROJECT.ID);
        public static Identity<UserStoriesRecord, Integer> IDENTITY_USER_STORIES = createIdentity(UserStories.USER_STORIES, UserStories.USER_STORIES.ID);
    }

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<ProjectsRecord> PK_PROJECTS = createUniqueKey(Projects.PROJECTS, "pk_PROJECTS", Projects.PROJECTS.ID);
        public static final UniqueKey<TasksRecord> PK_TASKS = createUniqueKey(Tasks.TASKS, "pk_TASKS", Tasks.TASKS.ID);
        public static final UniqueKey<UsersRecord> PK_USERS = createUniqueKey(Users.USERS, "pk_USERS", Users.USERS.ID);
        public static final UniqueKey<UsersProjectsRecord> PK_USERS_PROJECTS = createUniqueKey(UsersProjects.USERS_PROJECTS, "pk_USERS_PROJECTS", UsersProjects.USERS_PROJECTS.ID);
        public static final UniqueKey<UsersSecurityRecord> PK_USERS_SECURITY = createUniqueKey(UsersSecurity.USERS_SECURITY, "pk_USERS_SECURITY", UsersSecurity.USERS_SECURITY.ID);
        public static final UniqueKey<UsersSettingsRecord> PK_USERS_SETTINGS = createUniqueKey(UsersSettings.USERS_SETTINGS, "pk_USERS_SETTINGS", UsersSettings.USERS_SETTINGS.ID);
        public static final UniqueKey<UserRolesInProjectRecord> PK_USER_ROLES_IN_PROJECT = createUniqueKey(UserRolesInProject.USER_ROLES_IN_PROJECT, "pk_USER_ROLES_IN_PROJECT", UserRolesInProject.USER_ROLES_IN_PROJECT.ID);
        public static final UniqueKey<UserStoriesRecord> PK_USER_STORIES = createUniqueKey(UserStories.USER_STORIES, "pk_USER_STORIES", UserStories.USER_STORIES.ID);
    }

    private static class ForeignKeys0 extends AbstractKeys {
        public static final ForeignKey<TasksRecord, UsersRecord> FK_TASKS_USERS_1 = createForeignKey(pl.pg.eti.kio.skroom.model.dba.Keys.PK_USERS, Tasks.TASKS, "fk_TASKS_USERS_1", Tasks.TASKS.ASSIGNEE);
        public static final ForeignKey<TasksRecord, ProjectsRecord> FK_TASKS_PROJECTS_1 = createForeignKey(pl.pg.eti.kio.skroom.model.dba.Keys.PK_PROJECTS, Tasks.TASKS, "fk_TASKS_PROJECTS_1", Tasks.TASKS.PROJECT_ID);
        public static final ForeignKey<UsersProjectsRecord, UsersRecord> FK_USERS_PROJECTS_USERS_1 = createForeignKey(pl.pg.eti.kio.skroom.model.dba.Keys.PK_USERS, UsersProjects.USERS_PROJECTS, "fk_USERS_PROJECTS_USERS_1", UsersProjects.USERS_PROJECTS.USER_ID);
        public static final ForeignKey<UsersProjectsRecord, ProjectsRecord> FK_USERS_PROJECTS_PROJECTS_1 = createForeignKey(pl.pg.eti.kio.skroom.model.dba.Keys.PK_PROJECTS, UsersProjects.USERS_PROJECTS, "fk_USERS_PROJECTS_PROJECTS_1", UsersProjects.USERS_PROJECTS.PROJECT_ID);
        public static final ForeignKey<UsersProjectsRecord, UserRolesInProjectRecord> FK_USERS_PROJECTS_USER_ROLES_IN_PROJECT_1 = createForeignKey(pl.pg.eti.kio.skroom.model.dba.Keys.PK_USER_ROLES_IN_PROJECT, UsersProjects.USERS_PROJECTS, "fk_USERS_PROJECTS_USER_ROLES_IN_PROJECT_1", UsersProjects.USERS_PROJECTS.USER_ROLE_ID);
        public static final ForeignKey<UsersSecurityRecord, UsersRecord> FK_USERS_SECURITY_USERS_1 = createForeignKey(pl.pg.eti.kio.skroom.model.dba.Keys.PK_USERS, UsersSecurity.USERS_SECURITY, "fk_USERS_SECURITY_USERS_1", UsersSecurity.USERS_SECURITY.USER_ID);
        public static final ForeignKey<UsersSettingsRecord, UsersRecord> FK_USERS_SETTINGS_USERS_1 = createForeignKey(pl.pg.eti.kio.skroom.model.dba.Keys.PK_USERS, UsersSettings.USERS_SETTINGS, "fk_USERS_SETTINGS_USERS_1", UsersSettings.USERS_SETTINGS.USER_ID);
        public static final ForeignKey<UsersSettingsRecord, ProjectsRecord> FK_USERS_SETTINGS_PROJECTS_1 = createForeignKey(pl.pg.eti.kio.skroom.model.dba.Keys.PK_PROJECTS, UsersSettings.USERS_SETTINGS, "fk_USERS_SETTINGS_PROJECTS_1", UsersSettings.USERS_SETTINGS.RECENT_PROJECT_ID);
        public static final ForeignKey<UserStoriesRecord, ProjectsRecord> FK_USER_STORIES_PROJECTS_1 = createForeignKey(pl.pg.eti.kio.skroom.model.dba.Keys.PK_PROJECTS, UserStories.USER_STORIES, "fk_USER_STORIES_PROJECTS_1", UserStories.USER_STORIES.PROJECT_ID);
    }
}
