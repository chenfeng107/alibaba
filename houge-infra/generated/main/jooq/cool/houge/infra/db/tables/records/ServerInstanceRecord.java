/*
 * This file is generated by jOOQ.
 */
package cool.houge.infra.db.tables.records;


import cool.houge.infra.db.tables.ServerInstance;

import java.time.LocalDateTime;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record16;
import org.jooq.Row16;
import org.jooq.impl.TableRecordImpl;


/**
 * 服务实例信息
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.15.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ServerInstanceRecord extends TableRecordImpl<ServerInstanceRecord> implements Record16<Integer, String, String, String, String, String, String, String, String, String, String, String, Long, Integer, LocalDateTime, LocalDateTime> {

    /**
     * Setter for <code>public.t_server_instance.id</code>. 主键
     */
    public void setId(@Nonnull Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.t_server_instance.id</code>. 主键
     */
    @Nonnull
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.t_server_instance.app_name</code>. 应用名称
     */
    public void setAppName(@Nonnull String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.t_server_instance.app_name</code>. 应用名称
     */
    @Nonnull
    public String getAppName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.t_server_instance.host_name</code>. 主机名称
     */
    public void setHostName(@Nonnull String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.t_server_instance.host_name</code>. 主机名称
     */
    @Nonnull
    public String getHostName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.t_server_instance.host_address</code>. 主机 IP 地址
     */
    public void setHostAddress(@Nonnull String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.t_server_instance.host_address</code>. 主机 IP 地址
     */
    @Nonnull
    public String getHostAddress() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.t_server_instance.os_name</code>. 系统名称
     */
    public void setOsName(@Nullable String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.t_server_instance.os_name</code>. 系统名称
     */
    @Nullable
    public String getOsName() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.t_server_instance.os_version</code>. 系统版本
     */
    public void setOsVersion(@Nonnull String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.t_server_instance.os_version</code>. 系统版本
     */
    @Nonnull
    public String getOsVersion() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.t_server_instance.os_arch</code>. OS Arch
     */
    public void setOsArch(@Nonnull String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.t_server_instance.os_arch</code>. OS Arch
     */
    @Nonnull
    public String getOsArch() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.t_server_instance.os_user</code>. 系统的用户名
     */
    public void setOsUser(@Nullable String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.t_server_instance.os_user</code>. 系统的用户名
     */
    @Nullable
    public String getOsUser() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.t_server_instance.java_vm_name</code>. Java 虚拟机名称
     */
    public void setJavaVmName(@Nonnull String value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.t_server_instance.java_vm_name</code>. Java 虚拟机名称
     */
    @Nonnull
    public String getJavaVmName() {
        return (String) get(8);
    }

    /**
     * Setter for <code>public.t_server_instance.java_vm_version</code>. Java
     * 虚拟机版本
     */
    public void setJavaVmVersion(@Nonnull String value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.t_server_instance.java_vm_version</code>. Java
     * 虚拟机版本
     */
    @Nonnull
    public String getJavaVmVersion() {
        return (String) get(9);
    }

    /**
     * Setter for <code>public.t_server_instance.java_vm_vendor</code>. Java
     * 虚拟机供应商
     */
    public void setJavaVmVendor(@Nonnull String value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.t_server_instance.java_vm_vendor</code>. Java
     * 虚拟机供应商
     */
    @Nonnull
    public String getJavaVmVendor() {
        return (String) get(10);
    }

    /**
     * Setter for <code>public.t_server_instance.work_dir</code>. 服务的工作目录
     */
    public void setWorkDir(@Nonnull String value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.t_server_instance.work_dir</code>. 服务的工作目录
     */
    @Nonnull
    public String getWorkDir() {
        return (String) get(11);
    }

    /**
     * Setter for <code>public.t_server_instance.pid</code>. 进程 ID
     */
    public void setPid(@Nonnull Long value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.t_server_instance.pid</code>. 进程 ID
     */
    @Nonnull
    public Long getPid() {
        return (Long) get(12);
    }

    /**
     * Setter for <code>public.t_server_instance.ver</code>. 数据版本
     */
    public void setVer(@Nonnull Integer value) {
        set(13, value);
    }

    /**
     * Getter for <code>public.t_server_instance.ver</code>. 数据版本
     */
    @Nonnull
    public Integer getVer() {
        return (Integer) get(13);
    }

    /**
     * Setter for <code>public.t_server_instance.create_time</code>. 创建时间
     */
    public void setCreateTime(@Nonnull LocalDateTime value) {
        set(14, value);
    }

    /**
     * Getter for <code>public.t_server_instance.create_time</code>. 创建时间
     */
    @Nonnull
    public LocalDateTime getCreateTime() {
        return (LocalDateTime) get(14);
    }

    /**
     * Setter for <code>public.t_server_instance.check_time</code>.
     * 最后检查时间，与当前时间相差超过1小时则默认服务已销毁
     */
    public void setCheckTime(@Nonnull LocalDateTime value) {
        set(15, value);
    }

    /**
     * Getter for <code>public.t_server_instance.check_time</code>.
     * 最后检查时间，与当前时间相差超过1小时则默认服务已销毁
     */
    @Nonnull
    public LocalDateTime getCheckTime() {
        return (LocalDateTime) get(15);
    }

    // -------------------------------------------------------------------------
    // Record16 type implementation
    // -------------------------------------------------------------------------

    @Override
    @Nonnull
    public Row16<Integer, String, String, String, String, String, String, String, String, String, String, String, Long, Integer, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row16) super.fieldsRow();
    }

    @Override
    @Nonnull
    public Row16<Integer, String, String, String, String, String, String, String, String, String, String, String, Long, Integer, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row16) super.valuesRow();
    }

    @Override
    @Nonnull
    public Field<Integer> field1() {
        return ServerInstance.SERVER_INSTANCE.ID;
    }

    @Override
    @Nonnull
    public Field<String> field2() {
        return ServerInstance.SERVER_INSTANCE.APP_NAME;
    }

    @Override
    @Nonnull
    public Field<String> field3() {
        return ServerInstance.SERVER_INSTANCE.HOST_NAME;
    }

    @Override
    @Nonnull
    public Field<String> field4() {
        return ServerInstance.SERVER_INSTANCE.HOST_ADDRESS;
    }

    @Override
    @Nonnull
    public Field<String> field5() {
        return ServerInstance.SERVER_INSTANCE.OS_NAME;
    }

    @Override
    @Nonnull
    public Field<String> field6() {
        return ServerInstance.SERVER_INSTANCE.OS_VERSION;
    }

    @Override
    @Nonnull
    public Field<String> field7() {
        return ServerInstance.SERVER_INSTANCE.OS_ARCH;
    }

    @Override
    @Nonnull
    public Field<String> field8() {
        return ServerInstance.SERVER_INSTANCE.OS_USER;
    }

    @Override
    @Nonnull
    public Field<String> field9() {
        return ServerInstance.SERVER_INSTANCE.JAVA_VM_NAME;
    }

    @Override
    @Nonnull
    public Field<String> field10() {
        return ServerInstance.SERVER_INSTANCE.JAVA_VM_VERSION;
    }

    @Override
    @Nonnull
    public Field<String> field11() {
        return ServerInstance.SERVER_INSTANCE.JAVA_VM_VENDOR;
    }

    @Override
    @Nonnull
    public Field<String> field12() {
        return ServerInstance.SERVER_INSTANCE.WORK_DIR;
    }

    @Override
    @Nonnull
    public Field<Long> field13() {
        return ServerInstance.SERVER_INSTANCE.PID;
    }

    @Override
    @Nonnull
    public Field<Integer> field14() {
        return ServerInstance.SERVER_INSTANCE.VER;
    }

    @Override
    @Nonnull
    public Field<LocalDateTime> field15() {
        return ServerInstance.SERVER_INSTANCE.CREATE_TIME;
    }

    @Override
    @Nonnull
    public Field<LocalDateTime> field16() {
        return ServerInstance.SERVER_INSTANCE.CHECK_TIME;
    }

    @Override
    @Nonnull
    public Integer component1() {
        return getId();
    }

    @Override
    @Nonnull
    public String component2() {
        return getAppName();
    }

    @Override
    @Nonnull
    public String component3() {
        return getHostName();
    }

    @Override
    @Nonnull
    public String component4() {
        return getHostAddress();
    }

    @Override
    @Nullable
    public String component5() {
        return getOsName();
    }

    @Override
    @Nonnull
    public String component6() {
        return getOsVersion();
    }

    @Override
    @Nonnull
    public String component7() {
        return getOsArch();
    }

    @Override
    @Nullable
    public String component8() {
        return getOsUser();
    }

    @Override
    @Nonnull
    public String component9() {
        return getJavaVmName();
    }

    @Override
    @Nonnull
    public String component10() {
        return getJavaVmVersion();
    }

    @Override
    @Nonnull
    public String component11() {
        return getJavaVmVendor();
    }

    @Override
    @Nonnull
    public String component12() {
        return getWorkDir();
    }

    @Override
    @Nonnull
    public Long component13() {
        return getPid();
    }

    @Override
    @Nonnull
    public Integer component14() {
        return getVer();
    }

    @Override
    @Nonnull
    public LocalDateTime component15() {
        return getCreateTime();
    }

    @Override
    @Nonnull
    public LocalDateTime component16() {
        return getCheckTime();
    }

    @Override
    @Nonnull
    public Integer value1() {
        return getId();
    }

    @Override
    @Nonnull
    public String value2() {
        return getAppName();
    }

    @Override
    @Nonnull
    public String value3() {
        return getHostName();
    }

    @Override
    @Nonnull
    public String value4() {
        return getHostAddress();
    }

    @Override
    @Nullable
    public String value5() {
        return getOsName();
    }

    @Override
    @Nonnull
    public String value6() {
        return getOsVersion();
    }

    @Override
    @Nonnull
    public String value7() {
        return getOsArch();
    }

    @Override
    @Nullable
    public String value8() {
        return getOsUser();
    }

    @Override
    @Nonnull
    public String value9() {
        return getJavaVmName();
    }

    @Override
    @Nonnull
    public String value10() {
        return getJavaVmVersion();
    }

    @Override
    @Nonnull
    public String value11() {
        return getJavaVmVendor();
    }

    @Override
    @Nonnull
    public String value12() {
        return getWorkDir();
    }

    @Override
    @Nonnull
    public Long value13() {
        return getPid();
    }

    @Override
    @Nonnull
    public Integer value14() {
        return getVer();
    }

    @Override
    @Nonnull
    public LocalDateTime value15() {
        return getCreateTime();
    }

    @Override
    @Nonnull
    public LocalDateTime value16() {
        return getCheckTime();
    }

    @Override
    @Nonnull
    public ServerInstanceRecord value1(@Nonnull Integer value) {
        setId(value);
        return this;
    }

    @Override
    @Nonnull
    public ServerInstanceRecord value2(@Nonnull String value) {
        setAppName(value);
        return this;
    }

    @Override
    @Nonnull
    public ServerInstanceRecord value3(@Nonnull String value) {
        setHostName(value);
        return this;
    }

    @Override
    @Nonnull
    public ServerInstanceRecord value4(@Nonnull String value) {
        setHostAddress(value);
        return this;
    }

    @Override
    @Nonnull
    public ServerInstanceRecord value5(@Nullable String value) {
        setOsName(value);
        return this;
    }

    @Override
    @Nonnull
    public ServerInstanceRecord value6(@Nonnull String value) {
        setOsVersion(value);
        return this;
    }

    @Override
    @Nonnull
    public ServerInstanceRecord value7(@Nonnull String value) {
        setOsArch(value);
        return this;
    }

    @Override
    @Nonnull
    public ServerInstanceRecord value8(@Nullable String value) {
        setOsUser(value);
        return this;
    }

    @Override
    @Nonnull
    public ServerInstanceRecord value9(@Nonnull String value) {
        setJavaVmName(value);
        return this;
    }

    @Override
    @Nonnull
    public ServerInstanceRecord value10(@Nonnull String value) {
        setJavaVmVersion(value);
        return this;
    }

    @Override
    @Nonnull
    public ServerInstanceRecord value11(@Nonnull String value) {
        setJavaVmVendor(value);
        return this;
    }

    @Override
    @Nonnull
    public ServerInstanceRecord value12(@Nonnull String value) {
        setWorkDir(value);
        return this;
    }

    @Override
    @Nonnull
    public ServerInstanceRecord value13(@Nonnull Long value) {
        setPid(value);
        return this;
    }

    @Override
    @Nonnull
    public ServerInstanceRecord value14(@Nonnull Integer value) {
        setVer(value);
        return this;
    }

    @Override
    @Nonnull
    public ServerInstanceRecord value15(@Nonnull LocalDateTime value) {
        setCreateTime(value);
        return this;
    }

    @Override
    @Nonnull
    public ServerInstanceRecord value16(@Nonnull LocalDateTime value) {
        setCheckTime(value);
        return this;
    }

    @Override
    @Nonnull
    public ServerInstanceRecord values(@Nonnull Integer value1, @Nonnull String value2, @Nonnull String value3, @Nonnull String value4, @Nullable String value5, @Nonnull String value6, @Nonnull String value7, @Nullable String value8, @Nonnull String value9, @Nonnull String value10, @Nonnull String value11, @Nonnull String value12, @Nonnull Long value13, @Nonnull Integer value14, @Nonnull LocalDateTime value15, @Nonnull LocalDateTime value16) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ServerInstanceRecord
     */
    public ServerInstanceRecord() {
        super(ServerInstance.SERVER_INSTANCE);
    }

    /**
     * Create a detached, initialised ServerInstanceRecord
     */
    public ServerInstanceRecord(@Nonnull Integer id, @Nonnull String appName, @Nonnull String hostName, @Nonnull String hostAddress, @Nullable String osName, @Nonnull String osVersion, @Nonnull String osArch, @Nullable String osUser, @Nonnull String javaVmName, @Nonnull String javaVmVersion, @Nonnull String javaVmVendor, @Nonnull String workDir, @Nonnull Long pid, @Nonnull Integer ver, @Nonnull LocalDateTime createTime, @Nonnull LocalDateTime checkTime) {
        super(ServerInstance.SERVER_INSTANCE);

        setId(id);
        setAppName(appName);
        setHostName(hostName);
        setHostAddress(hostAddress);
        setOsName(osName);
        setOsVersion(osVersion);
        setOsArch(osArch);
        setOsUser(osUser);
        setJavaVmName(javaVmName);
        setJavaVmVersion(javaVmVersion);
        setJavaVmVendor(javaVmVendor);
        setWorkDir(workDir);
        setPid(pid);
        setVer(ver);
        setCreateTime(createTime);
        setCheckTime(checkTime);
    }
}
