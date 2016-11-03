/**
 * This class is generated by jOOQ
 */
package pl.pg.eti.kio.skroom.model.dba.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;

import pl.pg.eti.kio.skroom.model.dba.tables.UsersSecurity;


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
public class UsersSecurityRecord extends UpdatableRecordImpl<UsersSecurityRecord> implements Record7<Integer, Integer, String, String, String, String, Integer> {

    private static final long serialVersionUID = -17492004;

    /**
     * Setter for <code>USERS_SECURITY.ID</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>USERS_SECURITY.ID</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>USERS_SECURITY.USER_ID</code>.
     */
    public void setUserId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>USERS_SECURITY.USER_ID</code>.
     */
    public Integer getUserId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>USERS_SECURITY.PASSWORD</code>.
     */
    public void setPassword(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>USERS_SECURITY.PASSWORD</code>.
     */
    public String getPassword() {
        return (String) get(2);
    }

    /**
     * Setter for <code>USERS_SECURITY.SALT</code>.
     */
    public void setSalt(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>USERS_SECURITY.SALT</code>.
     */
    public String getSalt() {
        return (String) get(3);
    }

    /**
     * Setter for <code>USERS_SECURITY.SECURE_QUESTION</code>.
     */
    public void setSecureQuestion(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>USERS_SECURITY.SECURE_QUESTION</code>.
     */
    public String getSecureQuestion() {
        return (String) get(4);
    }

    /**
     * Setter for <code>USERS_SECURITY.SECURE_ANSWER</code>.
     */
    public void setSecureAnswer(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>USERS_SECURITY.SECURE_ANSWER</code>.
     */
    public String getSecureAnswer() {
        return (String) get(5);
    }

    /**
     * Setter for <code>USERS_SECURITY.ACCEPTED</code>.
     */
    public void setAccepted(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>USERS_SECURITY.ACCEPTED</code>.
     */
    public Integer getAccepted() {
        return (Integer) get(6);
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
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, Integer, String, String, String, String, Integer> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, Integer, String, String, String, String, Integer> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return UsersSecurity.USERS_SECURITY.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return UsersSecurity.USERS_SECURITY.USER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return UsersSecurity.USERS_SECURITY.PASSWORD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return UsersSecurity.USERS_SECURITY.SALT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return UsersSecurity.USERS_SECURITY.SECURE_QUESTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return UsersSecurity.USERS_SECURITY.SECURE_ANSWER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return UsersSecurity.USERS_SECURITY.ACCEPTED;
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
    public String value3() {
        return getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getSalt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getSecureQuestion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getSecureAnswer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getAccepted();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersSecurityRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersSecurityRecord value2(Integer value) {
        setUserId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersSecurityRecord value3(String value) {
        setPassword(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersSecurityRecord value4(String value) {
        setSalt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersSecurityRecord value5(String value) {
        setSecureQuestion(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersSecurityRecord value6(String value) {
        setSecureAnswer(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersSecurityRecord value7(Integer value) {
        setAccepted(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersSecurityRecord values(Integer value1, Integer value2, String value3, String value4, String value5, String value6, Integer value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UsersSecurityRecord
     */
    public UsersSecurityRecord() {
        super(UsersSecurity.USERS_SECURITY);
    }

    /**
     * Create a detached, initialised UsersSecurityRecord
     */
    public UsersSecurityRecord(Integer id, Integer userId, String password, String salt, String secureQuestion, String secureAnswer, Integer accepted) {
        super(UsersSecurity.USERS_SECURITY);

        set(0, id);
        set(1, userId);
        set(2, password);
        set(3, salt);
        set(4, secureQuestion);
        set(5, secureAnswer);
        set(6, accepted);
    }
}
