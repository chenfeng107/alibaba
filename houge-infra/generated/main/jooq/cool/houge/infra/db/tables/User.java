/*
 * This file is generated by jOOQ.
 */
package cool.houge.infra.db.tables;


import cool.houge.infra.db.Public;
import cool.houge.infra.db.tables.records.UserRecord;

import java.time.LocalDateTime;

import javax.annotation.Nonnull;
import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.15.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class User extends TableImpl<UserRecord> {

    /**
     * The reference instance of <code>public.t_user</code>
     */
    public static final User USER = new User();

    /**
     * The class holding records for this type
     */
    @Override
    @Nonnull
    public Class<UserRecord> getRecordType() {
        return UserRecord.class;
    }

    /**
     * The column <code>public.t_user.id</code>.
     */
    public final TableField<UserRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.t_user.origin_uid</code>. 原用户 ID
     */
    public final TableField<UserRecord, String> ORIGIN_UID = createField(DSL.name("origin_uid"), SQLDataType.VARCHAR(128), this, "原用户 ID");

    /**
     * The column <code>public.t_user.create_time</code>. 创建时间
     */
    public final TableField<UserRecord, LocalDateTime> CREATE_TIME = createField(DSL.name("create_time"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "创建时间");

    /**
     * The column <code>public.t_user.update_time</code>. 更新时间
     */
    public final TableField<UserRecord, LocalDateTime> UPDATE_TIME = createField(DSL.name("update_time"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "更新时间");

    private User(Name alias, Table<UserRecord> aliased) {
        this(alias, aliased, null);
    }

    private User(Name alias, Table<UserRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.t_user</code> table reference
     */
    public User(String alias) {
        this(DSL.name(alias), USER);
    }

    /**
     * Create an aliased <code>public.t_user</code> table reference
     */
    public User(Name alias) {
        this(alias, USER);
    }

    /**
     * Create a <code>public.t_user</code> table reference
     */
    public User() {
        this(DSL.name("t_user"), null);
    }

    public <O extends Record> User(Table<O> child, ForeignKey<O, UserRecord> key) {
        super(child, key, USER);
    }

    @Override
    @Nonnull
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    @Nonnull
    public User as(String alias) {
        return new User(DSL.name(alias), this);
    }

    @Override
    @Nonnull
    public User as(Name alias) {
        return new User(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    @Nonnull
    public User rename(String name) {
        return new User(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    @Nonnull
    public User rename(Name name) {
        return new User(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    @Nonnull
    public Row4<Long, String, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}