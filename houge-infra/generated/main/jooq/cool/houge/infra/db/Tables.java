/*
 * This file is generated by jOOQ.
 */
package cool.houge.infra.db;


import cool.houge.infra.db.tables.Group;
import cool.houge.infra.db.tables.GroupMember;
import cool.houge.infra.db.tables.JwtSecret;
import cool.houge.infra.db.tables.Message;
import cool.houge.infra.db.tables.ServerInstance;
import cool.houge.infra.db.tables.User;
import cool.houge.infra.db.tables.UserMessage;

import javax.annotation.processing.Generated;


/**
 * Convenience access to all tables in public.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.15.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * 群信息
     */
    public static final Group GROUP = Group.GROUP;

    /**
     * 群成员
     */
    public static final GroupMember GROUP_MEMBER = GroupMember.GROUP_MEMBER;

    /**
     * JWT 密钥
     */
    public static final JwtSecret JWT_SECRET = JwtSecret.JWT_SECRET;

    /**
     * 消息表
     */
    public static final Message MESSAGE = Message.MESSAGE;

    /**
     * 服务实例信息
     */
    public static final ServerInstance SERVER_INSTANCE = ServerInstance.SERVER_INSTANCE;

    /**
     * The table <code>public.t_user</code>.
     */
    public static final User USER = User.USER;

    /**
     * 用户消息关联
     */
    public static final UserMessage USER_MESSAGE = UserMessage.USER_MESSAGE;
}
