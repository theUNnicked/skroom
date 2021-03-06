/**
 * This class is generated by jOOQ
 */
package pl.pg.eti.kio.skroom.model.dba.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;

import pl.pg.eti.kio.skroom.model.dba.tables.UsersProjects;


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
public class UsersProjectsRecord extends UpdatableRecordImpl<UsersProjectsRecord> implements Record4<Integer, Integer, Integer, Integer> {

    private static final long serialVersionUID = -259051389;

    /**
     * Setter for <code>USERS_PROJECTS.ID</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>USERS_PROJECTS.ID</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>USERS_PROJECTS.USER_ID</code>.
     */
    public void setUserId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>USERS_PROJECTS.USER_ID</code>.
     */
    public Integer getUserId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>USERS_PROJECTS.PROJECT_ID</code>.
     */
    public void setProjectId(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>USERS_PROJECTS.PROJECT_ID</code>.
     */
    public Integer getProjectId() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>USERS_PROJECTS.USER_ROLE_ID</code>.
     */
    public void setUserRoleId(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>USERS_PROJECTS.USER_ROLE_ID</code>.
     */
    public Integer getUserRoleId() {
        return (Integer) get(3);
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
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Integer, Integer, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Integer, Integer, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return UsersProjects.USERS_PROJECTS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return UsersProjects.USERS_PROJECTS.USER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return UsersProjects.USERS_PROJECTS.PROJECT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return UsersProjects.USERS_PROJECTS.USER_ROLE_ID;
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
        return getProjectId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getUserRoleId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersProjectsRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersProjectsRecord value2(Integer value) {
        setUserId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersProjectsRecord value3(Integer value) {
        setProjectId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersProjectsRecord value4(Integer value) {
        setUserRoleId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersProjectsRecord values(Integer value1, Integer value2, Integer value3, Integer value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UsersProjectsRecord
     */
    public UsersProjectsRecord() {
        super(UsersProjects.USERS_PROJECTS);
    }

    /**
     * Create a detached, initialised UsersProjectsRecord
     */
    public UsersProjectsRecord(Integer id, Integer userId, Integer projectId, Integer userRoleId) {
        super(UsersProjects.USERS_PROJECTS);

        set(0, id);
        set(1, userId);
        set(2, projectId);
        set(3, userRoleId);
    }
}
