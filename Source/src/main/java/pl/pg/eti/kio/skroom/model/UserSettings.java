package pl.pg.eti.kio.skroom.model;

import org.jooq.DSLContext;

import pl.pg.eti.kio.skroom.model.dba.Tables;
import pl.pg.eti.kio.skroom.model.dba.tables.records.ProjectsRecord;
import pl.pg.eti.kio.skroom.model.dba.tables.records.UsersSettingsRecord;

/**
 * User settings model for use in the application. Stored in session.
 *
 * @author Wojciech Stanisławski
 * @since 14.11.16
 */
public class UserSettings {

	private int id;
	private Project recentProject;
	private int userStoriesPerPage;
	private int tasksPerPage;
	private int usersPerPage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Project getRecentProject() {
		return recentProject;
	}

	public void setRecentProject(Project recentProject) {
		this.recentProject = recentProject;
	}

	public int getUserStoriesPerPage() {
		return userStoriesPerPage;
	}

	public void setUserStoriesPerPage(int userStoriesPerPage) {
		this.userStoriesPerPage = userStoriesPerPage;
	}

	public int getTasksPerPage() {
		return tasksPerPage;
	}

	public void setTasksPerPage(int tasksPerPage) {
		this.tasksPerPage = tasksPerPage;
	}

	/**
	 * Method for converting database records into model classes.
	 *
	 * @param record	Database record fetched by jOOQ
	 * @return			Converted user
	 */
	public static UserSettings fromDba(UsersSettingsRecord record, DSLContext query) {
		if(record == null) {
			return null;
		}

		UserSettings settings = new UserSettings();

		settings.setId(record.getId());
		settings.setUserStoriesPerPage(record.getUserStoriesPerPage());
		settings.setTasksPerPage(record.getTasksPerPage());
		settings.setUsersPerPage(record.getUsersPerPage());

		if(record.getRecentProjectId() != null && record.getRecentProjectId().intValue() != -1) {
			ProjectsRecord projectRecord = query.selectFrom(Tables.PROJECTS).where(Tables.PROJECTS.ID.eq(record.getRecentProjectId().intValue())).fetchOne();
			Project project = Project.fromDba(projectRecord);
			settings.setRecentProject(project);
		}

		return settings;
	}

	@Override
	public String toString() {
		return "UserSettings{" +
				"id=" + id +
				", recentProject=" + recentProject +
				", userStoriesPerPage=" + userStoriesPerPage +
				", tasksPerPage=" + tasksPerPage +
				", usersPerPage=" + usersPerPage +
				'}';
	}

	public int getUsersPerPage() {
		return usersPerPage;
	}

	public void setUsersPerPage(int usersPerPage) {
		this.usersPerPage = usersPerPage;
	}
}
