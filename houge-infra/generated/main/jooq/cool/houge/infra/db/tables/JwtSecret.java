/*
 * This file is generated by jOOQ.
 */
package cool.houge.infra.db.tables;


import cool.houge.infra.db.Public;
import cool.houge.infra.db.tables.records.JwtSecretRecord;

import java.time.LocalDateTime;

import javax.annotation.Nonnull;
import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * JWT 密钥
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.15.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JwtSecret extends TableImpl<JwtSecretRecord> {

    /**
     * The reference instance of <code>public.t_jwt_secret</code>
     */
    public static final JwtSecret JWT_SECRET = new JwtSecret();

    /**
     * The class holding records for this type
     */
    @Override
    @Nonnull
    public Class<JwtSecretRecord> getRecordType() {
        return JwtSecretRecord.class;
    }

    /**
     * The column <code>public.t_jwt_secret.id</code>. kid 标识仅支持2个字符
     */
    public final TableField<JwtSecretRecord, String> ID = createField(DSL.name("id"), SQLDataType.VARCHAR(8).nullable(false), this, "kid 标识仅支持2个字符");

    /**
     * The column <code>public.t_jwt_secret.algorithm</code>. JWT 签名算法名称
     * 当前支持 HMAC 家族的加密算法
     */
    public final TableField<JwtSecretRecord, String> ALGORITHM = createField(DSL.name("algorithm"), SQLDataType.VARCHAR(16).nullable(false), this, "JWT 签名算法名称\n当前支持 HMAC 家族的加密算法");

    /**
     * The column <code>public.t_jwt_secret.secret_key</code>. 密钥
     */
    public final TableField<JwtSecretRecord, byte[]> SECRET_KEY = createField(DSL.name("secret_key"), SQLDataType.BLOB.nullable(false), this, "密钥");

    /**
     * The column <code>public.t_jwt_secret.deleted</code>. 删除数据的时间戳（秒），值不为 0
     * 时，表示该行数据已被软删除
     */
    public final TableField<JwtSecretRecord, Integer> DELETED = createField(DSL.name("deleted"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.field("0", SQLDataType.INTEGER)), this, "删除数据的时间戳（秒），值不为 0 时，表示该行数据已被软删除");

    /**
     * The column <code>public.t_jwt_secret.create_time</code>. 创建时间
     */
    public final TableField<JwtSecretRecord, LocalDateTime> CREATE_TIME = createField(DSL.name("create_time"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "创建时间");

    /**
     * The column <code>public.t_jwt_secret.update_time</code>. 修改时间
     */
    public final TableField<JwtSecretRecord, LocalDateTime> UPDATE_TIME = createField(DSL.name("update_time"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "修改时间");

    private JwtSecret(Name alias, Table<JwtSecretRecord> aliased) {
        this(alias, aliased, null);
    }

    private JwtSecret(Name alias, Table<JwtSecretRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("JWT 密钥"), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.t_jwt_secret</code> table reference
     */
    public JwtSecret(String alias) {
        this(DSL.name(alias), JWT_SECRET);
    }

    /**
     * Create an aliased <code>public.t_jwt_secret</code> table reference
     */
    public JwtSecret(Name alias) {
        this(alias, JWT_SECRET);
    }

    /**
     * Create a <code>public.t_jwt_secret</code> table reference
     */
    public JwtSecret() {
        this(DSL.name("t_jwt_secret"), null);
    }

    public <O extends Record> JwtSecret(Table<O> child, ForeignKey<O, JwtSecretRecord> key) {
        super(child, key, JWT_SECRET);
    }

    @Override
    @Nonnull
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    @Nonnull
    public JwtSecret as(String alias) {
        return new JwtSecret(DSL.name(alias), this);
    }

    @Override
    @Nonnull
    public JwtSecret as(Name alias) {
        return new JwtSecret(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    @Nonnull
    public JwtSecret rename(String name) {
        return new JwtSecret(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    @Nonnull
    public JwtSecret rename(Name name) {
        return new JwtSecret(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    @Nonnull
    public Row6<String, String, byte[], Integer, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}