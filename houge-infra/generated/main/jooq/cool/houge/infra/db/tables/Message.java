/*
 * This file is generated by jOOQ.
 */
package cool.houge.infra.db.tables;


import cool.houge.infra.db.Public;
import cool.houge.infra.db.tables.records.MessageRecord;

import java.time.LocalDateTime;

import javax.annotation.Nonnull;
import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row11;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * 消息表
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.15.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Message extends TableImpl<MessageRecord> {

    /**
     * The reference instance of <code>public.t_message</code>
     */
    public static final Message MESSAGE = new Message();

    /**
     * The class holding records for this type
     */
    @Override
    @Nonnull
    public Class<MessageRecord> getRecordType() {
        return MessageRecord.class;
    }

    /**
     * The column <code>public.t_message.id</code>. 全局消息 ID
     */
    public final TableField<MessageRecord, String> ID = createField(DSL.name("id"), SQLDataType.CHAR(15).nullable(false), this, "全局消息 ID");

    /**
     * The column <code>public.t_message.sender_id</code>. 发送人 ID
     */
    public final TableField<MessageRecord, Long> SENDER_ID = createField(DSL.name("sender_id"), SQLDataType.BIGINT, this, "发送人 ID");

    /**
     * The column <code>public.t_message.receiver_id</code>. 接收人 ID
     */
    public final TableField<MessageRecord, Long> RECEIVER_ID = createField(DSL.name("receiver_id"), SQLDataType.BIGINT, this, "接收人 ID");

    /**
     * The column <code>public.t_message.group_id</code>. 群 ID
     */
    public final TableField<MessageRecord, Long> GROUP_ID = createField(DSL.name("group_id"), SQLDataType.BIGINT, this, "群 ID");

    /**
     * The column <code>public.t_message.kind</code>. 消息类型
     * 0: 私人消息
     * 1: 群组消息
     * 8: 系统消息-单人
     * 9: 系统消息-群组
     */
    public final TableField<MessageRecord, Short> KIND = createField(DSL.name("kind"), SQLDataType.SMALLINT.nullable(false).defaultValue(DSL.field("0", SQLDataType.SMALLINT)), this, "消息类型\n0: 私人消息\n1: 群组消息\n8: 系统消息-单人\n9: 系统消息-群组");

    /**
     * The column <code>public.t_message.content</code>. 消息内容
     */
    public final TableField<MessageRecord, String> CONTENT = createField(DSL.name("content"), SQLDataType.VARCHAR(4096), this, "消息内容");

    /**
     * The column <code>public.t_message.content_type</code>. 消息内容类型
     * 0: 文本消息
     * 1: 图片消息
     * 2: 音频消息
     * 3: 视频消息
     */
    public final TableField<MessageRecord, Short> CONTENT_TYPE = createField(DSL.name("content_type"), SQLDataType.SMALLINT.nullable(false).defaultValue(DSL.field("0", SQLDataType.SMALLINT)), this, "消息内容类型\n0: 文本消息\n1: 图片消息\n2: 音频消息\n3: 视频消息");

    /**
     * The column <code>public.t_message.extra_args</code>. 扩展参数
     */
    public final TableField<MessageRecord, String> EXTRA_ARGS = createField(DSL.name("extra_args"), SQLDataType.VARCHAR(2048), this, "扩展参数");

    /**
     * The column <code>public.t_message.unread</code>. 消息是否未读
     * 0: 已读
     * 1: 未读
     */
    public final TableField<MessageRecord, Short> UNREAD = createField(DSL.name("unread"), SQLDataType.SMALLINT.defaultValue(DSL.field("0", SQLDataType.SMALLINT)), this, "消息是否未读\n0: 已读\n1: 未读");

    /**
     * The column <code>public.t_message.create_time</code>. 创建时间
     */
    public final TableField<MessageRecord, LocalDateTime> CREATE_TIME = createField(DSL.name("create_time"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "创建时间");

    /**
     * The column <code>public.t_message.update_time</code>. 更新时间
     */
    public final TableField<MessageRecord, LocalDateTime> UPDATE_TIME = createField(DSL.name("update_time"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "更新时间");

    private Message(Name alias, Table<MessageRecord> aliased) {
        this(alias, aliased, null);
    }

    private Message(Name alias, Table<MessageRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("消息表"), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.t_message</code> table reference
     */
    public Message(String alias) {
        this(DSL.name(alias), MESSAGE);
    }

    /**
     * Create an aliased <code>public.t_message</code> table reference
     */
    public Message(Name alias) {
        this(alias, MESSAGE);
    }

    /**
     * Create a <code>public.t_message</code> table reference
     */
    public Message() {
        this(DSL.name("t_message"), null);
    }

    public <O extends Record> Message(Table<O> child, ForeignKey<O, MessageRecord> key) {
        super(child, key, MESSAGE);
    }

    @Override
    @Nonnull
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    @Nonnull
    public Message as(String alias) {
        return new Message(DSL.name(alias), this);
    }

    @Override
    @Nonnull
    public Message as(Name alias) {
        return new Message(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    @Nonnull
    public Message rename(String name) {
        return new Message(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    @Nonnull
    public Message rename(Name name) {
        return new Message(name, null);
    }

    // -------------------------------------------------------------------------
    // Row11 type methods
    // -------------------------------------------------------------------------

    @Override
    @Nonnull
    public Row11<String, Long, Long, Long, Short, String, Short, String, Short, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row11) super.fieldsRow();
    }
}