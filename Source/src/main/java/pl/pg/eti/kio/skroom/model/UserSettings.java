package pl.pg.eti.kio.skroom.model;

import org.jooq.DSLContext;
import pl.pg.eti.kio.skroom.model.dba.Tables;
import pl.pg.eti.kio.skroom.model.dba.tables.records.ProjectsRecord;
import pl.pg.eti.kio.skroom.model.dba.tables.records.UsersSettingsRecord;

import java.sql.Connection;

/**
 * @author Wojciech Stanisławski
 * @since 14.11.16
 */
public class UserSettings {

	private int id;
	private Project recentProject;

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

	/**
	 * Method for converting database records into model classes.
	 *
	 * @param record Database record fetched by jOOQ
	 * @return Converted user
	 */
	public static UserSettings fromDba(UsersSettingsRecord record, DSLContext query) {
		UserSettings settings = new UserSettings();

		settings.setId(record.getId());

		if(record.getRecentProjectId().intValue() != -1) {
			ProjectsRecord projectRecord = query.selectFrom(Tables.PROJECTS).where(Tables.PROJECTS.ID.eq(record.getRecentProjectId().intValue())).fetchOne();
			Project project = Project.fromDba(projectRecord);
			settings.setRecentProject(project);
		}

		return settings;
	}
}
