/**
 * This class is generated by jOOQ
 */
package pl.pg.eti.kio.skroom.model.dba.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;

import pl.pg.eti.kio.skroom.model.dba.tables.UsersSettings;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UsersSettingsRecord extends UpdatableRecordImpl<UsersSettingsRecord> implements Record6<Integer, Integer, Integer, Integer, Integer, Integer> {

    private static final long serialVersionUID = 2142276931;

    /**
     * Setter for <code>USERS_SETTINGS.ID</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>USERS_SETTINGS.ID</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>USERS_SETTINGS.USER_ID</code>.
     */
    public void setUserId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>USERS_SETTINGS.USER_ID</code>.
     */
    public Integer getUserId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>USERS_SETTINGS.RECENT_PROJECT_ID</code>.
     */
    public void setRecentProjectId(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>USERS_SETTINGS.RECENT_PROJECT_ID</code>.
     */
    public Integer getRecentProjectId() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>USERS_SETTINGS.USER_STORIES_PER_PAGE</code>.
     */
    public void setUserStoriesPerPage(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>USERS_SETTINGS.USER_STORIES_PER_PAGE</code>.
     */
    public Integer getUserStoriesPerPage() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>USERS_SETTINGS.TASKS_PER_PAGE</code>.
     */
    public void setTasksPerPage(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>USERS_SETTINGS.TASKS_PER_PAGE</code>.
     */
    public Integer getTasksPerPage() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>USERS_SETTINGS.USERS_PER_PAGE</code>.
     */
    public void setUsersPerPage(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>USERS_SETTINGS.USERS_PER_PAGE</code>.
     */
    public Integer getUsersPerPage() {
        return (Integer) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Integer, Integer, Integer, Integer, Integer, Integer> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Integer, Integer, Integer, Integer, Integer, Integer> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return UsersSettings.USERS_SETTINGS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return UsersSettings.USERS_SETTINGS.USER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return UsersSettings.USERS_SETTINGS.RECENT_PROJECT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return UsersSettings.USERS_SETTINGS.USER_STORIES_PER_PAGE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return UsersSettings.USERS_SETTINGS.TASKS_PER_PAGE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return UsersSettings.USERS_SETTINGS.USERS_PER_PAGE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getUserId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getRecentProjectId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getUserStoriesPerPage();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getTasksPerPage();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getUsersPerPage();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersSettingsRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersSettingsRecord value2(Integer value) {
        setUserId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersSettingsRecord value3(Integer value) {
        setRecentProjectId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersSettingsRecord value4(Integer value) {
        setUserStoriesPerPage(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersSettingsRecord value5(Integer value) {
        setTasksPerPage(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersSettingsRecord value6(Integer value) {
        setUsersPerPage(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersSettingsRecord values(Integer value1, Integer value2, Integer value3, Integer value4, Integer value5, Integer value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UsersSettingsRecord
     */
    public UsersSettingsRecord() {
        super(UsersSettings.USERS_SETTINGS);
    }

    /**
     * Create a detached, initialised UsersSettingsRecord
     */
    public UsersSettingsRecord(Integer id, Integer userId, Integer recentProjectId, Integer userStoriesPerPage, Integer tasksPerPage, Integer usersPerPage) {
        super(UsersSettings.USERS_SETTINGS);

        set(0, id);
        set(1, userId);
        set(2, recentProjectId);
        set(3, userStoriesPerPage);
        set(4, tasksPerPage);
        set(5, usersPerPage);
    }
}
