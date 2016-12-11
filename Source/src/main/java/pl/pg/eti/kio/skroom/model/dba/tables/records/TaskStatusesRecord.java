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

import pl.pg.eti.kio.skroom.model.dba.tables.TaskStatuses;


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
public class TaskStatusesRecord extends UpdatableRecordImpl<TaskStatusesRecord> implements Record4<Integer, String, Integer, Integer> {

    private static final long serialVersionUID = 1594911145;

    /**
     * Setter for <code>TASK_STATUSES.ID</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>TASK_STATUSES.ID</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>TASK_STATUSES.NAME</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>TASK_STATUSES.NAME</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>TASK_STATUSES.STAYS_IN_SPRINT</code>.
     */
    public void setStaysInSprint(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>TASK_STATUSES.STAYS_IN_SPRINT</code>.
     */
    public Integer getStaysInSprint() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>TASK_STATUSES.PROJECT_ID</code>.
     */
    public void setProjectId(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>TASK_STATUSES.PROJECT_ID</code>.
     */
    public Integer getProjectId() {
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
    public Row4<Integer, String, Integer, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, String, Integer, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return TaskStatuses.TASK_STATUSES.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return TaskStatuses.TASK_STATUSES.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return TaskStatuses.TASK_STATUSES.STAYS_IN_SPRINT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return TaskStatuses.TASK_STATUSES.PROJECT_ID;
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
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getStaysInSprint();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getProjectId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskStatusesRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskStatusesRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskStatusesRecord value3(Integer value) {
        setStaysInSprint(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskStatusesRecord value4(Integer value) {
        setProjectId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskStatusesRecord values(Integer value1, String value2, Integer value3, Integer value4) {
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
     * Create a detached TaskStatusesRecord
     */
    public TaskStatusesRecord() {
        super(TaskStatuses.TASK_STATUSES);
    }

    /**
     * Create a detached, initialised TaskStatusesRecord
     */
    public TaskStatusesRecord(Integer id, String name, Integer staysInSprint, Integer projectId) {
        super(TaskStatuses.TASK_STATUSES);

        set(0, id);
        set(1, name);
        set(2, staysInSprint);
        set(3, projectId);
    }
}